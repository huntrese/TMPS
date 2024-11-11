package coursera.flyweight;

import java.util.HashMap;
import java.util.Map;

// The intrinsic state that will be shared
public class CourseResources {
    private final String documentationUrl;
    private final String forumUrl;
    private final String resourcesUrl;
    private final String supportEmail;
    private final String helloWorldExample;
    private final String programmingLanguage;

    public CourseResources(String programmingLanguage, String documentationUrl, String forumUrl,
                           String resourcesUrl, String supportEmail, String helloWorldExample) {
        this.programmingLanguage = programmingLanguage;
        this.documentationUrl = documentationUrl;
        this.forumUrl = forumUrl;
        this.resourcesUrl = resourcesUrl;
        this.supportEmail = supportEmail;
        this.helloWorldExample = helloWorldExample;
    }

    public String getDocumentationUrl() { return documentationUrl; }
    public String getForumUrl() { return forumUrl; }
    public String getResourcesUrl() { return resourcesUrl; }
    public String getSupportEmail() { return supportEmail; }
    public String getHelloWorldExample() { return helloWorldExample; }
    public String getProgrammingLanguage() { return programmingLanguage; }
}



