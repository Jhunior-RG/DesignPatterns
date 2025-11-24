/*
 * Aplicación Principal
 */
public class RestaurantPatternSystem {
    public static void main(String[] args) {
        OrderBuilder builder = new ChickenOrderBuilder();
        OrderDirector director = new OrderDirector();
        OrderManager manager = new OrderManager();

        Order order1 = director.createBroasterChicken(builder);
        Order order2 = director.createBroasterChickenHalf(builder);

        order1 = new RiceDecorator(order1);
        order1 = new CocaColaDecorator(order1);

        order2 = new PotatoesDecorator(order2);
        order2 = new LemonadeDecorator(order2);

        manager.addOrder(order1);
        manager.addOrder(order2);

        manager.prepareOrder(order1);
        manager.markOrderReady(order1);
        manager.deliverOrder(order1);

        manager.markOrderReady(order2);
        manager.prepareOrder(order2);
        manager.prepareOrder(order2);
        manager.markOrderReady(order2);
        manager.deliverOrder(order2);
    }
}