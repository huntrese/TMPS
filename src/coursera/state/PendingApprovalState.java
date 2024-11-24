package coursera.state;

public class PendingApprovalState implements CourseState {
    @Override
    public void publish(CourseContext course) {
        System.out.println("Error: Course " + course.getCourseName() + " is still pending approval");
    }

    @Override
    public void archive(CourseContext course) {
        System.out.println("Error: Cannot archive course " + course.getCourseName() + " while pending approval");
    }

    @Override
    public void makeDraft(CourseContext course) {
        System.out.println("Returning course " + course.getCourseName() + " to draft state...");
        course.setState(new DraftState());
    }

    @Override
    public void requestApproval(CourseContext course) {
        System.out.println("Course " + course.getCourseName() + " is already pending approval");
    }

    @Override
    public void makePrivate(CourseContext course) {
        System.out.println("Error: Cannot make course " + course.getCourseName() + " private while pending approval");
    }

    @Override
    public void makePublic(CourseContext course) {
        System.out.println("Error: Cannot make course " + course.getCourseName() + " public while pending approval");
    }

    @Override
    public String getStateName() {
        return "Pending Approval";
    }
}
