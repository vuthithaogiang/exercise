package practice_test;

public class InvalidPriceException extends Exception{
    private double invalidPrice;

    public InvalidPriceException() {

    }

    public InvalidPriceException(double invalidPrice){
        this.invalidPrice = invalidPrice;
    }

    public InvalidPriceException(String message, double invalidPrice){
        super(message);
        this.invalidPrice = invalidPrice;
    }

    public double getInvalidPrice() {
        return invalidPrice;
    }

    public void setInvalidPrice(double invalidPrice) {
        this.invalidPrice = invalidPrice;
    }
}
