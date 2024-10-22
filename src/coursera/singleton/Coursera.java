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
