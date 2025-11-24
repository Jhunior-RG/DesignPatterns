
class PreparingState extends OrderState {
    public PreparingState(Order order) {
        super(order);
    }

    public void prepare() {
        System.out.println("Error: Ya esta en preparacion");
    }

    public void ready() {
        System.out.println("Listo para entregar: " + order.getTitle());
        order.setState(new ReadyState(order));
    }

    public void deliver() {
        System.out.println("Error: Debe estar lista primero");
    }
}