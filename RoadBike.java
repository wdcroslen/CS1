public class RoadBike extends Bike{
     private int gears;
     private double weight;

    
    public RoadBike(String bike, String model, String color, String inventory){
            super(bike, model, color, inventory);
        
    }
     public RoadBike(String bike, String model,String purchasePrice, String retailPrice, String color, String inventory,    String ageStart, String ageEnd, String gears, String weight){
         
          super(bike, model, purchasePrice, retailPrice, color, inventory, ageStart,ageEnd); 
            this.setWeight(Double.parseDouble(weight.replace(" ","")));
            this.setGears(Integer.parseInt(gears.replace(" ","")));
     }
         
         
        //SETTERS
    public void setGears (int gears) {
      this.gears = gears;
    }
    public void setWeight(double weight) {
      this.weight = weight;
    }
        //GETTERS
    public int getGears(){
        return this.gears;
    }
    public double getWeight() {
        return this.weight;
    }

     public String toString() {
        String result = super.toString();
        result += ("Gear Count: " + gears + ", Weight: " + weight); 
        return result;
    }
    
}
