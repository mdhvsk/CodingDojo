package baristaChallenge;
import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item>items;

    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getName(){
        return this.name;
    }

    public void setReady(boolean status){
        this.ready = status;
    }

    public boolean getReady(){
        return this.ready;
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void addItem(Item newOrder){
        this.items.add(newOrder);
    }

    public String getStatusMessage(){
        if (this.ready == true){
            return "Your order is ready";
        }
        return "Thank you for waiting. Your order will be ready soon.";
    }

    public double getTotal(){
        double total = 0;
        for (int i=0; i<this.items.size();i++){
            System.out.println(this.items.get(i));
            Item currentItem = this.items.get(i);
            total += currentItem.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.printf("Customer name: %s \n", this.name);
        for (int i=0; i<this.items.size(); i++){
            System.out.printf("%s: %s \n",this.items.get(i).getName(), this.items.get(i).getPrice());
        }
        System.out.printf("Total: $%s", getTotal());


    }




}
