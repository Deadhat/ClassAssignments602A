/*Ryan Scott Hutton
 * CIS 602A
 * 04/11/14 Assignment 5.2
 * Create a class named Purchase. Each Purchase contains an invoice number, amount of sale, 
 * and amount of sales tax. Include set methods for the invoice number and sale amount. Within the 
 * set() method for the sale amount, calculate the sales tax as 7.5% (using a static field in the Purchase 
 * class) of the sale amount. Also include a display method that displays a purchase's details in a well 
 * formatted output display.*/


import java.util.*;

 public class Purchase {
    
	//our 4 program variables
	private double salesTax;
    private int invoiceNumber;
    private double salesAmount;
    private static double taxRate = 0.075; 
 
    
    
    //setter method for our total sales. the set method also calculates our sales tax
    public void setSales(double salesTotal){
        salesAmount = salesTotal;
        salesTax = Purchase.taxRate*salesTotal; //Since taxRate is a static variable, we must use the full class name, instead of pur object
    }
        
    //method displays our invoice, sales, and sales tax amount.
    public static void displaySalesInformation(Purchase Purch){
    	System.out.println("Sales Tax: " + Purch.salesTax);
    	System.out.println("Invoice Number: " + Purch.invoiceNumber);
        System.out.println("Sales Amount: " + Purch.salesAmount);
        
    } 
    
    //setter for invoice number
    public void setInvoiceNum(int invNum){
        invoiceNumber = invNum;
    }

    
    

    /*Our main method, creates a scanner to capture the invoice and sales amount
     * we then create a purchase object and call our methods*/   
    public static void main (String[] args) {
    	Purchase thePurchase = new Purchase();
    	
    	//Ask the user for the sales and invoice number
        Scanner getThoseNumbers = new Scanner(System.in);
        System.out.println("Enter your Sales Amount:");
        double sales = getThoseNumbers.nextDouble();
        
        System.out.println("Enter your invoice Number:" );
        int inv = getThoseNumbers.nextInt();

        

       
        //method calls
        thePurchase.setInvoiceNum(inv);
        thePurchase.setSales(sales);
        displaySalesInformation(thePurchase);     
    }

}
