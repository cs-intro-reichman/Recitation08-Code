// David Group
public class LampD {

    // Characteristics
    private boolean isOn;
    private int brightness; // Represented as a percentage (0-100)
    private String color; // Represented as a hex code (#FFFFFF) for simplicity
    private int wattage; // Power consumption
    private String brand;
    private String model;
    private long operatingTime; // In seconds

    // Constructors
    public LampD(String brand, String model, int wattage) {
        this.brand = brand;
        this.model = model;
        this.wattage = wattage;
        this.isOn = false; // Default to off
        this.brightness = 100; // Default to full brightness
        this.color = "#FFFFFF"; // Default to white
        this.operatingTime = 0; // Default to 0 seconds
    }

    // Constructor with all fields
    public LampD(String brand, String model, int wattage, boolean isOn, int brightness, String color, long operatingTime) {
        this.brand = brand;
        this.model = model;
        this.wattage = wattage;
        this.isOn = isOn;
        this.brightness = brightness;
        this.color = color;
        this.operatingTime = operatingTime;
    }

    // Default Constructor
    public LampD() {
        this.brand = "Generic";
        this.model = "Lamp";
        this.wattage = 10;
        this.isOn = false; // Default to off
        this.brightness = 100; // Default to full brightness
        this.color = "#FFFFFF"; // Default to white
        this.operatingTime = 0; // Default to 0 seconds
    }

    // Behaviors
    public void switchOn() {
        this.isOn = true;
    }

    public void switchOff() {
        this.isOn = false;
    }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Brightness must be between 0 and 100.");
        }
        this.brightness = brightness;
    }

    public void changeColor(String color) {
        this.color = color;
    }

    public void resetOperatingTime() {
        this.operatingTime = 0;
    }

    public double calculateEnergyConsumption() {
        // Assuming operatingTime is in seconds and wattage is per hour
        return (wattage / 3600.0) * operatingTime;
    }

    // Display information
    @Override
    public String toString() {
        return String.format("Lamp: %s %s, State: %s, Brightness: %d%%, Color: %s, Energy Consumption: %.2f Wh",
                             brand, model, (isOn ? "On" : "Off"), brightness, color, calculateEnergyConsumption());
    }

    // Getters
    public boolean isOn() {
        return isOn;
    }

    public int getBrightness() {
        return brightness;
    }

    public String getColor() {
        return color;
    }

    public int getWattage() {
        return wattage;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public long getOperatingTime() {
        return operatingTime;
    }

    // Setters
    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public void setOperatingTime(long operatingTime) {
        this.operatingTime = operatingTime;
    }

    // Compare lamps based on their energy consumption
    public int compareTo(LampD other) {
        return Double.compare(calculateEnergyConsumption(), other.calculateEnergyConsumption());
    }

    public static void main(String[] args) {
        LampD lamp = new LampD("Philips", "Hue", 10);
        System.out.println(lamp);
        lamp.switchOn();
        lamp.setBrightness(50);
        lamp.changeColor("#FF0000");
        lamp.setOperatingTime(3600);
        System.out.println(lamp);
        // compareTo example
        LampD other = new LampD("IKEA", "Tradfri", 5);
        System.out.println(lamp.compareTo(other)); // Should be greater than 0

    }


}
