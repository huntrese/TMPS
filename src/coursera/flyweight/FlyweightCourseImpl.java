package coursera.flyweight;

public class FlyweightCourseImpl implements FlyweightCourse {
    // Intrinsic state - shared
    private final CourseResources resources;
    private final CourseType courseType;

    // Extrinsic state - unique per instance
    private final String courseName;
    private final String courseId;

    public FlyweightCourseImpl(CourseType courseType, String courseName) {
        this.courseType = courseType;
        this.resources = CourseResourcesFactory.getCourseResources(courseType);
        this.courseName = courseName;
        this.courseId = generateCourseId(courseType, courseName);
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
                        resources.getHelloWorldExample(),
                        resources.getDocumentationUrl(),
                        resources.getForumUrl(),
                        resources.getResourcesUrl(),
                        resources.getSupportEmail()
                ));
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