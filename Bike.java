public class Bike{
    private String bike;
    private String model;
    private int ageStart;
    private int ageEnd;
    private int purchasePrice;
    private int retailPrice;
    private String color;
    private int inventory;
    int numBikes = 0;
    
    
   //  static int numBikes = 0;
    // each specific type

public Bike() {
}
     public Bike(String bike, String model, String color, int inventory){
            this.bike = bike;
            this.model = model;
            this.color = color;
            this.inventory = inventory;
         
    }
    public Bike(String bike, String model, String color, String inventory){
            this.bike = bike.replace(" ","");
            this.model = model.replace(" ","");
            this.color = color.replace(" ","");
            this.setInventory(Integer.parseInt(inventory.replace(" ","")));
    }
    
    
    
public Bike(String bike, String model, int purchasePrice, int retailPrice, String color, int inventory, int ageStart, int ageEnd) {
            this.bike = bike;
            this.model = model;
            this.color = color;
            this.purchasePrice = purchasePrice;
            this.retailPrice = retailPrice;
            this.ageStart = ageStart;
            this.ageEnd = ageEnd;
            this.inventory = inventory;
}
        
public Bike(String bike, String model, String purchasePrice, String retailPrice, String color, String inventory, String ageStart, String ageEnd) {
            this.bike = bike.replace(" ","");
            this.model = model.replace(" ","");
            this.color = color.replace(" ","");
            this.setPurchasePrice(Integer.parseInt(purchasePrice.replace(" ","").replace("$","")));
            this.setRetailPrice(Integer.parseInt(retailPrice.replace(" ","").replace("$","")));
            this.setAgeStart(Integer.parseInt(ageStart.substring(0,2).replace("-","")));
            this.setAgeEnd(Integer.parseInt(ageEnd.substring(0,2).replaceAll("[^\\d.]", "")));
            this.setInventory(Integer.parseInt(inventory.replace(" ","")));
        //numBikes = numBikes + 1;
}

     public String toString() {
        String result = super.toString();

//         if (color.equals("blue")){
//        result = ((char)27 + "[34mBike Type: " + (char)27 + "[0m" + bike + ", Model: " + model + ", Purchase Price: $" + purchasePrice + ", Retail Price: $" + retailPrice + ", Color: " + color + ", Stock: " + inventory + ", Age Range: " + ageStart + " to " + ageEnd + ", "); 
//         }
//         else if (color.equals("red")){
//        result = ((char)27 + "[31mBike Type: " + (char)27 + "[0m" + bike + ", Model: " + model + ", Purchase Price: $" + purchasePrice + ", Retail Price: $" + retailPrice + ", Color: " + color + ", Stock: " + inventory + ", Age Range: " + ageStart + " to " + ageEnd + ", "); 
//         }
//         else if (color.equals("green")){
//        result = ((char)27 + "[32mBike Type: " + (char)27 + "[0m" + bike + ", Model: " + model + ", Purchase Price: $" + purchasePrice + ", Retail Price: $" + retailPrice + ", Color: " + color + ", Stock: " + inventory + ", Age Range: " + ageStart + " to " + ageEnd + ", "); 
//         }
//         else if (color.equals("orange")){
//        result = ((char)27 + "[33mBike Type: " + (char)27 + "[0m" + bike + ", Model: " + model + ", Purchase Price: $" + purchasePrice + ", Retail Price: $" + retailPrice + ", Color: " + color + ", Stock: " + inventory + ", Age Range: " + ageStart + " to " + ageEnd + ", "); 
//         }
//         else if (color.equals("grey")){
//        result = ((char)27 + "[37mBike Type: " + (char)27 + "[0m" + bike + ", Model: " + model + ", Purchase Price: $" + purchasePrice + ", Retail Price: $" + retailPrice + ", Color: " + color + ", Stock: " + inventory + ", Age Range: " + ageStart + " to " + ageEnd + ", "); 
//         }
//         else {
//             result = ("Bike Type: " + bike + ", Model: " + model + ", Purchase Price: $" + purchasePrice + ", Retail Price: $" + retailPrice + ", Color: " + color + ", Stock: " + inventory + ", Age Range: " + ageStart + " to " + ageEnd + ", ");
//         }
//         
         result = (bike + ", " + model + ", " + purchasePrice + ", " + retailPrice + ", " + color + ", " + inventory + ", " + ageStart + ", " + ageEnd + ", ");
         return result;
             
    }
        //SETTERS
     public void setBike(String bike){
        this.bike = bike;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setAgeStart(int ageStart) {
      this.ageStart = ageStart;
    }
    public void setAgeEnd(int ageEnd) {
      this.ageEnd = ageEnd;
    }
    public void setPurchasePrice(int purchasePrice) {
      this.purchasePrice = purchasePrice;
    }
    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }
    public void setColor(String color) {
      this.color = color;
    }
    public void setInventory(int inventory) {
      this.inventory = inventory;
    }
        //GETTERS
    public String getBike() {
        return this.bike;
    }
    public String getModel(){
        return this.model;
    }
    public int getAgeStart() {
        return this.ageStart;
    }
    public int getAgeEnd() {
        return this.ageEnd;
    }
    public int getPurchasePrice() {
        return this.purchasePrice;
    }
    public int getRetailPrice() {
        return this.retailPrice;
    }
    public String getColor() {
        return this.color;
    }
    public int getInventory() {
        return this.inventory;
    }
 
}

