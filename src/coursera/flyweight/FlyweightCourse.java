package coursera.flyweight;

// Abstract Flyweight
public interface FlyweightCourse {
    void createCourse();
    String getName();
    CourseType getCourseType();
    CourseResources getResources();
}