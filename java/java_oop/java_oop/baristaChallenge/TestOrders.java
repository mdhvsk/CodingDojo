package baristaChallenge;

public class TestOrders {
    public static void main(String[] args){
        Order unNamedOrder1 = new Order();
        Order unNamedOrder2 = new Order();
        Order namedOrder1 = new Order("Hugh");
        Order namedOrder2 = new Order("Billy");
        Order namedOrder3 = new Order("Annie");
    
        System.out.println(unNamedOrder1.getName());
        System.out.println(namedOrder1.getName());

        Item item1 = new Item("mocha", 6.25);
        Item item2 = new Item("latte", 5.50);
        Item item3 = new Item("dripCoffe", 4.50);
        Item item4 = new Item("capuccino", 4.75);

        unNamedOrder1.addItem(item1);
        unNamedOrder1.addItem(item2);
        unNamedOrder2.addItem(item3);
        unNamedOrder2.addItem(item4);

        namedOrder1.addItem(item1);
        namedOrder1.addItem(item3);
        namedOrder2.addItem(item2);
        namedOrder2.addItem(item4);
        namedOrder3.addItem(item1);
        namedOrder3.addItem(item4);


        namedOrder2.setReady(true); 
        System.out.println(namedOrder2.getStatusMessage());
        System.out.println(namedOrder2.getTotal());

        namedOrder3.display();





    }


}
