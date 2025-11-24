class OrderManager {

    public void addOrder(Order order) {
        System.out.println("Registrado: " + order.getTitle() + " - Bs. " + order.getPrice());
    }

    public void prepareOrder(Order order) {
        order.getState().prepare();
    }

    public void markOrderReady(Order order) {
        order.getState().ready();
    }

    public void deliverOrder(Order order) {
        order.getState().deliver();
    }
}
