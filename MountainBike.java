public class MountainBike extends Bike{
    private String level;
    private int wheelSize;
    
    public MountainBike(String bike, String model, String color, String inventory){
            super(bike, model, color, inventory);
        
    }
     public MountainBike(String bike, String model,String purchasePrice, String retailPrice, String color, String inventory, String ageStart,String ageEnd, String level, String wheelSize){
         
          super(bike, model, purchasePrice, retailPrice, color, inventory, ageStart,ageEnd); 
            this.setWheelSize(Integer.parseInt(wheelSize.replace(" ","")));
            this.level = level.replace(" ", "");
    
     }
    
        //SETTERS
    public void setLevel(String level) {
      this.level = level;
    }
    public void setWheelSize(int wheelSize) {
      this.wheelSize = wheelSize;
    }
        //GETTERS
    public String getLevel(){
        return this.level;
    }
    public int getWheelSize() {
        return this.wheelSize;
    }
    public String toString() {
        String result = super.toString();
        result += ("User Level: " + level + ", Wheel Size: " + wheelSize); 
        return result;
    }

}
