import java.awt.Color;
// Tal's Group Friday 8:00
public class LampT {
    private Color color;
    private int watts; 
    private String shape;
    private double price; 
    private double originalPrice; 
    private String brand; 
    private boolean isOn; 
    private int numPurchases;
    private String kind; 
 
    // default constructor
    public LampT () {
        this.color = Color.WHITE;
        this.watts = 220; 
        this.isOn = false;
        this.price = 100; 
        this.shape = "Square";
        this.kind = "Table";
        this.brand = "ikea";
        this.numPurchases = 0;
        this.originalPrice = 100;
    }

    // Standard consturctor
    public LampT (Color color, int watts, double price, String kind, String brand) {
        this.isOn = false;
        this.numPurchases = 0;
        this.color = color;
        this.watts = watts; 
        this.price = price;
        this.kind = kind;
        this.brand = brand; 
        this.shape = "Square";
        this.originalPrice = price;
    }

    public LampT (Color color, int watts, double price, String kind) {
        this();
        this.color = color;
        this.watts = watts; 
        this.price = price;
        this.kind = kind;
        this.originalPrice = price;
    }
    // getters
    public String getKind() {
        return this.kind;
    }

    public String getBrand() {
        return this.brand;
    }
    public double getPrice() {
        return this.price;
    }
    public boolean getIsOn(){
        return this.isOn; // true / false
    }
    public String isLampOn(){
        return this.isOn ? "On" : "Off";
    }
    // setter
    public void setBrand (String brand) {
        this.brand = brand;
    }


    public void setIsOn(boolean isOn){
        this.isOn = isOn;
    }
    
    // t=>f , f->t
    public void switchIsOn() {
        this.setIsOn(!this.isOn);
    }
    public void setPrice(double value, boolean isTotalChange) {
        if (isTotalChange) {
            setPrice(value);
        } else {
            changePriceByPrecent(value);
        }
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Tota; price must be positive");
        }
        this.price = price;
    }

    private void changePriceByPrecent(double precent) {
        double newPrecent = precent / 100;
        if (newPrecent <= 0) {
            return;
        }
        if (newPrecent < 1) {
            this.price = this.price * (1 - newPrecent);// 80%
        } else {
            this.price = this.price * newPrecent; // 105%
        }
    }
    public void revertPrice() {
        this.price = this.originalPrice;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lamp:\n");
        sb.append("Price: " + this.price + "\n");
        sb.append("Watts: " + this.watts + "\n");
        sb.append("Color: #" + this.color.getRGB() + "\n");
        sb.append("state:" + this.isLampOn() + "\n");
        return sb.toString();

    }
    public static void main(String[] args) {
        LampT lamp = new LampT();
        System.out.println(lamp.price);

        LampT lamp2 = new LampT(Color.BLUE, 140, 200, "Chanelier", "ikea");
        System.out.println(lamp2.price);
    }

}
