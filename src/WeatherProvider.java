//Reflexive associations - an instance of the class is related to another instance of the class.

public class WeatherProvider {

    private static WeatherProvider firstInstance = null;

    private static WeatherProvider weatherProvider(){
        return weatherProvider();
    }

    private static String weather(){
        return weather();
    }

    private WeatherProvider(){
    }

    public static WeatherProvider getProvider(){
        if(firstInstance == null){
            firstInstance = new WeatherProvider();
        }
        return firstInstance;
    }

    public String getCurrentWeather(Coordinates coordinates){
        return getCurrentWeather(coordinates);
    }
}
