package au.com.gdcf.vuespa.core.models.cfm;

import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.xfa.ut.StringUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductModel {

  @SlingObject
  protected ResourceResolver resourceResolver;

  @ValueMapValue
  private String variationName;

  @ValueMapValue
  private String fragmentPath;

  @ValueMapValue
  private List<String> elementNames;

  protected List<ProductInteractionsModel> productActions;
  protected List<ProductInteractionsModel> coverAmountActions;
  protected List<ProductInteractionsModel> coverOptionsActions;
  protected String title;
  protected String description;
  protected String tooltip;

  @PostConstruct
  protected void init() {
    Resource resource = resourceResolver.getResource(fragmentPath);
    if (resource != null) {
      ContentFragment contentFragment = resource.adaptTo(ContentFragment.class);
      if (contentFragment != null) {
        for (Iterator<ContentElement> it = contentFragment.getElements(); it.hasNext(); ) {
          ContentElement element = it.next();
          if (StringUtils.isEmpty(element.getContent()))
            continue;
          if (containsElement(element, "title")) {
            title = element.getContent();
          } else if (containsElement(element, "description")) {
            description = element.getContent();
          } else if (containsElement(element, "tooltip")) {
            tooltip = element.getContent();
          } else if (containsElement(element, "productActions")) {
            String contentPaths = element.getContent();
            if (contentPaths != null) {
              productActions = new ArrayList<>();
              String[] paths = contentPaths.split("\n");
              for (String path : paths) {
                Resource productActionsResource = resourceResolver.getResource(path);
                if (productActionsResource != null) {
                  ProductInteractionsModel q = productActionsResource.adaptTo(ProductInteractionsModel.class);
                  productActions.add(q);
                }
              }
            }
          } else if (containsElement(element, "coverAmountActions")) {
            String contentPaths = element.getContent();
            coverAmountActions = new ArrayList<>();
            String[] paths = contentPaths.split("\n");
            for (String path : paths) {
              Resource coverAmountActionsResource = resourceResolver.getResource(path);
              if (coverAmountActionsResource != null) {
                ProductInteractionsModel q = coverAmountActionsResource.adaptTo(ProductInteractionsModel.class);
                coverAmountActions.add(q);
              }
            }
          } else if (containsElement(element, "coverOptionsActions")) {
            String contentPaths = element.getContent();
            coverOptionsActions = new ArrayList<>();
            String[] paths = contentPaths.split("\n");
            for (String path : paths) {
              Resource overOptionsActionResource = resourceResolver.getResource(path);
              if (overOptionsActionResource != null) {
                ProductInteractionsModel q = overOptionsActionResource.adaptTo(ProductInteractionsModel.class);
                coverOptionsActions.add(q);
              }
            }
          }
        }
      }
    }
  }

  private boolean containsElement(ContentElement element, String elementName) {
    return element != null &&
      element.getName() != null &&
      element.getName().equals(elementName) &&
      elementNames.contains(elementName);
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getTooltip() { return tooltip; }

  public List<ProductInteractionsModel> getProductActions() { return productActions; }

  public List<ProductInteractionsModel> getCoverAmountActions() { return coverAmountActions; }

  public List<ProductInteractionsModel> getCoverOptionsActions() { return coverOptionsActions; }

}
