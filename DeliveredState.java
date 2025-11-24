
class DeliveredState extends OrderState {
    public DeliveredState(Order order) {
        super(order);
    }

    public void prepare() {
        System.out.println("Error: Ya fue entregada");
    }

    public void ready() {
        System.out.println("Error: Ya fue entregada");
    }

    public void deliver() {
        System.out.println("Error: Ya fue entregada");
    }
}