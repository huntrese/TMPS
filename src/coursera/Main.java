package coursera;

import coursera.facade.CourseraFacade;
import coursera.flyweight.CourseType;
import coursera.proxy.Website;

public class Main {
    public static void main(String[] args) {
        CourseraFacade facade = new CourseraFacade();

        // Initialize the platform
        facade.initializePlatform("UTM Coursera Platform");

        System.out.println("\n=== Creating Courses ===");

        // Create Python courses
        facade.createCourse(CourseType.PYTHON, "Introduction to Python Programming");
        facade.createCourse(CourseType.PYTHON, "Advanced Python with Data Science");

        // Create Java courses
        facade.createCourse(CourseType.JAVA, "Java Fundamentals");
        facade.createCourse(CourseType.JAVA, "Enterprise Java Development");

        System.out.println("\n=== Creating Website ===");

        // Create website with formatted content through proxy
        Website website = facade.createWebsite(
                "UTM Programming Courses",
                """
                Welcome to our programming courses platform!
                We offer comprehensive courses in Java and Python
                taught by industry experts.""",
                "© 2024 UTM. All rights reserved.",
                "utm_courses_logo",
                "huntrese"
        );

        // Display the formatted website
        System.out.println(website);
    }
}