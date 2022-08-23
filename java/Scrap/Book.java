public interface Book{
    String getAuthor();

    String getTitle();
}

class RedBook implements Book {
    String author;
    String title;
    public RedBook(){
        this.author = "Red author";
        this.title = "Red title";
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }
}

class BlueBook implements Book {
    String author;
    String title;
    public BlueBook(){
        this.author = "Blue author";
        this.title = "Blue title";
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }
}
