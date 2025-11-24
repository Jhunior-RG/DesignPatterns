
class CocaColaDecorator extends OrderDecorator {
    public CocaColaDecorator(Order order) {
        super(order);
    }

    public double getPrice() {
        return wrappee.getPrice() + 15;
    }

    public String getTitle() {
        return wrappee.getTitle() + " + Coca Cola";
    }
}