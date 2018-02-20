//An association with an aggregation relationship indicates that one class is a part of another class. In an aggregation relationship, the child class instance can outlive its parent class. (Flyable)
public class Tower {

    private Flyable observers() {
        return null;
    }

    public void register(Flyable flyable){}
    public void unregister(Flyable flyable){}
    protected void conditionsChanged(){}
}
