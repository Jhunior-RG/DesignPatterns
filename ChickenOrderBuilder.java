
class ChickenOrderBuilder implements OrderBuilder {

    private String title;
    private double price = 0.0;

    public OrderBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public OrderBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public OrderBuilder reset() {
        title = null;
        price = 0.0;
        return this;
    }

    public Order build() {
        return new ChickenOrder(title, price);
    }
}
