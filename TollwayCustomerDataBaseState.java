import java.util.*;
import java.text.NumberFormat;
import java.io.*;


public class TollwayCustomerDataBaseState
   {
    
   public static void main (String args []){
      TollwayCustomerDataBaseState program = new TollwayCustomerDataBaseState();
      BufferedReader reader = getReader("Names.txt");
      List<Customer> customers = new ArrayList<>();
  
      if ( reader != null ) {
         Customer customer;
            while ((customer = readCustomer(reader)) != null) {
               customers.add(customer);
            }

            try {
               reader.close();
            } catch (IOException e ){
               System.err.println(" Error closing file: " + e.getMessage());
            }
      }
      
      for (Customer c : customers) {
         System.out.println(c.getInfo());
         System.out.println();
      }
  }    
  
     private static Customer readCustomer(BufferedReader in){
        Customer customer = null;
        try {
            // Read and parse the data from the file to create the customer object
            String line = in.readLine();
        
            if(line == null){
               return null;
            }
            // Split the line into an array of strings, assuming the customer object is serialized with commas
            String[] data = line.split(",");
            
            // Extract the individual data elements from the array
            String firstName = data[0].trim();
            String lastName = data[1].trim();
            Name name = new Name(firstName, lastName);
            
            String make = data[2].trim();
            String model = data[3].trim();
            String license_plate = data[4].trim();
            CarInfo carInfo = new CarInfo(make, model, license_plate);
            
            double amount = Double.parseDouble(data[5].trim());
            String paymentType = data[6].trim();
            Payment payment = new Payment(amount, paymentType);
            
            // Create the Customer object
            customer = new Customer(name, carInfo, payment);

        } catch (IOException e) {
            System.out.println("Error reading from file");
            e.printStackTrace();
        }
        return customer;

     }
     
  
     private static BufferedReader getReader(String name){
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader(name));
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
    private Name name;
    private CarInfo carInfo;
    private Payment payment;

    public Customer(Name name, CarInfo carInfo, Payment payment){
        this.name = name;
        this.carInfo = carInfo;
        this.payment = payment;
    }
   public String getInfo(){
    return "Name: " + name.getInfo() + "\nCar Information: " + carInfo.getInfo() + "\nPayment: " + payment.getInfo();
   }
   
   }

////// Name Attributes: first name, last name
class Name
   {
   private String firstName;
   private String lastName;

   public Name(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
   }
   public String getInfo(){
    return firstName + " " + lastName;
   }
  

   }

////// CarInfo Attributes: make, model, license_plates
class CarInfo
   {
     private String make;
     private String model;
     private String license_plates;

     public CarInfo(String make, String model, String license_plates){
        this.make = make;
        this.model = model;
        this.license_plates = license_plates;
     }
   public String getInfo(){
        return make + " " + model + " " + license_plates; 
   }
   }

////// Payment Attributes: deposit, credit_card 
class Payment
   {
      private double deposit;
      private String credit_card;

      public Payment(Double deposit, String credit_card){
        this.deposit = deposit;
        this.credit_card = credit_card;
      }
  public String getInfo(){
    return String.format("$%,.2f", deposit) + " " + credit_card;
  }
  
   }

