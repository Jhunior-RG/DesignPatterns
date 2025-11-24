
/*
 * Patrón de comportamiento State
 * cambia su comportamiento según el estado
 */
class ChickenOrder implements Order {
    private String title;
    private double price;
    private OrderState state;

    public ChickenOrder(String title, double price) {
        this.title = title;
        this.price = price;
        this.state = new PendingState(this);
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}