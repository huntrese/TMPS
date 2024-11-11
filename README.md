# Topic: *Creational Design Patterns*
## Executed by: *Polisciuc Vlad*
------
## Objectives:
__1. Study and understand the Creational Design Patterns.__

__2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

__3. Use some creational design patterns for object instantiation in a sample project.__

## Some Theory:
Design patterns are typical solutions to commonly occurring problems in software design. They provide a blueprint to follow in different situations, making development easier.
The creational design patterns describe different ways of creating objects. They are the following:

Factory: provides an interface for object creation in a super class, allowing subclasses to allow the exact type of the objects created.
Abstract Factory: Allows creating families of related objects without defining their concrete classes
Builder: Allows the construction of complex objects ina  step by step manner, allowing defining different patterns of object construction.
Prototype: Provides the means to copy objects without making the code too dependent on a certain class
Singleton: Makes sure taht a class has only one instance.

By leveraging these design patterns, any developer can write more efficient code, and solve more complex problems.
   
## Main tasks:
__1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

__2. Select a domain area for the sample project.__

__3. Define the main involved classes and think about what instantiation mechanisms are needed.__

__4. Based on the previous point, implement atleast 3 creational design patterns in your project.__

## Implementation:

I have chosen the domain of a course delivering website like coursera or Udemy. I will be using the Builder, Factory and Singleton patterns.

Starting with Singleton:
```java
package coursera.singleton;

public class Coursera {
    private static Coursera coursera;
    private String name;
    private Coursera(){

    }

    public static Coursera getInstance() {
        if (coursera==null){
            coursera = new Coursera();
        }
        return coursera;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

```

I have created a Singleton class for the main coursera object, as there can only be one coursera object at a time.

Useage:
```java
    Coursera coursera = Coursera.getInstance();
    
    coursera.setName("utmcurs");
    System.out.println(String.format("Welcome to %s",coursera.getName()));
```
Output:

![image](https://github.com/user-attachments/assets/49d275cc-8a34-4d26-90e0-f4e90712af99)



For the Factory:
```java
package coursera.factory;

public interface ICourse {

    ICourse createCourse();
    String getName();
}

```
Basic course Interface

```java
package coursera.factory;

public class JavaCourse implements ICourse {
    private Integer courseId;
    public String name;

    @Override
    public ICourse createCourse() {
        this.courseId = 1;
        this.name = "Java Course";
        System.out.println(
                """
                Welcome to Java course, this is your starter Java program
                        public class Main {
                            public static void main(String[] args) {
                                System.out.println("Hello World");
                            }
                        }
                """
        );
        return this;
    }
    @Override
    public String getName() {
        return String.format("%s %s",this.name,String.valueOf(courseId));
    }
}

```

Concrete implementation of a Java Course

```java
package coursera.factory;

public class PythonCourse implements ICourse {
    private Integer courseId;
    public String name;

    @Override
    public ICourse createCourse() {
        this.courseId = 0;
        this.name = "Python Course";
        System.out.println(
        """
        Welcome to python course, this is your starter python program
        print("Hello World")
        """
        );
        return this;
    }
    @Override
    public String getName() {
        return String.format("%s %s",this.name,String.valueOf(courseId));
    }
}

```

Concrete Implementation of a Python course


```java
package coursera.factory;

public class Course {
    public ICourse course;
    public void initialize(String courseName) throws Exception {
        switch (courseName.toLowerCase()){
            case "python" -> {course= new PythonCourse().createCourse();}
            case "java" -> {course= new JavaCourse().createCourse();}
            default -> {throw new Exception("Unkown course, choose one from: 1. Java   2. Python");}
        }
    }
    public String getName(){
        if(course==null){
            return "Please initialize a course first";
        }
        return course.getName();
    }
}

```

The general factory that creates a different course based on the given input

Useage:
```java

        Course course = new Course();

        course.initialize("Python");
        System.out.println(course.getName());
        course.initialize("Java");
        System.out.println(course.getName());
```

Output:

![image](https://github.com/user-attachments/assets/e03d5a5a-5fde-4d62-9eab-3517faa3a01e)


For the builder pattern, I imitated a website builder:
```java
package coursera.builder;

public class Website {

    private String header;
    private String body;
    private String footer;
    private String logo;
    private String developer;

    private Website(WebsiteBuilder builder) {
        this.header = builder.header;
        this.body = builder.body;
        this.footer = builder.footer;
        this.logo = builder.logo;
        this.developer = builder.developer;
    }

    public static final class WebsiteBuilder {
        private String header;
        private String body;
        private String footer;
        private String logo;
        private String developer;

        public WebsiteBuilder header(String header) {
            this.header = header;
            return this;
        }

        public WebsiteBuilder body(String body) {
            this.body = body;
            return this;
        }

        public WebsiteBuilder setDeveloper(String developer) {
            this.developer = developer;
            return this;
        }

        public WebsiteBuilder setFooter(String footer) {
            this.footer = footer;
            return this;
        }

        public WebsiteBuilder setLogo(String logo) {
            this.logo = logo;
            return this;
        }

        public Website build() {
            if (header == null) {
                throw new IllegalStateException("Site should have a header");
            }
            if (body == null) {
                throw new IllegalStateException("Site should have a body");
            }
            if (footer == null) {
                throw new IllegalStateException("Site should have a footer");
            }
            if (logo == null) {
                throw new IllegalStateException("Site should have a logo");
            }
            if (developer == null) {
                throw new IllegalStateException("Site should have a developer");
            }
            return new Website(this); // Return new Website object
        }
    }

    @Override
    public String toString() {
        return String.format(
                """
                Website:
                    header= %s
                    body= %s
                    footer= %s
                    logo= %s
                    developer= %s
                """,
                header, body, footer, logo, developer);
    }
}

```

The builder implementation. I made the WebsiteBuilder inisde the actual website to make it only possible to create a Website through this builder in the following manner:
Useage:
```java
 Website site = new Website.WebsiteBuilder()
                .header(coursera.getName())
                .body(course.getName())
                .setFooter("protected by faf licence")
                .setLogo("faf logo")
                .setDeveloper("huntrese")
                .build();
        
        System.out.println(site);
```

Output:

![image](https://github.com/user-attachments/assets/56a8208d-990a-447a-ae24-dffb690b9877)




## Folder Structure
![image](https://github.com/user-attachments/assets/5a60433c-fb17-44fb-b3f2-cc20341e86ce)

## Conclusion

In the end, by doing this laboratory work we have learned how to efficiently utilize 3 Creational Design patterns, in my specific case the Builder,Factory and Singleton. all of them were used together in this project, to demonstrate understanding and ability to use these patterns. Therefore I would consider this laboratory as an efficient tool by which this knowledge can be achieved. 


