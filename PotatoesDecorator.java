class PotatoesDecorator extends OrderDecorator {
    public PotatoesDecorator(Order order) {
        super(order);
    }

    public double getPrice() {
        return wrappee.getPrice() + 10;
    }

    public String getTitle() {
        return wrappee.getTitle() + " + Papas";
    }
}