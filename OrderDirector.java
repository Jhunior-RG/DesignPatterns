
/*
 * Patrón creacional BUILDER
 * Director crea órdenes predefinidas
 */
class OrderDirector {
    public Order createBroasterChicken(OrderBuilder builder) {
        return builder.reset().withTitle("Pollo Broaster").withPrice(17).build();
    }

    public Order createBroasterChickenHalf(OrderBuilder builder) {
        return builder.reset().withTitle("Pollo Broaster 1/2").withPrice(45).build();
    }
}
