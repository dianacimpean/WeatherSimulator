import java.util.ArrayList;

//An association with an aggregation relationship indicates that one class is a part of another class. In an aggregation relationship, the child class instance can outlive its parent class. (Flyable)

public class Tower {

    private ArrayList<Flyable> observers;
    public Tower(){observers = new ArrayList<Flyable>();}

    public void register(Flyable flyable){
        observers.add(flyable);
        System.out.println(flyable);
    }

    public void unregister(Flyable flyable){
        int flyableIndex = observers.indexOf(flyable);
        System.out.println("Flyable " + (flyableIndex+1) + " deleted");
        if(flyableIndex >= 0) {
            observers.remove(flyableIndex);
        }
    }

    protected void conditionsChanged(){
        for(Flyable flyable : observers){
            flyable.updateConditions();
        }
    }
}
