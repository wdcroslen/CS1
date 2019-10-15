public class CityBike extends Bike{
    private int basket;
    private String brake;
    
    public CityBike(){
    }
    
    public CityBike(String bike, String model, String color, String inventory){
            super(bike, model, color, inventory);
        
    }
    
    
    
    public CityBike(String bike, String model,String purchasePrice, String retailPrice, String color, String inventory,    String ageStart, String ageEnd, String basket, String brake){
        
        super(bike, model, purchasePrice, retailPrice, color, inventory, ageStart, ageEnd); 
            this.setBasket(Integer.valueOf(basket));
            this.brake = brake;
    
    }  

        //SETTERS
    public void setBasket(int basket) {
      this.basket = basket;
    }
    public void setBrake(String brake) {
      this.brake = brake;
    }
        //GETTERS
    public int getBasket(){
        return this.basket;
    }
    public String getBrake() {
        return this.brake;
    }
    
   
    public String toString() {
        String result = super.toString();
        result += ("Basket Count: " + basket + ", Brake type: " + brake); 
        return result;
    }
}