/*
Author: Johan Zafri bin Johar

This is the Application Java class
*/
import java.util.*;
import java.io.*;
import java.lang.*;
public class MyAss2QApp {
    public static void main(String[] args) throws Exception 
    {
        try
        {
            BufferedReader br = new BufferedReader (new FileReader ("cakeOrder.txt"));
            PrintWriter pickOut = new PrintWriter (new FileWriter ("pickup.txt"));
            PrintWriter delOut = new PrintWriter (new FileWriter ("delivery.txt"));
            Queue cakeQ=new Queue();
            Queue tempQ=new Queue();
            
            //a)b)c)read the data from cakeOrder.txt and insert into cakeQ
            
            //declaration of variables and object
            String s=null, custID, cakeType;
            int qty;
            Cake cakeOrder;

            //read the first line of data in cakeOrder.txt file
            s=br.readLine();

            //the while loop checks whether the data is null or not
            while(s!=null)
            {
                StringTokenizer st=new StringTokenizer(s,"*"); //to break/cut/tokenize the data in the input file
                custID=st.nextToken(); //to get the first item
                cakeType=st.nextToken(); //to get the second item
                qty=Integer.parseInt(st.nextToken()); //to get the third item
                cakeOrder=new Cake(custID, cakeType, qty); //to initialize the item/data into the Cake object (cakeOrder)
                cakeQ.enqueue(cakeOrder); // to insert the data inside cakeOrder into queue named cakeQ
                s=br.readLine(); //to read the next line of data
            }
            
            //d)display the data in the cakeQ

            //to display at the output screen
            System.out.println("Data in the cakeQ:\n");
            
            //the while loop checks whether the cakeQ is empty or not
            while(!cakeQ.isEmpty())
            {
                cakeOrder=cakeQ.dequeue(); //to remove the data from the cakeQ and insert to cakeOrder
                tempQ.enqueue(cakeOrder); //to insert the same data that have been extracted into tempQ
                System.out.println(cakeOrder.toString()); //to print the data in cakeOrder
            }
            
            //the while loop checks whether the tempQ is empty or not
            while(!tempQ.isEmpty())
            {
                cakeQ.enqueue(tempQ.dequeue()); //remove the data from tempQ and insert to cakeQ
            }
            
            //e)The first character of custID is based on the delivery type. if the first character is 'P' 
            //mean the customer choose to pickup the cake and if the first character is 'D', the customer 
            //choose to have delivery service. Example of custID are P002,D112 and etc. Write the data for delivery 
            //into delivery.txt output file and the data for customer that choose self pick up into pickup.txt. 
            
            //declaration of variables and initialize the value zero into it
            int countDelivery=0, countPickUp=0;

            //to print in delivery.txt file
            delOut.println("Data for delivery:\n");

            //to print in pickup.txt file
            pickOut.println("Data for self-pick-up:\n");

            while(!cakeQ.isEmpty())
            {
                cakeOrder=cakeQ.dequeue();
                tempQ.enqueue(cakeOrder);

                //checks if the letter infront of the customer id is equals to "P"
                if(cakeOrder.getID().substring(0,1).equalsIgnoreCase("P"))
                {
                    countPickUp++; //increment the value of countPickUp
                    pickOut.println(countPickUp+")"+cakeOrder.toString()); //to print data of customers that choose self pick-up into pickup.txt file
                }

                //checks if the letter infront of the customer id is equals to "D"
                else if(cakeOrder.getID().substring(0,1).equalsIgnoreCase("D"))
                {
                    countDelivery++; //increment the value of countDelivery
                    delOut.println(countDelivery+")"+cakeOrder.toString()); //to print data of customers that choose delivery into delivery.txt file
                }
            }

            while(!tempQ.isEmpty())
            {
                cakeQ.enqueue(tempQ.dequeue());
            }
            
            //f)Display the total quantity order for each cake type and display the cake 
            //name of the highest total order
            
            //declaration of variables and initialize the value zero into it
            int totalD24=0, totalRedVelvet=0, totalBurntCheese=0, totalBlackForest=0, highestTotal=0;

            while(!cakeQ.isEmpty())
            {
                cakeOrder=cakeQ.dequeue();
                tempQ.enqueue(cakeOrder);

                //checks if the type of cake is equals to "D24 Chocolate Cake"
                if(cakeOrder.getType().equalsIgnoreCase("D24 Chocolate Cake"))
                {
                    totalD24+=cakeOrder.getQuantity(); //adds the value of totalD24 with cake quantity and assign to totalD24
                }

                //checks if the type of cake is equals to "Red Velvet"
                else if(cakeOrder.getType().equalsIgnoreCase("Red Velvet"))
                {
                    totalRedVelvet+=cakeOrder.getQuantity(); //adds the value of totalRedVelvet with cake quantity and assign to totalRedVelvet
                }

                //checks if the type of cake is equals to "Burnt Cheese Cake"
                else if(cakeOrder.getType().equalsIgnoreCase("Burnt Cheese Cake"))
                {
                    totalBurntCheese+=cakeOrder.getQuantity(); //adds the value of totalBurntCheese with cake quantity and assign to totalBurntCheese
                }

                //checks if the type of cake is equals to "Black Forest"
                else if(cakeOrder.getType().equalsIgnoreCase("Black Forest"))
                {
                 totalBlackForest+=cakeOrder.getQuantity(); //adds the value of totalBlackForest with cake quantity and assign to totalBlackForest
                }
                }

                while(!tempQ.isEmpty())
                {
                    cakeQ.enqueue(tempQ.dequeue());
                }

                //to display the total quantity for each type of cake
                System.out.println("\nTotal quantity of D24 Chocolate Cake:"+totalD24);
                System.out.println("Total quantity of Red Velvet Cake:"+totalRedVelvet);
                System.out.println("Total quantity of Burnt Cheese Cake:"+totalBurntCheese);
                System.out.println("Total quantity of Black Forest Cake:"+totalBlackForest);

                //checks if the total quantity of "D24 Chocolate Cake" is greater than other types of cake
                if(totalD24 > totalRedVelvet && totalD24 > totalBurntCheese && totalD24 > totalBlackForest)
                {
                    highestTotal=totalD24; //assign the value of totalD24 into highestTotal
                    System.out.println("\nHighest total order is "+highestTotal+" for D24 Chocolate Cake"); //to display at output screen
                }

                //checks if the total quantity of "Red Velvet" is greater than other types of cake
                else if(totalRedVelvet > totalD24 && totalRedVelvet > totalBurntCheese && totalRedVelvet > totalBlackForest)
                {
                    highestTotal=totalRedVelvet; //assign the value of totalRedVelvet into highestTotal
                    System.out.println("\nHighest total order is "+highestTotal+" for Red Velvet");
                }

                //checks if the total quantity of "Burnt Cheese Cake" is greater than other types of cake
                else if(totalBurntCheese > totalD24 && totalBurntCheese > totalRedVelvet && totalBurntCheese > totalBlackForest)
                {
                    highestTotal=totalBurntCheese; //assign the value of totalBurntCheese into highestTotal
                    System.out.println("\nHighest total order is "+highestTotal+" for Burnt Cheese Cake");
                }

                //checks if the total quantity of "Black Forest" is greater than other types of cake
                else if(totalBlackForest > totalD24 && totalBlackForest > totalRedVelvet && totalBlackForest > totalBurntCheese)
                {
                highestTotal=totalBlackForest; //assign the value of totalBlackForest into highestTotal
                System.out.println("\nHighest total order is "+highestTotal+" for Black Forest");
                }

                //checks if the total quantity of all types of cake are the same
                else
                {
                //assign all type of cakes total quantity value to highestTotal
                highestTotal=totalD24=totalRedVelvet=totalBurntCheese=totalBlackForest;
                System.out.println("\nAll cake have the same total order of "+highestTotal);
            }
            
            //g)Display the receipt that will display the custID, cakeType, price(using detPrice() method), qty, 
            //payment for each order. In order to calculate the payment for each order you need to multiply quantity 
            //with the cake price and it is an extra charge of RM 5.00 for delivery service. Lastly, display the total 
            //payment for all the orders.
            
            //declaration of variables
            int countCust=0;
            String servType;
            double extraCharge=0.00, payment=0.00, totalPayment=0.00;
            
            while(!cakeQ.isEmpty())
            {
                cakeOrder=cakeQ.dequeue();
                tempQ.enqueue(cakeOrder);
                
                countCust++; //increment countCust
                
                servType=" "; //set the String value " " to servType
                
                //checks if the letter infront of the customer id is equals to "P"
                if(cakeOrder.getID().substring(0,1).equalsIgnoreCase("P"))
                {
                    servType="Self Pick-Up"; //assign "Self Pick-Up" to servType
                    extraCharge=0.00; //set extraCharge to 0.00
                }
                
                //checks if the letter infront of the customer id is equals to "D" 
                else if(cakeOrder.getID().substring(0,1).equalsIgnoreCase("D"))
                {
                    servType="Delivery"; //assign "Delivery" to servType
                    extraCharge=5.00; //set extraCharge to 5.00
                }
                
                //calculate payment for each customers order
                payment=(cakeOrder.getQuantity()*cakeOrder.detPrice())+extraCharge;
                
                //adds the value of totalPayment with payment and assign to totalPayment
                totalPayment+=payment;
                
                //to display/print the receipt by each customers order
                System.out.println("\n++++++++++++++++++++++++++++++++++");
                System.out.println("Customer no "+countCust);
                
                System.out.println("++++++++++++++++++++++++++++++++++");
                System.out.println("Customer ID:"+cakeOrder.getID());
                System.out.println("Cake Type:"+cakeOrder.getType());
                System.out.println("Price: RM "+String.format("%.2f",cakeOrder.detPrice()));
                System.out.println("Quantity:"+cakeOrder.getQuantity());
                System.out.println("Delivery/Self PickUp:"+servType);
                System.out.println("Payment: RM "+String.format("%.2f",payment));
            }
            
            
            while(!tempQ.isEmpty())
            {
            cakeQ.enqueue(tempQ.dequeue());
            }
            
            //to display total payment for all the orders
            System.out.println("\nTotal payment: RM "+String.format("%.2f",totalPayment));
                
            br.close();
            pickOut.close();
            delOut.close();
        }
        
        catch(Exception e) {System.err.println(e.getMessage());}
    
    } /***End of main() Method***/   
}/***End of Application Class***/
