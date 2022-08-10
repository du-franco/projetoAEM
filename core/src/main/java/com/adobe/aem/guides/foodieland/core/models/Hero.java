package com.adobe.aem.guides.foodieland.core.models;

import com.adobe.cq.export.json.ComponentExporter;

import java.util.Date;

import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { ComponentExporter.class }, resourceType = {
        "foodieland/components/content/hero" }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = { "json" })
public class Hero
        implements ComponentExporter {
    protected static final String RESOURCE_TYPE = "foodieland/components/content/hero";
    @ValueMapValue(name = "jcr:title")
    private String title;

    @ValueMapValue
    private String heading;

    @ValueMapValue
    private String buttonLabel;

    @ValueMapValue
    private String buttonLinkTo;

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String fileReference2;

    @ValueMapValue
    private String fileReference3;

    @ValueMapValue
    private String prepareTime;

    @ValueMapValue
    private String author;

    @ValueMapValue
    private Date date;

    @ValueMapValue
    private Boolean hotRecipes;

    @ValueMapValue
    private String mainIngredient;
    
    @ScriptVariable
    protected Resource resource;
    private String imgPath;

    public Hero() {
    }

    @PostConstruct
    private void initModel() {
        imgPath = fileReference;
        if ((imgPath == null) && (resource != null)) {
            Resource res = resource.getChild("file");
            if (res != null) {
                imgPath = res.getPath();
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public String getHeading() {
        return heading;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    public String getButtonLinkTo() {
        return buttonLinkTo;
    }

    public String getImagePath() {
        return imgPath;
    }

    public String getFileReference2() {
        return fileReference2;
    }

    public String getFileReference3() {
        return fileReference3;
    }

    public String getPrepareTime() {
        return prepareTime;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public Boolean getHotRecipes(){
        if(hotRecipes == true){
            return this.hotRecipes;
        }
        return false;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public String getAlt() {
        return "Example Alt Text";
    }

    public String getExportedType() {
        return resource.getResourceType();
    }
}
