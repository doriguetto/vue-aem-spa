/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2019 Adobe
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package au.com.gdcf.vuespa.core.models.content;

import au.com.gdcf.vuespa.core.models.adapters.ContainerExporter;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.LayoutContainer;
import com.day.cq.wcm.api.TemplatedResource;
import com.day.cq.wcm.api.designer.Style;

import com.day.cq.wcm.foundation.model.responsivegrid.ResponsiveGrid;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Layout container model implementation.
 */
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
    @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
  }
)
@Model(adaptables = SlingHttpServletRequest.class, adapters = { ContainerExporter.class, ComponentExporter.class} , resourceType = Container.RESOURCE_TYPE)
@JsonSerialize(as = ContainerExporter.class)
public class Container extends ResponsiveGrid implements ContainerExporter, LayoutContainer {

  /**
   * The resource type.
   */
  protected static final String RESOURCE_TYPE = "vue-aem-spa/components/content/container";

  @Nonnull
  public String getExportedType() {
    // This method is required by ComponentExporter and its value populates the `:type` key in the JSON object.
    // The resource value is ~always the ResourceType for this model (See @Model(..) above).
    return request.getResource().getResourceType();
  }

  @Self
  protected SlingHttpServletRequest request;

  @Self @Via(type = ResourceSuperType.class)
  private LayoutContainer layoutContainer;

  public String getBackgroundStyle() {
    return layoutContainer.getBackgroundStyle();
  }

  public String getId() {
    return layoutContainer.getId();
  }

}
