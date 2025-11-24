
class LemonadeDecorator extends OrderDecorator {
    public LemonadeDecorator(Order order) {
        super(order);
    }

    public double getPrice() {
        return wrappee.getPrice() + 5;
    }

    public String getTitle() {
        return wrappee.getTitle() + " + Limonada";
    }
}
