import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.IOException;


public class Execute {
     public static void main(String[] args) {
//      String text = args[0];
        String text = "Inventory.txt";
        String text2 = "clientsrequests.txt";
        print(readInventory(text));
        System.out.println("Profit: " + updateInventory((readInventory(text)), text2));
        }
    
    public static Bike [] readInventory(String filename){
        String currentLine;
        int lineCount = countLines(filename);
        Bike [] bikeArray = new Bike[lineCount];
        String [] array = new String[80];
        int count = 0;
try {
    FileReader fr = new FileReader(filename);
    BufferedReader read = new BufferedReader(fr);
    Scanner in = new Scanner(filename);
    while ((currentLine = read.readLine()) != null) {
        String line2[] = currentLine.split("-");
        String line[] = currentLine.split(", ");
        for (int i = 0; i < line.length; i++){
                array[i] = line[i];
            }
            if (line[0].equals("City Bike")){
                CityBike cB1 = new CityBike(array[0], array[1], array[2], array[3], array[4], array[5],array[6], line2[1],array[7],array[8]);
                bikeArray[count] = cB1;
                count++;
            }
        else if (line[0].equals("Road Bike")){
                RoadBike rB1 = new RoadBike(array[0], array[1], array[2], array[3], array[4], array[5],array[6], line2[1],array[7],array[8]);
                bikeArray[count] = rB1;
                count++;
            }
        else if (line[0].equals("Mountain Bike")){
                MountainBike mB1 = new MountainBike(array[0], array[1], array[2], array[3], array[4], array[5],array[6],line2[1],array[7],array[8]); 
                bikeArray[count] = mB1;
                count++;
            }
    }
    read.close();
}
    catch (FileNotFoundException e) {
            System.out.println("The file was not found.");        
    }  
    catch (IOException e) {
            System.out.println("This file is corrupt.");
    }
    catch (ArrayIndexOutOfBoundsException e) {
            System.out.println ("Your file went out of bounds.");
    }
        return bikeArray;
    }
public static void print(Bike[] info){
    System.out.println();
       for (int i = 0; i < info.length; i++){
                System.out.println(info[i] + " ");
       }
    System.out.println();
}
    // Method to check the length of the file 
     public static int countLines(String filename){
                String currentLine;
                int i = 0;
    try {
        FileReader fr = new FileReader(filename);
        BufferedReader read = new BufferedReader(fr);
        Scanner in = new Scanner(filename); 
            while ((currentLine = read.readLine()) != null) {
                            i++;
            }
    read.close();
    }
             catch (FileNotFoundException e) {
                System.out.println("The file was not found.");        
             }  
             catch (IOException e) {
                    System.out.println("This file is corrupt.");
             }

             catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println ("Your file went out of bounds.");
             }
                 return i;
            }
    //UPDATE INFO
public static double updateInventory(Bike[] inventory, String request){  
        String currentLine;
        int lineCount2 = countLines(request);
        Bike [] req = new Bike[lineCount2];
        String [][] requestArray = new String[lineCount2][4];
        int row = 0;
        int rows = 0;
    try {
        FileReader fr = new FileReader(request);
        BufferedReader read = new BufferedReader(fr);
        Scanner in = new Scanner(request);
        
        while ((currentLine = read.readLine()) != null) {
                String line[] = currentLine.split(", ");
            for (int i = 0; i < line.length; i++){
                requestArray[rows][i] = line[i];
            }
                rows++;
                if (line[0].equals("City Bike")){
                    CityBike cB2 = new CityBike(line[0], line[1], line[2], line[3]);
                    req[row] = cB2;
                    row++;
                }
                
            else if (line[0].equals("Road Bike")){
                    RoadBike rB2 = new RoadBike(line[0], line[1], line[2], line[3]);
                    req[row] = rB2;
                    row++;
            }
            else if (line[0].equals("Mountain Bike")){
                    MountainBike mB2 = new MountainBike(line[0], line[1], line[2], line[3]); 
                    req[row] = mB2;
                    row++;
                }
    }
    read.close();
    }
        catch (FileNotFoundException e) {
                System.out.println("The file was not found.");        
        }  
        catch (IOException e) {
                System.out.println("This file is corrupt.");
        }
        catch (ArrayIndexOutOfBoundsException e) {
                System.out.println ("Your file went out of bounds.");
        }
           for (int i = 0; i < req.length; i++){
               System.out.println(req[i] + " ");
           }
            System.out.println();
try {
        File fileMiss = new File("Missing.txt");
        
    
	    File file = new File("inv.txt");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 0; i < req.length; i++){
                printWriter.print(inventory[i].toString());
                printWriter.println("");
            }
        printWriter.close();
}
    catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
    }
        String fileMissing = "Missing.txt";
        String file = "inv.txt";
        int lineCount = countLines(file);
        String [][] inventoryArray = new String[lineCount][9];
        row = 0;

