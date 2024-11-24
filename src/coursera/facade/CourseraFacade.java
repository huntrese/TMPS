package coursera.facade;

import coursera.flyweight.FlyweightCourse;
import coursera.proxy.Website;
import coursera.proxy.WebsiteBuilderProxy;
import coursera.factory.Course;
import coursera.flyweight.CourseType;
import coursera.singleton.Coursera;
import coursera.state.StatefulCourseFactory;

import coursera.state.StatefulStrategicCourseImpl;
import coursera.strategy.*;

public class CourseraFacade {
    private final Coursera coursera;
    private final Course course;
    private final WebsiteBuilderProxy websiteBuilder;

    public CourseraFacade() {
        this.coursera = Coursera.getInstance();
        this.course = new Course();
        this.websiteBuilder = new WebsiteBuilderProxy();
    }

    public void initializePlatform(String platformName) {
        coursera.setName(platformName);
        System.out.println(String.format("Welcome to %s", coursera.getName()));
    }

    public void createCourse(CourseType courseType, String courseName, String structureType) {
        CourseStructureStrategy strategy;
        switch(structureType.toLowerCase()) {
            case "project":
                strategy = new ProjectBasedStrategy();
                break;
            case "video":
                strategy = new VideoBasedStrategy();
                break;
            default:
                strategy = new StandardCourseStrategy();
        }

        FlyweightCourse course = StrategicFlyweightCourseFactory.createCourse(
                courseType,
                courseName,
                strategy
        );
        course.createCourse();
    }
    public void createAndManageCourse(CourseType courseType, String courseName, String structureType) {
        CourseStructureStrategy strategy;
        switch (structureType.toLowerCase()) {
            case "project":
                strategy = new ProjectBasedStrategy();
                break;
            case "video":
                strategy = new VideoBasedStrategy();
                break;
            default:
                strategy = new StandardCourseStrategy();
        }

        // Create the course using the StatefulCourseFactory
        StatefulStrategicCourseImpl course = StatefulCourseFactory.createCourse(
                courseType,
                courseName,
                strategy
        );

        // Start managing course states
        course.createCourse(); // Course starts in draft state
        System.out.println("State after creation: " + course.getCourseContext().getState().getStateName());

        course.requestApproval(); // Draft -> Pending Approval
        System.out.println("State after approval request: " + course.getCourseContext().getState().getStateName());

        course.publish(); // -> Published
        System.out.println("State after publishing: " + course.getCourseContext().getState().getStateName());

        course.makePrivate(); // Make it private
        System.out.println("State after making private: " + course.getCourseContext().getState().getStateName());

        course.makePublic(); // Make it public again
        System.out.println("State after making public: " + course.getCourseContext().getState().getStateName());

        course.archive(); // -> Archived
        System.out.println("State after archiving: " + course.getCourseContext().getState().getStateName());
    }
    public void createCourseOld(CourseType courseType, String courseName) {
        try {
            course.initialize(courseType, courseName);
            System.out.println(course.getName());
        } catch (Exception e) {
            System.out.println("Error creating course: " + e.getMessage());
        }
    }

    public Website createWebsite(String header, String body, String footer,
                                 String logo, String developer) {
        return websiteBuilder
                .header(header)
                .body(body)
                .setFooter(footer)
                .setLogo(logo)
                .setDeveloper(developer)
                .build();
    }
}