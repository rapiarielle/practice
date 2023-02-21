package rapi;

import java.util.*;
//ang ganda ko
public class Main_Inve {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
        Inventory Inve = new Inventory(); //Creating an object
	
        //Using while loop to continously asking for the correct format.
        while(true){
            System.out.print("Enter Inventory Item ID: ");
            String id = input.nextLine(); //User input an ID
            //Try catch for Exception Handling/
                try{
                    Inve.setId(id); //Set the Item ID
                    break;
                }
                catch(IllegalArgumentException e){
                    System.out.print("Error: Inventory ID must be in the form ABC-1234.\n");
                }
        }
                
        while(true){
            System.out.print("Enter Item Name: ");
            
             String name = input.nextLine(); //User input an Item Name
            
                try{
                    Inve.setName(name); //Set the Item Name
                    break;
                }
                catch(IllegalArgumentException e){
                    System.out.print("Error: you must enter an item name.\n");
                }
        }
                
        while(true){
            
            System.out.print("Qty On Hand: ");
            try{ //try catch for InputMismatchException
               int qoh = input.nextInt(); //User input QOH
                try{
                    Inve.setQoh(qoh);//set the QOH
                    break;
                }
            
                catch(IllegalArgumentException e){
                    System.out.print("Error: QOH must be 0 or more.\n");
                }
            }
            catch(InputMismatchException e){
                    System.out.print("Error: QOH must be a number\n");
                    input.nextLine();
            }
        }
                
        while(true){
            System.out.print("Re-Order Point: ");
            try{// Try catch for ROP's InputMismatchExeption
            int rop = input.nextInt(); //User input ROP
                try{
                 Inve.setRop(rop); //set the ROP
                 break;
                }
                catch(IllegalArgumentException e){
                    System.out.print("Error: ROP must be greater than 0.\n");
                }
            }
            catch(InputMismatchException e){
                System.out.print("Error: ROP  must be a number\n");
                input.nextLine();
            }
        }
                
        while(true){
            System.out.print("Selling Price: ");
            try{
            double sellPrice = input.nextDouble(); //User input sellPrice
		try{
                    Inve.setSellPrice(sellPrice); //Set the sellPrice
                    System.out.println();
                    break;
                }
                catch(IllegalArgumentException e){
                    System.out.print("Error: Selling price must be greater than 0\n");
                }
            }
                 
            catch(InputMismatchException e){
                System.out.print("Error: Selling price must be a number\n");
                input.nextLine();
            }
        }
		
        System.out.print(Inve.toString());
            if (Inve.getQoh() < Inve.getRop()){
                System.out.printf("You need to order more %s.\n" ,Inve.getName());
            }
        while(true){
            System.out.print("\nEnter# of units to buy: ");
            try{
                double unit = input.nextDouble();//user input units to buy
                double total;
                //checking if the unit is equal or less than 0        
                if(unit <= 0){
                     total = 0;
                }
                else{
                    total = unit * Inve.getSellPrice() + ((Inve.getSellPrice() * unit) * 0.13); //total with tsh
                }
            System.out.printf("Total cost: %.2f \n", total ); //Printing the total
            break;
        }
         catch(InputMismatchException e){
                System.out.print("Error: Selling Price must be a number\n");
                input.nextLine();
            }
        }
                
       
    }
}


