interface Order {

    String getTitle();

    double getPrice();

    OrderState getState();

    void setState(OrderState state);
}

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

/*
 * Patron creacional BUILDER
 * Construye ordenes paso a paso
 */
interface OrderBuilder {
    OrderBuilder withTitle(String title);

    OrderBuilder withPrice(double price);

    OrderBuilder reset();

    Order build();

}

class ChickenOrderBuilder implements OrderBuilder {

    private String title;
    private double price = 0.0;

    public OrderBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public OrderBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public OrderBuilder reset() {
        title = null;
        price = 0.0;
        return this;
    }

    public Order build() {
        return new ChickenOrder(title, price);
    }
}

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

class CocaColaDecorator extends OrderDecorator {
    public CocaColaDecorator(Order order) {
        super(order);
    }

    public double getPrice() {
        return wrappee.getPrice() + 15;
    }

    public String getTitle() {
        return wrappee.getTitle() + " + Coca Cola";
    }
}

class LemonadeDecorator extends OrderDecorator {
    public LemonadeDecorator(Order order) {
        super(order);
    }

    public double getPrice() {
        return wrappee.getPrice() + 5;
    }

    public String getTitle() {
        return wrappee.getTitle() + " + Limonada";
    }
}

class RiceDecorator extends OrderDecorator {
    public RiceDecorator(Order order) {
        super(order);
    }

    public double getPrice() {
        return wrappee.getPrice() + 10;
    }

    public String getTitle() {
        return wrappee.getTitle() + " + Arroz";
    }
}

class PotatoesDecorator extends OrderDecorator {
    public PotatoesDecorator(Order order) {
        super(order);
    }

    public double getPrice() {
        return wrappee.getPrice() + 10;
    }

    public String getTitle() {
        return wrappee.getTitle() + " + Papas";
    }
}

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

class ReadyState extends OrderState {
    public ReadyState(Order order) {
        super(order);
    }

    public void prepare() {
        System.out.println("Error: Ya esta lista");
    }

    public void ready() {
        System.out.println("Error: Ya esta lista");
    }

    public void deliver() {
        System.out.println("Entregado: " + order.getTitle());
        order.setState(new DeliveredState(order));
    }
}

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