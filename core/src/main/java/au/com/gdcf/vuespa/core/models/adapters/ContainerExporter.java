package au.com.gdcf.vuespa.core.models.adapters;

import com.day.cq.wcm.foundation.model.responsivegrid.export.ResponsiveGridExporter;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.osgi.annotation.versioning.ProviderType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ProviderType
public interface ContainerExporter extends ResponsiveGridExporter {

   String getBackgroundStyle();
   String getId();

}
