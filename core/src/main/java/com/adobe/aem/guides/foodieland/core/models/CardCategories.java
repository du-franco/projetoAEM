package com.adobe.aem.guides.foodieland.core.models;


import org.apache.sling.api.resource.Resource;
import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { ComponentExporter.class }, resourceType = {
        "foodieland/components/content/cardcategories" }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = { "json" })
public class CardCategories
        implements ComponentExporter {
    protected static final String RESOURCE_TYPE = "foodieland/components/content/cardcategories";
   
    @ValueMapValue
    private String cardName;

    @ValueMapValue
    private String fileReference;

    
    @ScriptVariable
    protected Resource resource;

    public CardCategories() {
    }

    
    public String getFileReference() {
        return fileReference;
    }

    public String getCardName(){
        return cardName;
    }

    public String getAlt() {
        return "Example Alt Text";
    }

    public String getExportedType() {
        return resource.getResourceType();
    }
}