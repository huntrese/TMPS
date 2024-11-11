package coursera.flyweight;

// Course Factory using Flyweight pattern
public class FlyweightCourseFactory {
    public static FlyweightCourse createCourse(CourseType courseType, String courseName) {
        return new FlyweightCourseImpl(courseType, courseName);
    }
}
