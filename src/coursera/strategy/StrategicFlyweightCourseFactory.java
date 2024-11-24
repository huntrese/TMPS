package coursera.strategy;

import coursera.flyweight.CourseType;
import coursera.flyweight.FlyweightCourse;

public class StrategicFlyweightCourseFactory {
    public static FlyweightCourse createCourse(CourseType courseType, String courseName, CourseStructureStrategy strategy) {
        StrategicFlyweightCourseImpl course = new StrategicFlyweightCourseImpl(courseType, courseName);
        course.setStructureStrategy(strategy);
        return course;
    }
}
