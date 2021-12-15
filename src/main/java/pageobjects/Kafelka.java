package pageobjects;

public class Kafelka {

    private static String propertyName;
    private static int flatSize;
    private static int flatRooms;

    public Kafelka(String propertyName, int flatSize, int flatRooms) {
        this.propertyName = propertyName;
        this.flatSize = flatSize;
        this.flatRooms = flatRooms;
    }
    
    public static String getPropertyName() {
        return propertyName;
    }

    public static int getFlatSize() {
        return flatSize;
    }

    public static int getFlatRooms() {
        return flatRooms;
    }
}

