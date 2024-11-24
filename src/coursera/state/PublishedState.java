package coursera.state;

public class PublishedState implements CourseState {
    private boolean isPublic = true;

    @Override
    public void publish(CourseContext course) {
        System.out.println("Course " + course.getCourseName() + " is already published");
    }

    @Override
    public void archive(CourseContext course) {
        System.out.println("Archiving published course " + course.getCourseName() + "...");
        course.setState(new ArchivedState());
    }

    @Override
    public void makeDraft(CourseContext course) {
        System.out.println("Moving published course " + course.getCourseName() + " back to draft...");
        course.setState(new DraftState());
    }

    @Override
    public void requestApproval(CourseContext course) {
        System.out.println("Course " + course.getCourseName() + " is already published");
    }

    @Override
    public void makePrivate(CourseContext course) {
        if (isPublic) {
            System.out.println("Making course " + course.getCourseName() + " private...");
            isPublic = false;
        } else {
            System.out.println("Course " + course.getCourseName() + " is already private");
        }
    }

    @Override
    public void makePublic(CourseContext course) {
        if (!isPublic) {
            System.out.println("Making course " + course.getCourseName() + " public...");
            isPublic = true;
        } else {
            System.out.println("Course " + course.getCourseName() + " is already public");
        }
    }

    @Override
    public String getStateName() {
        return "Published (" + (isPublic ? "Public" : "Private") + ")";
    }
}
