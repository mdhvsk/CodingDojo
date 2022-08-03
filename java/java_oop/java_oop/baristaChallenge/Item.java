package baristaChallenge;

public class Item {
    private String name;
    private double price;
    
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void setName(String newName){
        this.name = newName;
    }
    public String getName(){
        return this.name;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    public double getPrice(){
        return this.price;
    }
    
}

