
public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    public Aircraft(String name, Coordinates coordinates){
    }

    private long nextId(){
        return 0;
    }
}

