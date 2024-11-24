package coursera.state;

import coursera.flyweight.CourseResources;
import coursera.flyweight.CourseResourcesFactory;
import coursera.flyweight.CourseType;
import coursera.flyweight.FlyweightCourse;
import coursera.strategy.CourseStructureStrategy;
import coursera.strategy.StandardCourseStrategy;

public class StatefulStrategicCourseImpl implements FlyweightCourse {
    private final CourseResources resources;
    private final CourseType courseType;
    private final String courseName;
    private final String courseId;
    private CourseStructureStrategy structureStrategy;
    private final CourseContext courseContext;

    public StatefulStrategicCourseImpl(CourseType courseType, String courseName) {
        this.courseType = courseType;
        this.resources = CourseResourcesFactory.getCourseResources(courseType);
        this.courseName = courseName;
        this.courseId = generateCourseId(courseType, courseName);
        this.structureStrategy = new StandardCourseStrategy();
        this.courseContext = new CourseContext(courseName);
    }

    public void setStructureStrategy(CourseStructureStrategy strategy) {
        this.structureStrategy = strategy;
    }

    public CourseContext getCourseContext() {
        return courseContext;
    }

    public void publish() {
        courseContext.getState().publish(courseContext);
    }

    public void archive() {
        courseContext.getState().archive(courseContext);
    }

    public void makeDraft() {
        courseContext.getState().makeDraft(courseContext);
    }

    public void requestApproval() {
        courseContext.getState().requestApproval(courseContext);
    }

    public void makePrivate() {
        courseContext.getState().makePrivate(courseContext);
    }

    public void makePublic() {
        courseContext.getState().makePublic(courseContext);
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
                Current State: %s
                        
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
                        courseContext.getState().getStateName(),
                        resources.getHelloWorldExample(),
                        resources.getDocumentationUrl(),
                        resources.getForumUrl(),
                        resources.getResourcesUrl(),
                        resources.getSupportEmail()
                ));

        structureStrategy.createCourseStructure(courseName);
    }

    @Override
    public String getName() {
        return String.format("%s - %s (%s) [%s]",
                resources.getProgrammingLanguage(),
                courseName,
                courseId,
                courseContext.getState().getStateName()
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
