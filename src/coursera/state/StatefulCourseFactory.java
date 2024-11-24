package coursera.state;

import coursera.flyweight.CourseType;
import coursera.strategy.CourseStructureStrategy;

public class StatefulCourseFactory {
    public static StatefulStrategicCourseImpl createCourse(
            CourseType courseType,
            String courseName,
            CourseStructureStrategy strategy) {
        StatefulStrategicCourseImpl course = new StatefulStrategicCourseImpl(courseType, courseName);
        course.setStructureStrategy(strategy);
        return course;
    }
}
