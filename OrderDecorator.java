/*
 * Patrón estructural Decorator
 * Agrega funcionalidades extras sin modificar la orden original
 */
abstract class OrderDecorator implements Order {
    protected Order wrappee;

    public OrderDecorator(Order order) {
        this.wrappee = order;
        wrappee.setState(new PendingState(this));
    }

    public OrderState getState() {
        return wrappee.getState();
    }

    public void setState(OrderState state) {
        wrappee.setState(state);
    }

    public void prepare() {
        wrappee.getState().prepare();
    }

    public void ready() {
        wrappee.getState().ready();
    }

    public void deliver() {
        wrappee.getState().deliver();
    }
}