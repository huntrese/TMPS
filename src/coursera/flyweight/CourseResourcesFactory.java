package coursera.flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
public class CourseResourcesFactory {
    private static final Map<String, CourseResources> resourcesMap = new HashMap<>();

    public static CourseResources getCourseResources(CourseType courseType) {
        CourseResources resources = resourcesMap.get(courseType.name());

        if (resources == null) {
            resources = switch (courseType) {
                case PYTHON -> new CourseResources(
                        "Python",
                        "https://docs.python.org/3/",
                        "https://discuss.python.org/",
                        "https://pypi.org/",
                        "python.support@coursera.com",
                        "print(\"Hello World\")"
                );
                case JAVA -> new CourseResources(
                        "Java",
                        "https://docs.oracle.com/en/java/",
                        "https://community.oracle.com/tech/developers/categories/java",
                        "https://maven.apache.org/",
                        "java.support@coursera.com",
                        """
                        public class Main {
                            public static void main(String[] args) {
                                System.out.println("Hello World");
                            }
                        }
                        """
                );
            };
            resourcesMap.put(courseType.name(), resources);
        }
        return resources;
    }
}
