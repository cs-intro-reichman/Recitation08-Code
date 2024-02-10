// Itay group 1 
public class LampI1 {
    //fields
    private boolean isOn;
    private int power;
    private int price;
    private String name;
    
    public LampI1(int power, int price, String name){
        this.power = power;
        this.price = price;
        this.name = name;
        this.isOn = false;
    }
    public LampI1(){
        this.power = 200;
        this.price = 1000;
        this.name = "ALM";
        this.isOn = false;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String s){
      this.name = s;
    }


    public int getPrice(){
        return this.price;
    }

    public void setPrice(int p){
        assert p > 0 : "price cannot be negative or zero";
        this.price = p;
    }
    
    public void switchLight(){
        this.isOn = !this.isOn;
    }
}
