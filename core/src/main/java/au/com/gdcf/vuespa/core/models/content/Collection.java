package au.com.gdcf.vuespa.core.models.content;

import au.com.gdcf.vuespa.core.models.cfm.CollectionModel;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;


/**
 * This file focuses on making a Sling Model compatible with AEM Content Services (and thus SPA Editor), as this requires:
 * a) Implementing the ComponentExporter interface.
 *
 * Note that these is a sibling interface to ComponentExporter, com.adobe.cq.export.json.ContainerExporter, that is used for components that included other components (like the Layout Container).
 *
 * For more detailed examples of Sling Models and Sling Model Exporters, see this file's sibling sample files (SampleSlingModel.class and SampleSlingModelExporter.class).
 */
@Model(
        // This must adapt from a SlingHttpServletRequest, since this is invoked directly via a request, and not via a resource.
        // If can specify Resource.class as a second adaptable as needed
        adaptables = { SlingHttpServletRequest.class },

        // This Model should have the specific Model class (SampleComponentExporter.class)
        // AS WELL AS the ComponentExporter.class. Its required that ComponentExporter.class to be set at an adapter
        // since this how the AEM Content Services JSON Exporter figures out which resources to serialize.
        adapters = { Collection.class, ComponentExporter.class },

        // The resourceType is required if you want Sling to "naturally" expose this model as the exporter for a Resource.
        resourceType = Collection.RESOURCE_TYPE,

        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporters({
        @Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
                selector = ExporterConstants.SLING_MODEL_SELECTOR, // The default is 'model', this is just reiterating this.
                extensions = ExporterConstants.SLING_MODEL_EXTENSION,
                options = {   // options are optional... this just shows that it is possible...
                        /**
                         * Jackson options:
                         * - Mapper Features: http://static.javadoc.io/com.fasterxml.jackson.core/jackson-databind/2.8.5/com/fasterxml/jackson/databind/MapperFeature.html
                         * - Serialization Features: http://static.javadoc.io/com.fasterxml.jackson.core/jackson-databind/2.8.5/com/fasterxml/jackson/databind/SerializationFeature.html
                         */
                        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
                        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value = "false")
                }),
        @Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
                selector = "questions", // The default is 'model', this is just reiterating this.
                extensions = ExporterConstants.SLING_MODEL_EXTENSION)
})
// Mark as JSON Serializable as the Model's class (SampleComponentExporter.class) or interface if those are used.
@JsonSerialize(as = Collection.class)

public class Collection implements ComponentExporter {

  static final String RESOURCE_TYPE = "vue-aem-spa/components/cfm/collection";

  @Self
  private SlingHttpServletRequest request;

  @SlingObject
  private Resource resource;

  @SlingObject
  private ResourceResolver resourceResolver;

  @Nonnull
  public String getExportedType() {
    // This method is required by ComponentExporter and its value populates the `:type` key in the JSON object.
    // The resource value is ~always the ResourceType for this model (See @Model(..) above).
    return request.getResource().getResourceType();
  }

  @ValueMapValue
  protected String collection;

  protected CollectionModel model;
  protected String collectionModelPath;

  @PostConstruct
  protected void init() {

    String[] selectors = request.getRequestPathInfo().getSelectors();
    if (collection != null && selectors.length == 1 && selectors[0].equals("questions")) {
      Resource collectionResource = resourceResolver.getResource(collection);
      model = collectionResource.adaptTo(CollectionModel.class);
    } else {
      collectionModelPath = resource.getPath() + ".questions.json";
    }
  }

  public String getCollection() {
    return collectionModelPath;
  }

  public CollectionModel getModel() {
    return model;
  }
}
