public class BookTest {

 
    public static void main(String[]args) throws Exception{
  
        Class<?> c = Class.forName(args[0]);
        Constructor <?> cr = c.getConstructor(Book.class);
        Object o =  cr.newInstance();
        print((Book)c);


    }

    public static void print(Book book){
        System.out.println(book.getAuthor() + "::::" + book.getTitle());
    }
    
}

