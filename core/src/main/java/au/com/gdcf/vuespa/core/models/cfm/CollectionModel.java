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

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollectionModel {

  @Self
  protected Resource resource;

  @SlingObject
  protected ResourceResolver resourceResolver;

  protected List<QuestionModel> questions;
  protected String title;
  protected String description;

  @PostConstruct
  protected void init() {
    ContentFragment contentFragment = resource.adaptTo(ContentFragment.class);
    if (contentFragment != null) {
      for (Iterator<ContentElement> it = contentFragment.getElements(); it.hasNext(); ) {
        ContentElement element = it.next();
        if (StringUtils.isEmpty(element.getContent()))
          continue;
        if (element.getName().equals("questions")) {
          String contentPaths = element.getContent();
          if (contentPaths != null) {
            questions = new ArrayList<>();
            String[] paths = contentPaths.split("\n");
            for(String path: paths) {
              Resource questionResource = resourceResolver.getResource(path);
              if (questionResource != null) {
                QuestionModel q = questionResource.adaptTo(QuestionModel.class);
                questions.add(q);
              }
            }
          }
        } else if (element.getName().equals("title")) {
          title = element.getContent();
        } else if (element.getName().equals("description")) {
          description = element.getContent();
        }
      }
    }
  }

  public List<QuestionModel> getQuestions() {
    return questions;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }
}
