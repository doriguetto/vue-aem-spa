package au.com.gdcf.vuespa.core.models.cfm;

import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.xfa.ut.StringUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.Iterator;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductInteractionsModel {

  @Self
  protected Resource resource;

  @SlingObject
  protected ResourceResolver resourceResolver;

  protected String title;
  protected String productInteractions;
  protected String description;
  protected String tooltip;
  protected String reference;


  @PostConstruct
  protected void init() {
    ContentFragment contentFragment = resource.adaptTo(ContentFragment.class);
    if (contentFragment != null) {
      for (Iterator<ContentElement> it = contentFragment.getElements(); it.hasNext(); ) {
        ContentElement element = it.next();
        if (StringUtils.isEmpty(element.getContent()))
          continue;
        if (element.getName().equals("title")) {
          title = element.getContent();
        } else if (element.getName().equals("description")) {
          description = element.getContent();
        }  else if (element.getName().equals("tooltip")) {
          tooltip = element.getContent();
        }  else if (element.getName().equals("productInteractions")) {
          productInteractions = element.getContent();
        }  else if (element.getName().equals("reference")) {
          reference = element.getContent();
        }
      }
    }
  }


  public String getTitle() {
    return title;
  }

  public String getProductInteractions() {
    return productInteractions;
  }

  public String getDescription() {
    return description;
  }

  public String getTooltip() {
    return tooltip;
  }

  public String getReference() {
    return reference;
  }
}
