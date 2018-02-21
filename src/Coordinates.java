//The composition aggregation relationship is just another form of the aggregation relationship, but the child class's instance lifecycle is dependent on the parent class's instance lifecycle. (Aircraft)
//Another important feature of composition aggregation is that the part class can only be related to one instance of the parent class
//Coordinates cannot exist without Aircraft

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height){

        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;

    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static Coordinates makeCoordinate(int longitude, int latitude, int height){
        return new Coordinates(longitude, latitude, height);
    }

}
