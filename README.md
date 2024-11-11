# Topic: *Structural Design Patterns*
## Executed by: *Polisciuc Vlad*
------
## Objectives:
__1. Study Structural Design Patterns__

## Some Theory:
Design patterns are typical solutions to commonly occurring problems in software design. They provide a blueprint to follow in different situations, making development easier.
The Structural design patterns describe different ways of assembling objects and classes into larger structures, while keeping these larger ones flexible and efficient

These are the most well known structural design patterns:

Adapter: Facilitates colaboraton between objects with incompatible interfaces

Bridge: Separatess a large set of related classes into their abstraction and implementation, 2 subsets, which can be developed and maintained by themselves

Composite: Combine many objects together in a tree structure(parents ->children) then work with these branches

Decorator: Add new behavior to objects by wrapping them with new functionality

Facade: Exposes to the user a single streamlined interface of a complex system, containing exactly the functionality that the user needs

Flyweight: Fits more objects into RAM by sharing some resources via a common class, instead of keeping this same information as duplication in each concrete class

Proxy: Provides a substitute for another object, if needed can perform operations before or after the original objects' functionality

By leveraging these Structural design patterns, any developer can write more efficient code, and solve more complex problems.
   
## Main tasks:
__1. By extending lab_1, implement atleast 3 structural design patterns in the project.__

__2. The implemented design pattern should help to perform the tasks involved in your system.__

__3. The object creation mechanisms/patterns can now be buried into the functionalities instead of using them into the client.__

## Implementation:

### Domain:

The domain I work on is a Website in general, and a concrete coursera/udemy type as a more concrete example. This allows me to work with 2 main parts for my projects:
__1. Website stuff like html__
__2. Course data that at some point will be a concrete page in the website__


For this laboratory I have chosen to implement the following 3 SDPs
Flyweight, Proxy and Facade.

### Flyweight

For the Flyweight Implementation I have observed the incredible amount of redundancy when creating different types of courses in my previous lab_1 code:
compare

![image](https://github.com/user-attachments/assets/81a1ae86-208b-4928-a660-22b09df514da)

where each new course will essentially require a new class being made manually

and the new flyweight implementation:

![image](https://github.com/user-attachments/assets/8d81bde1-5f11-49c2-a208-8f61e47f97c1)

yes more Classes were added, making the system way more complex, but also this makes the interactionw ay easier for the user. now any course has some shared resources that are based on a course type (Still java or python for now)

![image](https://github.com/user-attachments/assets/3e9aa593-8221-4964-8076-b10c36ba662c)

The types are declared first in the CourseTypes Enum

![image](https://github.com/user-attachments/assets/57f2a981-39c5-450b-a32c-12b1b9794820)

and then can  be used anywhere else.

So my Flyweight Implementation is absed on the fact that  acourse will have shared resources absed on its type, and only some data like the course name will be modified by each concrete course.

This makes the Course Implementation look like this:
```java
package coursera.flyweight;

public class FlyweightCourseImpl implements FlyweightCourse {
    // Intrinsic state - shared
    private final CourseResources resources;
    private final CourseType courseType;

    // Extrinsic state - unique per instance
    private final String courseName;
    private final String courseId;

    public FlyweightCourseImpl(CourseType courseType, String courseName) {
        this.courseType = courseType;
        this.resources = CourseResourcesFactory.getCourseResources(courseType);
        this.courseName = courseName;
        this.courseId = generateCourseId(courseType, courseName);
    }

    private String generateCourseId(CourseType type, String name) {
        return type.name().substring(0, 3).toUpperCase() +
                "_" +
                name.replaceAll("\\s+", "_").toUpperCase() +
                "_" +
                System.currentTimeMillis() % 10000;
    }

    @Override
    public void createCourse() {
        System.out.println("""
        Welcome to %s: %s
        Course ID: %s
        Programming Language: %s
        
        Here's your starter program:
        %s
        
        Useful resources:
        Documentation: %s
        Community Forum: %s
        Package Repository: %s
        Support: %s
        """
                .formatted(
                        resources.getProgrammingLanguage(),
                        courseName,
                        courseId,
                        resources.getProgrammingLanguage(),
                        resources.getHelloWorldExample(),
                        resources.getDocumentationUrl(),
                        resources.getForumUrl(),
                        resources.getResourcesUrl(),
                        resources.getSupportEmail()
                ));
    }

    @Override
    public String getName() {
        return String.format("%s - %s (%s)",
                resources.getProgrammingLanguage(),
                courseName,
                courseId
        );
    }

    @Override
    public CourseType getCourseType() {
        return courseType;
    }

    @Override
    public CourseResources getResources() {
        return resources;
    }
}
```

where IU have both intristic and extrinsic attributes (shared/ unique)
then the constructor 'constructs' a concrete Implementation absed on the parameters provided, using the helper functions below

generateCourseId - as name suggests creates a unique course id absed on the already existing data about the course, and adds a time.millis to make sure the ids are mostly unique(they can still collide if unlucky, but just less likely)

createCourse itself is the method that well 'creates' a course by printing all existing data about it to the console

'see the flyweight package for details'

now a new course can be created like this:

![image](https://github.com/user-attachments/assets/af557f15-d850-4603-8815-e249a75ff054)

and through the facade(will show later):

![image](https://github.com/user-attachments/assets/0eb93c5f-4516-4d63-96ea-0d19e4f92533)


that was the flyweight implementation, it allowed me to make courses both much more flexible and way more memory efficient by sharing the resources.


### Proxy

For the proxy implementation I identified the problem of actual website building, in my case formating the input data from the user to look more like the actual website components and not just strings, 
this allowed me to get a website that looks like this:

![image](https://github.com/user-attachments/assets/9dcacd6c-0e8f-44e0-9661-5c02796b06e8)

yes it is just formating the strings more nicely as a preprocessing step before sending it to the actual website builder :)


I have a main Website Builder Interface

![image](https://github.com/user-attachments/assets/5e4e1c48-123a-44e1-97f0-83d0a81e05c3)

that is implemented by both the proxy and the actual builder

![image](https://github.com/user-attachments/assets/928d7d71-f9ea-4e08-9f8b-79d101654585)

and then each of them defines the respective methods for the website component initialization

![image](https://github.com/user-attachments/assets/42c0fee1-cfa8-4dbf-9daf-9fc99a8fa6f9)

the proxy just does a preprocessing step before calling the realWebsiteBuilder method

Example formatting steps:

![image](https://github.com/user-attachments/assets/1040cb79-f65e-4eeb-ae08-534c289f7e3c)



### Facade

And at the end I wrapped everythign in a facade, that make sit easier for the user (coursera admin) to create courses, the website and manage stuff

```java
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
```


Here we first define the intitialization of the main website singleton.

then in the createCouse method we initialize a course based ont he given parameters
in create Website we use the proxy to build the website.


and this is how the main looks like now, after the facade implementation

![image](https://github.com/user-attachments/assets/badeb175-b5ce-491b-9312-5d3545eacd93)


## Conclusions:

In conclusion, we have successfully implemented 3 Structural Design Patterns in the previous project, namely the Proxy, Flyweight and Facade patterns. This has allowed to optimize the code, to both make it more maintainable and scalable, now it just generally offers a better experience to both the user and the developer, keeping this more clear. Although the Flyweight has complicated things a little bit, the actual final result is much better
