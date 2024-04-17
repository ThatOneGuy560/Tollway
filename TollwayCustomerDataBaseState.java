import java.util.*;
import java.text.NumberFormat;
import java.io.*;


public class TollwayCustomerDataBaseState
   {
    private Name name;
    private CarInfo carInfo;
    private Payment payment;
   public static void main (String args []){
    
   }
    
  
     private static Customer readCustomer(BufferedReader in){
        Customer customer = null;
        try {
            // Read and parse the data from the file to create the customer object
            String line = in.readLine();
            String[] data = line.split(",");
            String name = data[0];
            int id = Integer.parseInt(data[1]);
            double balance = Double.parseDouble(data[2]);
            customer = new Customer(name, id, balance);
        } catch (IOException e) {
            System.out.println("Error reading from file");
            e.printStackTrace();
        }
        return customer;

     }
     
  
     private static BufferedReader getReader(String name){
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader(name))
        } catch (IOException e){
            System.out.println("Error opening file: " + name);
            e.printStackTrace();
        }
        return reader;
     }
  
  }
   

////// Customer Attributes: Name, CarInfo, Payment
class Customer  
   {
    
      
//   public String getInfo()
   
   }

////// Name Attributes: first name, last name
class Name
   {
   
//   public String getInfo()
  

   }

////// CarInfo Attributes: make, model, license_plates
class CarInfo
   {
     
//   public String getInfo()
  
   }

////// Payment Attributes: deposit, credit_card 
class Payment
   {
      
//   public String getInfo()
  
   }

