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
