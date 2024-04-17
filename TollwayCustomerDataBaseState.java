import java.util.*;
import java.text.NumberFormat;
import java.io.*;


public class TollwayCustomerDataBaseState
   {
    
   public static void main (String args []){
    Name nice = new Name("Chris", "Ho");
    System.out.println(nice);
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
    
  }
  
   }

