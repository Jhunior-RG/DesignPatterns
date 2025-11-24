class PendingState extends OrderState {
    public PendingState(Order order) {
        super(order);
    }

    public void prepare() {
        System.out.println("Preparando: " + order.getTitle() + " - Bs. " + order.getPrice());
        order.setState(new PreparingState(order));
    }

    public void ready() {
        System.out.println("Error: Aun esta pendiente");
    }

    public void deliver() {
        System.out.println("Error: Aun esta pendiente");
    }
}
