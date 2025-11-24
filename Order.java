interface Order {

    String getTitle();

    double getPrice();

    OrderState getState();

    void setState(OrderState state);
}