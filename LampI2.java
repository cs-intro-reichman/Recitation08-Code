// Itay Group 2
import java.awt.Color;

public class LampI2 {
    
        private boolean isOn;
        private Color color;
        private int price;
        private String company;
    
        public LampI2(Color color, int price, String company){
            this.color = color;
            this.price = price;
            this.company = company;
            this.isOn = false;
        }
    
        public LampI2(){
            this.color = new Color(0,0,255);
            this.price = 1000;
            this.company = "IKEA";
            this.isOn = false;
        }
    
        public String getCompany(){
            return this.company;
        }
        public void setCompany(String name){
            this.company = name;
        }
    
        public int getPrice(){
            return this.price;
        }
        public void setPrice(int p){
            assert p > 0 : "price must be positive";
            this.price = p;
        }
        public void switchLight(){
            this.isOn = !this.isOn;
        }
}
