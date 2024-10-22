package coursera;

import coursera.builder.Website;
import coursera.factory.Course;
import coursera.singleton.Coursera;

public class Main {
    public static void main(String[] args) throws Exception {
        Coursera coursera = Coursera.getInstance();
        Course course = new Course();

        coursera.setName("utmcurs");
        System.out.println(String.format("Welcome to %s",coursera.getName()));

        course.initialize("Python");
        System.out.println(course.getName());
        course.initialize("Java");
        System.out.println(course.getName());

        Website site = new Website.WebsiteBuilder()
                .header("website header")
                .body("good stuff")
                .setFooter("protected by faf licence")
                .setLogo("faf logo")
                .setDeveloper("huntrese")
                .build();
        System.out.println(site);
    }
}
