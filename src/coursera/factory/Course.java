package coursera.factory;

import coursera.flyweight.CourseType;
import coursera.flyweight.FlyweightCourse;
import coursera.flyweight.FlyweightCourseFactory;

public class Course {
    private FlyweightCourse course;

    public void initialize(CourseType courseType, String courseName) {
        course = FlyweightCourseFactory.createCourse(courseType, courseName);
        course.createCourse();
    }

    public String getName() {
        if(course == null) {
            return "Please initialize a course first";
        }
        return course.getName();
    }
}