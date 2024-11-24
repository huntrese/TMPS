package coursera.state;

public class DraftState implements CourseState {
    @Override
    public void publish(CourseContext course) {
        System.out.println("Error: Course " + course.getCourseName() + " needs approval before publishing");
    }

    @Override
    public void archive(CourseContext course) {
        System.out.println("Error: Cannot archive course " + course.getCourseName() + " while in draft state");
    }

    @Override
    public void makeDraft(CourseContext course) {
        System.out.println("Course " + course.getCourseName() + " is already in draft state");
    }

    @Override
    public void requestApproval(CourseContext course) {
        System.out.println("Requesting approval for course " + course.getCourseName() + "...");
        course.setState(new PendingApprovalState());
    }

    @Override
    public void makePrivate(CourseContext course) {
        System.out.println("Error: Cannot make course " + course.getCourseName() + " private while in draft state");
    }

    @Override
    public void makePublic(CourseContext course) {
        System.out.println("Error: Cannot make course " + course.getCourseName() + " public while in draft state");
    }

    @Override
    public String getStateName() {
        return "Draft";
    }
}
