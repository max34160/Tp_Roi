public class Item {
    private String name;
    private Double price;
    private Double taxRat;

    public Item(String name, Double price , Double taxRat){
        this.name = name;
        this.price = price;
        this.taxRat = taxRat;
    }
    public Double getTotalPrice(){
        double taxRat = this.price * this.taxRat;
        return this.price + taxRat;
    }
    public Double applyDiscount(double percentage){
        double onePourCent  = this.price / 100 ;
        double discount = onePourCent * percentage;
        this.price = this.price - discount;
        return this.price - discount;
    }
    public void displayInfo(){
        System.out.println("Name = " +this.name);
        System.out.println("price = " + this.price);
        System.out.println("taxe Rate = " + this.taxRat);

    }
}
