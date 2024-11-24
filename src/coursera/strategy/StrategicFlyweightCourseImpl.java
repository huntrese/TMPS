package coursera.strategy;

import coursera.flyweight.CourseResources;
import coursera.flyweight.CourseResourcesFactory;
import coursera.flyweight.CourseType;
import coursera.flyweight.FlyweightCourse;

public class StrategicFlyweightCourseImpl implements FlyweightCourse {
    private final CourseResources resources;
    private final CourseType courseType;
    private final String courseName;
    private final String courseId;
    private CourseStructureStrategy structureStrategy;

    public StrategicFlyweightCourseImpl(CourseType courseType, String courseName) {
        this.courseType = courseType;
        this.resources = CourseResourcesFactory.getCourseResources(courseType);
        this.courseName = courseName;
        this.courseId = generateCourseId(courseType, courseName);
        // Default to standard strategy
        this.structureStrategy = new StandardCourseStrategy();
    }

    public void setStructureStrategy(CourseStructureStrategy strategy) {
        this.structureStrategy = strategy;
    }

    private String generateCourseId(CourseType type, String name) {
        return type.name().substring(0, 3).toUpperCase() +
                "_" +
                name.replaceAll("\\s+", "_").toUpperCase() +
                "_" +
                System.currentTimeMillis() % 10000;
    }

    @Override
    public void createCourse() {
        System.out.println("""
                Welcome to %s: %s
                Course ID: %s
                Programming Language: %s
                Structure Type: %s
                        
                Here's your starter program:
                %s
                        
                Useful resources:
                Documentation: %s
                Community Forum: %s
                Package Repository: %s
                Support: %s
                """
                .formatted(
                        resources.getProgrammingLanguage(),
                        courseName,
                        courseId,
                        resources.getProgrammingLanguage(),
                        structureStrategy.getStructureType(),
                        resources.getHelloWorldExample(),
                        resources.getDocumentationUrl(),
                        resources.getForumUrl(),
                        resources.getResourcesUrl(),
                        resources.getSupportEmail()
                ));

        // Apply the selected course structure strategy
        structureStrategy.createCourseStructure(courseName);
    }

    @Override
    public String getName() {
        return String.format("%s - %s (%s)",
                resources.getProgrammingLanguage(),
                courseName,
                courseId
        );
    }

    @Override
    public CourseType getCourseType() {
        return courseType;
    }

    @Override
    public CourseResources getResources() {
        return resources;
    }
}
