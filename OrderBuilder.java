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