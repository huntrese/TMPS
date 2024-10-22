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
