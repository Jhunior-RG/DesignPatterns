
class RiceDecorator extends OrderDecorator {
    public RiceDecorator(Order order) {
        super(order);
    }

    public double getPrice() {
        return wrappee.getPrice() + 10;
    }

    public String getTitle() {
        return wrappee.getTitle() + " + Arroz";
    }
}