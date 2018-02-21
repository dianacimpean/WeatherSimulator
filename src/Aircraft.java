import com.sun.xml.internal.bind.v2.model.core.ID;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public long getIdCounter() {
        return idCounter;
    }
    public void setIdCounter(long idCounter) {
        this.idCounter = idCounter;
    }

    public Aircraft(String name, Coordinates coordinates){

        this.name = name;
        this.coordinates = coordinates;

        System.out.println("This is a new aircraft!");

    }

    private long nextId(){
        return id;
    }
}