try {
    FileReader fr = new FileReader(file);
    BufferedReader read = new BufferedReader(fr);
    Scanner in = new Scanner(file);
    while ((currentLine = read.readLine()) != null) {
        String line[] = currentLine.split(", ");
        for (int i = 0; i < 9; i++){
            inventoryArray[row][i] = line[i];
            }
        row++;   
    }
    read.close();
}
    catch (FileNotFoundException e) {
            System.out.println("The file was not found.");        
    }  
    catch (IOException e) {
            System.out.println("This file is corrupt.");
    }
    catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Your file went out of bounds.");
    }
    
    int [] presentBikes = new int[requestArray[0].length + 1];
    for (int i = 0; i <requestArray[0].length + 1; i++){
        presentBikes[i] = -1;
        //System.out.println(presentBikes[i]);
    }
    int counter = 0;
    int bikeCount = 0;
    double profit = 0.0;
     for(int i = 0; i < lineCount2; i++ ,bikeCount++){       
         //CHECKS CITY BIKE
        if (requestArray[i][0].substring(0,4).replace(" ","").equals("City")){
             for(int j = 0; j < lineCount; j++){
                 //CHECKS IF INVENTORY MATCHES
                if (inventoryArray[j][0].equals("CityBike")){
                    //CHECKS IF MODEL IS THE SAME
                    if(inventoryArray[j][1].equals(requestArray[i][1].replace(" ",""))){
                        // CHECKS THE COLOR
                        if (requestArray[i][2].replace(" ","").equals(inventoryArray[j][4].replace(" ",""))){
                             //CHECKS IF INVENTORY IS LARGER OR EQUAL TO REQUEST
                            if (Integer.valueOf(inventoryArray[j][5].replace(" ", "")) >= Integer.valueOf(requestArray[i][3].replace(" ", ""))) {
                                //UPDATES INVENTORY NUMBER
                                inventoryArray[j][5] = Integer.toString((Integer.valueOf(inventoryArray[j][5].replace(" ", ""))) - (Integer.valueOf(requestArray[i][3].replace(" ", ""))));
                                System.out.println("Your purchase of " + requestArray[i][3] + " bike(s has been made!");
                                profit = profit + ((Integer.valueOf(inventoryArray[j][3].replace(" ", "")) - Integer.valueOf(inventoryArray[j][2].replace(" ", "")) ) * Integer.valueOf(requestArray[i][3].replace(" ", "")));
                                    
                                  presentBikes[bikeCount] = i;
//                                       
                                
                                        //UPDATES IF INVENTORY IS LESS THAN REQUEST
                                    if (Integer.valueOf(inventoryArray[j][5].replace(" ", "")) < Integer.valueOf(requestArray[i][3].replace(" ", ""))){
                                            profit = profit + ((Integer.valueOf(inventoryArray[j][3].replace(" ", "")) - Integer.valueOf(inventoryArray[j][2].replace(" ", "")) ) * Integer.valueOf(inventoryArray[j][5].replace(" ", "")));
                                         
                                      
                                    }
                            }
                            else {
                                 System.out.println("We can only sell you " + inventoryArray[j][5].replace(" ","") + " bikes of "  + requestArray[i][0] +  " not " + requestArray[i][3]);
                            }
                        }
                        System.out.println();
                    }
                }
             }
          
        }
         //CHECKS MOUNTAIN BIKE
        if (requestArray[i][0].substring(0,4).replace(" ","").equals("Moun")){
            for(int j = 0; j < lineCount; j++){
                if (inventoryArray[j][0].replace(" ","").equals("MountainBike")){
                     //CHECKS IF MODEL IS THE SAME
                    if(inventoryArray[j][1].replace(" ", "").equals(requestArray[i][1].replace(" ",""))){
                        // CHECKS THE COLOR
                        if (requestArray[i][2].replace(" ","").equals(inventoryArray[j][4].replace(" ",""))){
                            //CHECKS IF INVENTORY IS LARGER OR EQUAL TO REQUEST
                            if (Integer.valueOf(inventoryArray[j][5].replace(" ", "")) >= Integer.valueOf(requestArray[i][3].replace(" ", ""))) {
                                //UPDATES INVENTORY NUMBER
                                inventoryArray[j][5] = Integer.toString(Integer.valueOf(inventoryArray[j][5].replace(" ", "")) - Integer.valueOf(requestArray[i][3].replace(" ", "")));
                                System.out.println("Your purchase of " + requestArray[i][3] + " " + requestArray[i][0] + "(s) " + requestArray[i][1] + " " + requestArray[i][2] + " has been made!");
                                   profit = profit + ((Integer.valueOf(inventoryArray[j][3].replace(" ", "")) - Integer.valueOf(inventoryArray[j][2].replace(" ", "")) ) * Integer.valueOf(requestArray[i][3].replace(" ", "")));
                                 presentBikes[bikeCount] = i;
//                                   
                                 //UPDATES IF INVENTORY IS LESS THAN REQUEST
                                    if (Integer.valueOf(inventoryArray[j][5].replace(" ", "")) < Integer.valueOf(requestArray[i][3].replace(" ", ""))){
                                            profit = profit + ((Integer.valueOf(inventoryArray[j][3].replace(" ", "")) - Integer.valueOf(inventoryArray[j][2].replace(" ", "")) ) * Integer.valueOf(inventoryArray[j][5].replace(" ", "")));
                                        
                                        presentBikes[bikeCount] = i;
                                        bikeCount++;
                                    
                                        inventoryArray[j][5] = "0";
                                    }
                            }
                            else { 
                                 System.out.println("We can only sell you " + inventoryArray[j][5].replace(" ","") + " bikes of "  + requestArray[i][0] +  " not " + requestArray[i][3]);
                            }
                        }
                        System.out.println();
                    }
                }
             }
        } 
         //CHECKS ROAD BIKE
        if (requestArray[i][0].substring(0,4).replace(" ","").equals("Road")){
            for(int j = 0; j < lineCount; j++){
                if (inventoryArray[j][0].replace(" ","").equals("RoadBike")){
                     //CHECKS IF MODEL IS THE SAME
                    if(inventoryArray[j][1].replace(" ", "").equals(requestArray[i][1].replace(" ",""))){
                        // CHECKS THE COLOR
                        if (requestArray[i][2].replace(" ","").equals(inventoryArray[j][4].replace(" ",""))){
                            //CHECKS IF INVENTORY IS LARGER OR EQUAL TO REQUEST
                            if (Integer.valueOf(inventoryArray[j][5].replace(" ", "")) >= Integer.valueOf(requestArray[i][3].replace(" ", ""))) {
                                //UPDATES INVENTORY NUMBER
                                inventoryArray[j][5] = Integer.toString(Integer.valueOf(inventoryArray[j][5].replace(" ", "")) - Integer.valueOf(requestArray[i][3].replace(" ", "")));
                                System.out.println("Your purchase of " + requestArray[i][3] + " " + requestArray[i][0] + "(s) " + requestArray[i][1] + " " + requestArray[i][2] + " has been made!");
                                   profit = profit + ((Integer.valueOf(inventoryArray[j][3].replace(" ", "")) - Integer.valueOf(inventoryArray[j][2].replace(" ", "")) ) * Integer.valueOf(requestArray[i][3].replace(" ", "")));
                                 //UPDATES IF INVENTORY IS LESS THAN REQUEST
                                    if (Integer.valueOf(inventoryArray[j][5].replace(" ", "")) < Integer.valueOf(requestArray[i][3].replace(" ", ""))){
                                         inventoryArray[j][5] = "0";
                                            profit = profit + ((Integer.valueOf(inventoryArray[j][3].replace(" ", "")) - Integer.valueOf(inventoryArray[j][2].replace(" ", "")) ) * Integer.valueOf(inventoryArray[j][5].replace(" ", "")));
                                        
                                        presentBikes[bikeCount] = i;
                                     
                                    }
                            }
                        }
                        System.out.println();
                    }
                }
             }
        }

         
         
        
        }
    
    for (int i = 0; i < presentBikes.length; i++){
        if (presentBikes[i] < 0) {
             String missing = ("You are missing " + requestArray[i][0] + ", " + requestArray[i][1] + ", " + requestArray[i][2] + ", " + requestArray[i][3]);
                writeFile(fileMissing, missing);
            }
            }
    
    System.out.println();
    return profit;
    }
    // WRITES FILE OF THE MISSING BIKES
    public static void writeFile(String file, String request){
             try {
        FileWriter fileWriter = new FileWriter(file, true);
       PrintWriter printWriter = new PrintWriter(fileWriter);
                    fileWriter.write(request);
                    printWriter.println("");
        printWriter.close();
        fileWriter.close();
}
    catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
    }
    }
 
}
