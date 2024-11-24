package coursera.state;

public class ArchivedState implements CourseState {
    @Override
    public void publish(CourseContext course) {
        System.out.println("Republishing archived course " + course.getCourseName() + "...");
        course.setState(new PublishedState());
    }

    @Override
    public void archive(CourseContext course) {
        System.out.println("Course " + course.getCourseName() + " is already archived");
    }

    @Override
    public void makeDraft(CourseContext course) {
        System.out.println("Moving archived course " + course.getCourseName() + " to draft...");
        course.setState(new DraftState());
    }

    @Override
    public void requestApproval(CourseContext course) {
        System.out.println("Error: Cannot request approval for archived course " + course.getCourseName());
    }

    @Override
    public void makePrivate(CourseContext course) {
        System.out.println("Error: Cannot modify visibility of archived course " + course.getCourseName());
    }

    @Override
    public void makePublic(CourseContext course) {
        System.out.println("Error: Cannot modify visibility of archived course " + course.getCourseName());
    }

    @Override
    public String getStateName() {
        return "Archived";
    }
}

