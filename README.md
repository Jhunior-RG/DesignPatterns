# Sistema de Gestión de Órdenes de Restaurante de Pollos Broaster

Este proyecto implementa un sistema para la gestión de órdenes en un restaurante de pollos broaster utilizando **Java** y aplicando los patrones de diseño **Builder**, **Decorator** y **State**. El sistema permite crear órdenes base, personalizarlas con extras y gestionar su ciclo de vida completo.

## Funcionalidades Principales

- Creación de órdenes base (por ejemplo: Pollo Broaster 1/4 y 1/2).
- Personalización dinámica mediante bebidas y guarniciones.
- Control del ciclo de vida de las órdenes:
  - Pendiente
  - En preparación
  - Lista
  - Entregada

## Patrones de Diseño Implementados

### Builder (Creacional)
Utilizado para construir órdenes paso a paso, evitando configuraciones incorrectas y permitiendo recetas predefinidas.

**Componentes:**
- `OrderBuilder`
- `ChickenOrderBuilder`
- `OrderDirector`

### Decorator (Estructural)
Permite agregar bebidas y guarniciones sin alterar la estructura de la orden original.

**Decoradores incluidos:**
- `CocaColaDecorator`
- `LemonadeDecorator`
- `RiceDecorator`
- `PotatoesDecorator`

### State (Comportamiento)
Gestiona los estados de una orden y define su comportamiento según el estado actual.

**Estados implementados:**
- `PendingState`
- `PreparingState`
- `ReadyState`
- `DeliveredState`

## Estructura del Proyecto
```
RestaurantPatternSystem.java
├── Order (interfaz)
├── ChickenOrder
├── OrderBuilder / ChickenOrderBuilder
├── OrderDirector
├── OrderDecorator
├── RiceDecorator
├── PotatoesDecorator
├── CocaColaDecorator
├── LemonadeDecorator
├── States
├── OrderState
├── PendingState
├── PreparingState
├── ReadyState
├── DeliveredState
└── OrderManager
```
## Ejecución

Compilar y ejecutar:

```bash
javac RestaurantPatternSystem.java
java RestaurantPatternSystem
```
