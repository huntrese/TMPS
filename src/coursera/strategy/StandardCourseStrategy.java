package coursera.strategy;

public class StandardCourseStrategy implements CourseStructureStrategy {
    @Override
    public void createCourseStructure(String courseName) {
        System.out.println("Creating Standard Course Structure for: " + courseName);
        System.out.println("1. Introduction Module");
        System.out.println("2. Weekly Lessons (10 lessons)");
        System.out.println("3. Practice Exercises");
        System.out.println("4. Final Assessment");
    }

    @Override
    public String getStructureType() {
        return "Standard Course";
    }
}
