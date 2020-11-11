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
public class QuestionModel {

  @Self
  protected Resource resource;

  @SlingObject
  protected ResourceResolver resourceResolver;

  protected String label;
  protected String type;
  protected List<AnswerModel> answers;

  @PostConstruct
  protected void init() {
    ContentFragment contentFragment = resource.adaptTo(ContentFragment.class);
    if (contentFragment != null) {
      for (Iterator<ContentElement> it = contentFragment.getElements(); it.hasNext(); ) {
        ContentElement element = it.next();
        if (StringUtils.isEmpty(element.getContent()))
          continue;
        if (element.getName().equals("answers")) {
          String contentPaths = element.getContent();
          if (contentPaths != null) {
            answers = new ArrayList<>();
            String[] paths = contentPaths.split("\n");
            for (String path : paths) {
              Resource questionResource = resourceResolver.getResource(path);
              if (questionResource != null) {
                AnswerModel a = questionResource.adaptTo(AnswerModel.class);
                answers.add(a);
              }
            }
          }
        } else if (element.getName().equals("label")) {
          label = element.getContent();
        } else if (element.getName().equals("type")) {
          type = element.getContent();
        }
      }
    }
  }

  public String getLabel() {
    return label;
  }

  public List<AnswerModel> getAnswers() {
    return answers;
  }

  public String getType() {
    return type;
  }
}
