package coursera.state;

public interface CourseState {
    void publish(CourseContext course);

    void archive(CourseContext course);

    void makeDraft(CourseContext course);

    void requestApproval(CourseContext course);

    void makePrivate(CourseContext course);

    void makePublic(CourseContext course);

    String getStateName();
}
