import java.awt.Color;
public class Lamp {
    // Fields \ Properties \ Attributes
    private int voltage;
    private String brand;
    private double price;
    private final double originalPrice;
    private boolean state;// (on -> True \ off -> False)
    private Color light; // composition
    private Color color; // composition

    // Constructor
    public Lamp(int voltage, String brand, double price, boolean state, Color color, Color light) {
        this.voltage = voltage;
        this.brand = brand;
        this.price = price;
        this.originalPrice = price;
        this.state = state;
        this.color = color;
        this.light = light;
    }

    public Lamp(int voltage, String brand, double price) {
        this.voltage = voltage;
        this.brand = brand;
        this.price = price;
        this.originalPrice = price;
        this.state = false;
        this.color = Color.ORANGE;
        this.light = Color.YELLOW;
    }

    public Lamp(int voltage, String brand, double price, Color color) {
        this.voltage = voltage;
        this.brand = brand;
        this.price = price;
        this.originalPrice = price;
        this.state = false;
        this.color = color;
        this.light = Color.YELLOW;
    }

    public Lamp(int voltage, String brand) {
        this(voltage, brand, 75, Color.BLUE);
    }

    // getters
    public String getBrand() {
        return this.brand;
    }

    public double getPrice() {
        return this.price;
    }

    public String isState() {
        return this.state ? "On" : "Off";
    }

    // setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /*
     T -> F
     F -> T
     */
    public void switchState() {
          this.setState(!this.state);
    }

    private void setState(boolean other){
	    this.state = other;
    }

    public void setPrice(double value, boolean isTotalChange) {
        if (isTotalChange) {
            totalChange(value);
        } else {
            changePrecent(value);
        }
    }

    private void changePrecent(double precent) {
        double newPrecent = precent / 100;
        if (newPrecent <= 0) {
            return;
        }
        if (newPrecent < 1) {
            this.price = this.price * (1 - newPrecent);
        } else {
            this.price = this.price * newPrecent;
        }
    }

    private void totalChange(double value) {
        if (value <= 0) {
            return;
        }
        this.price = value;
    }

    public void revertPrice() {
        this.price = this.originalPrice;
    }

    public String toString() {
        return "Lamp : \nvoltage:" + this.voltage + ", brand: " + this.brand + ", price: " + this.price + ", state: " + this.isState();
    }
}

