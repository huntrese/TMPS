package coursera.strategy;

public class ProjectBasedStrategy implements CourseStructureStrategy {
    @Override
    public void createCourseStructure(String courseName) {
        System.out.println("Creating Project-Based Course Structure for: " + courseName);
        System.out.println("1. Project Overview");
        System.out.println("2. Planning Phase");
        System.out.println("3. Implementation Guidelines");
        System.out.println("4. Project Milestones (4 stages)");
        System.out.println("5. Final Project Submission");
    }

    @Override
    public String getStructureType() {
        return "Project-Based Course";
    }
}
