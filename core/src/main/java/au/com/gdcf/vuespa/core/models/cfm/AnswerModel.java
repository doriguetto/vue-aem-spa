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
import java.util.Iterator;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerModel {

  @Self
  protected Resource resource;

  @SlingObject
  protected ResourceResolver resourceResolver;

  protected String eq;
  protected QuestionModel eqNextRef;
  protected String lt;
  protected QuestionModel ltNextRef;
  protected String gt;
  protected QuestionModel gtNextRef;
  protected String label;
  protected String value;
  protected String variableName;

  @PostConstruct
  protected void init() {
    ContentFragment contentFragment = resource.adaptTo(ContentFragment.class);
    if (contentFragment != null) {
      for (Iterator<ContentElement> it = contentFragment.getElements(); it.hasNext(); ) {
        ContentElement element = it.next();
        if (StringUtils.isEmpty(element.getContent()))
          continue;
        if (element.getName().equals("eq")) {
          eq = element.getContent();
        } else if (element.getName().equals("eqNextQuestion")) {
          Resource questionResource = resourceResolver.getResource(element.getContent());
          if (questionResource != null) {
            eqNextRef = questionResource.adaptTo(QuestionModel.class);
          }
        } else if (element.getName().equals("lt")) {
          lt = element.getContent();
        } else if (element.getName().equals("ltNextQuestion")) {
          Resource questionResource = resourceResolver.getResource(element.getContent());
          if (questionResource != null) {
            ltNextRef = questionResource.adaptTo(QuestionModel.class);
          }
        } else if (element.getName().equals("gt")) {
          gt = element.getContent();
        } else if (element.getName().equals("gtNextQuestion")) {
          Resource questionResource = resourceResolver.getResource(element.getContent());
          if (questionResource != null) {
            gtNextRef = questionResource.adaptTo(QuestionModel.class);
          }
        } else if (element.getName().equals("label")) {
          label = element.getContent();
        } else if (element.getName().equals("value")) {
          value = element.getContent();
        } else if (element.getName().equals("variableName")) {
          variableName = element.getContent();
        }
      }
    }
  }

  public String getEq() {
    return eq;
  }

  public QuestionModel getEqNextRef() {
    return eqNextRef;
  }

  public String getLt() {
    return lt;
  }

  public QuestionModel getLtNextRef() {
    return ltNextRef;
  }

  public String getGt() {
    return gt;
  }

  public QuestionModel getGtNextRef() {
    return gtNextRef;
  }

  public String getLabel() {
    return label;
  }

  public String getValue() {
    return value;
  }

  public String getVariableName() { return variableName; }
}
