//Reflexive associations - an instance of the class is related to another instance of the class.

public class WeatherProvider {
    private WeatherProvider weatherProvider(){
        return null;
    }

    private String weather(){
        return null;
    }

    private WeatherProvider(){}

    public WeatherProvider getProvider(){
        return null;
    }

    public String getCurrentWeather(Coordinates coordinates){
        return null;
    }
}
