
public class WeatherTower extends Tower {

    public Tower tower;

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather(){
        tower.conditionsChanged();
    }
}
