package coursera.strategy;

public class VideoBasedStrategy implements CourseStructureStrategy {
    @Override
    public void createCourseStructure(String courseName) {
        System.out.println("Creating Video-Based Course Structure for: " + courseName);
        System.out.println("1. Course Introduction Video");
        System.out.println("2. Video Lectures (15 videos)");
        System.out.println("3. Video Demonstrations");
        System.out.println("4. Video Assignments");
        System.out.println("5. Final Video Presentation");
    }

    @Override
    public String getStructureType() {
        return "Video-Based Course";
    }
}
