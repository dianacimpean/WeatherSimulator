
public class WeatherTower extends Tower {

    public String  getWeather(Coordinates coordinates){
        int longi = coordinates.getLongitude();
        int lati = coordinates.getLatitude();
        int height = coordinates.getHeight();

        if( longi > 0 && lati >0){
        return "Dute-n uscatz";
      }
        return "Du-te tu-n uscatz";
    }

    public void changeWeather(){
    }
}
