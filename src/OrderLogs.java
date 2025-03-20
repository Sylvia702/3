import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PizzaOrder {
    private String pizza;
    private String sideDish;
    private String drink;

    public PizzaOrder(String pizza, String sideDish, String drink) {
        this.pizza = pizza;
        this.sideDish = sideDish;
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Pizza: " + pizza + ", Side Dish: " + sideDish + ", Drink: " + drink;
    }
}

class OrderLogs {
    private ArrayDeque<String> orderLogs;

    public OrderLogs() {
        orderLogs = new ArrayDeque<>();
    }

    public void addOrderLog(String log) {
        orderLogs.push(log);
    }

    private void mostRecentLogEntry() {
        if (!orderLogs.isEmpty()) {
            System.out.println("Most recent log: " + orderLogs.peek());
        } else {
            System.out.println("The log stack is empty.");
        }
    }

    private String getOrderLog() {
        if (!orderLogs.isEmpty()) {
            return orderLogs.pop();
        }
        System.out.println("The log stack is empty.");
        return null;
    }

    private void removeAllLogEntries() {
        orderLogs.clear();
        System.out.println("All log entries removed.");
    }

    private boolean orderLogsEmpty() {
        return orderLogs.isEmpty();
    }

    public void handleLogs() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose what you want to do with order logs:");
            System.out.println("1. Display all the logs");
            System.out.println("2. Display the most recent logs");
            System.out.println("3. Remove a log entry");
            System.out.println("4. Remove all log entries");
            System.out.println("5. Check if the log is completely empty");
            System.out.println("Enter your choice (1 - 5)");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayOrderLogs();
                    break;
                case 2:
                    mostRecentLogEntry();
                    break;
                case 3:
                    getOrderLog();
                    break;
                case 4:
                    removeAllLogEntries();
                    break;
                case 5:
                    if (orderLogsEmpty()) {
                        System.out.println("The log is completely empty");
                    } else {
                        System.out.println("The log is not completely empty");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayOrderLogs() {
        if (!orderLogs.isEmpty()) {
            System.out.println("All order logs:");
            for (String log : orderLogs) {
                System.out.println(log);
            }
        } else {
            System.out.println("The log stack is empty.");
        }
    }
}

class PizzaOrderQueue {
    private Queue<PizzaOrder> orderQueue;

    public PizzaOrderQueue() {
        orderQueue = new LinkedList<>();
    }

    public void addOrder(PizzaOrder order) {
        orderQueue.add(order);
    }

    public void displayQueue() {
        if (!orderQueue.isEmpty()) {
            System.out.println("Current pizza orders in queue:");
            for (PizzaOrder order : orderQueue) {
                System.out.println(order);
            }
        } else {
            System.out.println("The order queue is empty.");
        }
    }

    public void processNextOrder() {
        if (!orderQueue.isEmpty()) {
            System.out.println("Processing next order: " + orderQueue.poll());
        } else {
            System.out.println("No orders in the queue to process.");
        }
    }

    public boolean isQueueEmpty() {
        return orderQueue.isEmpty();
    }

    public void handleQueue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose what you want to do with pizza orders queue:");
            System.out.println("1. Add a new order");
            System.out.println("2. Display all orders in queue");
            System.out.println("3. Process the next order");
            System.out.println("4. Check if the queue is empty");
            System.out.println("Enter your choice (1 - 4)");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter pizza details:");
                    String pizza = scanner.nextLine();
                    System.out.println("Enter side dish details:");
                    String sideDish = scanner.nextLine();
                    System.out.println("Enter drink details:");
                    String drink = scanner.nextLine();
                    PizzaOrder newOrder = new PizzaOrder(pizza, sideDish, drink);
                    addOrder(newOrder);
                    break;
                case 2:
                    displayQueue();
                    break;
                case 3:
                    processNextOrder();
                    break;
                case 4:
                    if (isQueueEmpty()) {
                        System.out.println("The order queue is empty");
                    } else {
                        System.out.println("The order queue is not empty");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OrderLogs orderLogs = new OrderLogs();
        orderLogs.addOrderLog("Order 1 placed at 10:00 AM");
        orderLogs.addOrderLog("Order 2 placed at 10:30 AM");
        orderLogs.handleLogs();

        PizzaOrderQueue pizzaOrderQueue = new PizzaOrderQueue();
        pizzaOrderQueue.handleQueue();
    }
}