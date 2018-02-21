import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Application {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        Coordinates coordinates = new Coordinates(123, 323, 4333);
        Aircraft aircraft = new Aircraft("baloon", coordinates );
        System.out.println("The aircraft is actually a: " + aircraft.name);
//        Flyable flyable1 = new Flyable() {

//            @Override
////            public void updateConditions() {
////
////            }
////
////            @Override
////            public void registerTower(WeatherTower WeatherTower) {
////
////            }

//        };

    }
}