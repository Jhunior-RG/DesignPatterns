/*
 * Patron de comportamiento STATE
 * Encapsula comportamiento segun el estado
 */
abstract class OrderState {
    protected Order order;

    public OrderState(Order order) {
        this.order = order;
    }

    public abstract void prepare();

    public abstract void ready();

    public abstract void deliver();
}
