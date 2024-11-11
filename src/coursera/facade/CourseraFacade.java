package coursera.facade;

import coursera.proxy.Website;
import coursera.proxy.WebsiteBuilderProxy;
import coursera.factory.Course;
import coursera.flyweight.CourseType;
import coursera.singleton.Coursera;

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

    public void createCourse(CourseType courseType, String courseName) {
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