import java.util.ArrayList;
import java.util.Scanner;

public class HandleOrders {
    private static final double PIZZA_BASE_PRICE = 10.0;
    private String[] pizzasOrdered = new String[10];
    private String[] pizzaSizesOrdered = new String[10];
    private String[] sideDishesOrdered = new String[20];
    private String[] drinksOrdered = new String[20];
    private double totalOrderPrice = 0.0;
    private int numberOfPizzasOrdered = 0;
    StringBuilder pizzaOrderSummary = new StringBuilder();
    Scanner input = new Scanner(System.in);
    private ArrayList<CustomPizza> customPizzas = new ArrayList<>();

    public void takeOrder() {
        System.out.println("Do you want a custom pizza? (yes/no)");
        String customPizzaChoice = input.nextLine();
        if ("yes".equalsIgnoreCase(customPizzaChoice)) {
            StringBuilder customPizzaToppings = new StringBuilder();
            while (true) {
                System.out.println("Enter a topping (or 'done' to finish):");
                String topping = input.nextLine();
                if ("done".equalsIgnoreCase(topping)) {
                    break;
                }
                customPizzaToppings.append(topping).append(", ");
            }
            double customPizzaPrice = PIZZA_BASE_PRICE + customPizzaToppings.length() / 2;
            CustomPizza newCustomPizza = new CustomPizza(customPizzaToppings.toString(), customPizzaPrice);
            customPizzas.add(newCustomPizza);
        } else {
        }
    }

    public void createOrderSummary() {
    }

    @Override
    public String toString() {
        return pizzaOrderSummary.toString();
    }

    public void displayCustomPizzas() {
        System.out.println("Custom Pizzas Ordered:");
        for (CustomPizza pizza : customPizzas) {
            System.out.println(pizza);
        }
    }

    public static void main(String[] args) {
        HandleOrders orderHandler = new HandleOrders();
        orderHandler.takeOrder();
        orderHandler.createOrderSummary();
        orderHandler.displayCustomPizzas();
        System.out.println(orderHandler);
    }
}

class CustomPizza {
    private String toppings;
    private double price;

    public CustomPizza(String toppings, double price) {
        this.toppings = toppings;
        this.price = price;
    }

    public String getToppings() {
        return toppings;
    }

    public double getPrice() {
        return price;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomPizza{" +
                "toppings='" + toppings + '\'' +
                ", price=" + price +
                '}';
    }
}