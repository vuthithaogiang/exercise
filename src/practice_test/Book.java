package practice_test;




public class Book implements Comparable<Book> {
    private String title;
    private double price;
    private Author name;

    public Book(String title, Author name, double price) throws InvalidPriceException{
        this.title = title;
        this.name   = name;
        this.setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidPriceException {
      if(price > 0) {
          this.price = price;
      }
      else{
          var msg = "Price is invalid!! Price must be > 0.";
          throw new InvalidPriceException(msg,  price);
      }
    }

    public Author getName() {
        return name;
    }

    public void setName(Author name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + title + ", Author: " + name.toString() + ", Price: " + price;
    }

    @Override
    public int compareTo(Book other) {
        return title.compareTo(other.title);
    }


}
