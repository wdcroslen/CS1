
import java.io.*;
import java.util.Scanner;
import java.util.*;
public class lab2 {
    private static String array[];
    
public static String[][] readSudoku(String filename)  {
    String[][] sudoku = new String[9][9];
    String[] line = new String[81];
    int j = 0;
    int i = 0;
try {
    FileReader fr = new FileReader(filename);
    BufferedReader read = new BufferedReader(fr);
    Scanner in = new Scanner(filename);
    String currentLine;
    
    while ((currentLine = read.readLine()) != null) {
        line = currentLine.split(","); 
        
        for  (j = 0; j<sudoku[i].length; j++){
            sudoku[i][j] = line[j];
        }
        i++;
        
    }
    read.close();
}
    
    
catch (FileNotFoundException e) {
        System.out.println("File not found.");        
}  
catch (IOException e) {
        System.out.println("The file is corrupt.");
}
    
catch (ArrayIndexOutOfBoundsException e) {
        System.out.println ("Your file went out of bounds.");
            }
    
    return sudoku;
}
    
public static void printSudoku(String[][] sudoku){
    System.out.println();
    for (int k = 0; k < sudoku.length; k++) {
        if ((k==3)|| (k==6)) {
            System.out.println();
        }
            System.out.print(" | ");
        for (int l = 0; l < sudoku.length; l++) {
            if ((l == 8)||(l == 2)||(l == 5)) {
               System.out.print(sudoku[k][l] + " | ");  
            }
                
            else {
                System.out.print(sudoku[k][l] + " ");
                }
            }   
            System.out.println();
        }  
      
}

public static boolean checkSudoku(String[][] a){ 
    boolean good = true;
    int i =0; 
    int j =0;
    int original = 0;
    int duplicate = 0;
//NOT 1 - 9
     for (i = 0; i<a.length; i++){
        for (j = 0; j<a.length; j++){
            if ((a[i][j].equals(0)) || (Integer.valueOf(a[i][j]) > 9)){
                good = false;
            }
        }
     }
    // ROWS
for (i = 0; i<a.length; i++){
    for (original = 0; original<a.length; original++){
        for (duplicate = 0; duplicate<a.length; duplicate++){
            if(a[i][original].equals(a[i][duplicate]) && (original != duplicate)){
                good = false;
            }
        }
    }
}
    // COLUMNS
for (j = 0; j<a.length; j++){
    for (original = 0; original<a.length; original++){
        for (duplicate = 0; duplicate<a.length; duplicate++){
            if(a[original][j].equals(a[duplicate][j]) && (original != duplicate)){
                good = false;
            }
        }
    }
}
    // FIRST ROW OF BOXES
for (i =0; i<3; i++){
for (j = 0; j<3; j++){
    for (original = 0; original<3; original++){
        for (duplicate = 0; duplicate<3; duplicate++){
            if(a[original][j].equals(a[i][duplicate]) && (original != i) && (j != duplicate)){
                good = false;
            }
           
        }
    }
}
}
for (i =0; i<3; i++){
for (j = 3; j<6; j++){
    for (original = 0; original<3; original++){
        for (duplicate = 3; duplicate<6; duplicate++){
            if(a[original][j].equals(a[i][duplicate]) && (original != i) && (j != duplicate)){
                good = false;
            }
           
        }
    }
}
}
for (i =0; i<3; i++){
for (j = 6; j<9; j++){
    for (original = 0; original<3; original++){
        for (duplicate = 6; duplicate<9; duplicate++){
            if(a[original][j].equals(a[i][duplicate]) && (original != i) && (j != duplicate)){
                good = false;
            }
           
        }
    }
}
}
 // SECOND ROW OF BOXES 
for (i =3; i<6; i++){
for (j = 0; j<3; j++){
    for (original = 3; original<6; original++){
        for (duplicate = 0; duplicate<3; duplicate++){
            if(a[original][j].equals(a[i][duplicate]) && (original != i) && (j != duplicate)){
                good = false;
            }
           
        }
    }
}
}
for (i =3; i<6; i++){
for (j = 3; j<6; j++){
    for (original = 3; original<6; original++){
        for (duplicate = 3; duplicate<6; duplicate++){
            if(a[original][j].equals(a[i][duplicate]) && (original != i) && (j != duplicate)){
                good = false;
            }
           
        }
    }
}
}
for (i =3; i<6; i++){
for (j = 6; j<9; j++){
    for (original = 3; original<6; original++){
        for (duplicate = 6; duplicate<9; duplicate++){
            if(a[original][j].equals(a[i][duplicate]) && (original != i) && (j != duplicate)){
                good = false;
            }
           
        }
    }
}
}
    
    
// THIRD ROW OF BOXES
for (i = 6; i<9; i++){
for (j = 0; j<3; j++){
    for (original = 6; original<9; original++){
        for (duplicate = 0; duplicate<3; duplicate++){
            if(a[original][j].equals(a[i][duplicate]) && (original != i) && (j != duplicate)){
                good = false;
            }
           
        }
    }
}
}
for (i = 6; i<9; i++){
for (j = 3; j<6; j++){
    for (original = 6; original<9; original++){
        for (duplicate = 3; duplicate<6; duplicate++){
            if(a[original][j].equals(a[i][duplicate]) && (original != i) && (j != duplicate)){
                good = false;
            }
           
        }
    }
}
}
for (i = 6; i<9; i++){
for (j = 6; j<9; j++){
    for (original = 6; original<9; original++){
        for (duplicate = 6; duplicate<9; duplicate++){
            if(a[original][j].equals(a[i][duplicate]) && (original != i) && (j != duplicate)){
                good = false;
            }
           
        }
    }
}
}
    return good;
}
public static void resultSudoku(boolean yesNo) {
   
if (yesNo == true) {
        System.out.println("The Sudoku is correct!");
}
else {
        System.out.println("The Sudoku is incorrect.");
}
}

public static void main(String[] args) {
    String text = args[0];
    String text1 = "Sudoku.txt";
    String text2 = "BadSudoku.txt";
    String text3 = "BadSudoku2.txt";
    String text4 = "GoodSudoku.txt";
    String text5 = "BadSudoku3.txt";
    printSudoku(readSudoku(text1));
    resultSudoku(checkSudoku(readSudoku(text1)));
}
    
}