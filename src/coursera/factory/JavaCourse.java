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
