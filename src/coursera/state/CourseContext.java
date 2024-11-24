package coursera.state;

public class CourseContext {
    private CourseState state;
    private final String courseName;

    public CourseContext(String courseName) {
        this.courseName = courseName;
        // Initial state is draft
        this.state = new DraftState();
    }

    public void setState(CourseState state) {
        this.state = state;
    }

    public CourseState getState() {
        return state;
    }

    public String getCourseName() {
        return courseName;
    }
}
