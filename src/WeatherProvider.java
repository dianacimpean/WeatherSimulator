//Reflexive associations - an instance of the class is related to another instance of the class.

public class WeatherProvider {

    private static WeatherProvider weatherProvider = null;

    private static WeatherProvider weatherProvider(){
        return weatherProvider();
    }

    private static String[] weather = {WeatherType.RAIN, WeatherType.FOG, WeatherType.SUN, WeatherType.SNOW};

    private static String weather(){
        return weather();
    }

    private WeatherProvider(){
    }

    public static WeatherProvider getProvider(){
        if(weatherProvider == null){
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){

        int currentWeather = (coordinates.getLongitude()*2 + coordinates.getLatitude()*2)/5 + coordinates.getHeight();

        return weather[currentWeather];
    }
}
