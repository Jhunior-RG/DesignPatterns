
class ReadyState extends OrderState {
    public ReadyState(Order order) {
        super(order);
    }

    public void prepare() {
        System.out.println("Error: Ya esta lista");
    }

    public void ready() {
        System.out.println("Error: Ya esta lista");
    }

    public void deliver() {
        System.out.println("Entregado: " + order.getTitle());
        order.setState(new DeliveredState(order));
    }
}