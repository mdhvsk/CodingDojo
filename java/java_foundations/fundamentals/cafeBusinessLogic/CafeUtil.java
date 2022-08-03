package cafeBusinessLogic;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicBorders.MenuBarBorder;

public class CafeUtil {
    
    public int getStreakGoal(int numWeeks){
        int points = 0;
        for (int i = 0; i < numWeeks; i++){
            points += i;
        }
        return points;
    } 

    public double getOrderTotal(double[] prices){
        double total = 0;
        for (int i = 0; i < prices.length;i++){
            total += prices[i];
        }
        return total;
    }

    public void displayMenu(ArrayList<String>menuitems){
        for (int i = 0; i < menuitems.size() ; i++){
            System.out.print(i + ": ");
            System.out.println(menuitems.get(i));
        }
    }

    public void addCustomer(ArrayList<String>customers){
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        int lineSize = customers.size();
        System.out.printf("There are %s people in front of you", lineSize);
        customers.add(userName);
        System.out.println(customers);


    }
}
