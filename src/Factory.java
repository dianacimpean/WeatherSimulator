
public abstract class Factory extends AicraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        Coordinates coordinates = Coordinates.makeCoordinate(longitude, latitude, height);

        if(type.equals("Baloon") || type.equals("baloon")){
            return new Baloon(name, coordinates);
        } else if(type.equals("JetPlane") || type.equals("jetPlane") || type.equals("jetplane")){
            return new JetPlane(name, coordinates);
        } else if (type.equals("Helicopter") || type.equals("helicopter")){
            return new Helicopter(name, coordinates);
        }
          else  return Error();
        };

        private static Flyable Error(){
          System.out.println("UFO");
          return null;
        };
    }
