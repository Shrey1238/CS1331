import java.util.ArrayList;

/**
 * Represents a vending machine that sells items, all at the same price.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class VendingMachine {
    private ArrayList<String> stock;
    private int cost;

    /**
     * Creates a VendingMachine with the given stock and cost per item.
     *
     * @param stock the list of items in stock within the vending machine
     * @param cost  the price in whole dollars of each item
     */
    public VendingMachine(ArrayList<String> stock, int cost) {
        this.stock = stock;
        this.cost = cost;
    }

    /**
     * Checks whether every item in the order is in stock, regardless of quantity.
     *
     * @param order the list of items to look for
     * @throws OutOfStockException if an item in the order is not in stock
     */
    public void checkStock(ArrayList<String> order) throws OutOfStockException {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        for (String item : order) {
            if (!stock.contains(item)) {
                throw new OutOfStockException(item);
            }
        }
        System.out.println("All items are in stock!");
    }

    /**
     * Buys an item from the vending machine, removing it from stock.
     *
     * @param item  the name of the item to buy
     * @param money the amount of money in whole dollars the user has
     * @throws OutOfStockException if the item is not in stock
     */
    public void buyItem(String item, int money) throws OutOfStockException {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        if (!stock.contains(item)) {
            throw new OutOfStockException(item);
        }
        if (money < cost) {
            throw new NotEnoughMoneyException();
        }
        stock.remove(item);
        System.out.println(item + " successfully vended!");
    }

    /**
     * Finds which of the given favorite items are currently in stock.
     *
     * @param favoriteItems the list of favorite items to look for
     * @return a new ArrayList of the favorite items that are in stock
     */
    public ArrayList<String> availableFavorites(ArrayList<String> favoriteItems) {
        if (favoriteItems == null) {
            throw new IllegalArgumentException("Favorite items cannot be null.");
        }
        ArrayList<String> available = new ArrayList<>();
        for (String item : favoriteItems) {
            if (stock.contains(item)) {
                available.add(item);
            }
        }
        return available;
    }

    /**
     * Simulates a trip to the vending machine.
     *
     * @param args the command-line arguments (unused)
     */
    public static void main(String[] args) {
        ArrayList<String> vendingItems = new ArrayList<>();
        vendingItems.add("Doritos");
        vendingItems.add("Skittles");
        vendingItems.add("Pretzels");
        vendingItems.add("Gatorade");
        vendingItems.add("Oreos");

        ArrayList<String> favorites = new ArrayList<>();
        favorites.add("Oreos");
        favorites.add("Takis");
        favorites.add("Gatorade");

        VendingMachine machine = new VendingMachine(vendingItems, 2);

        try {
            machine.checkStock(vendingItems);
            machine.buyItem("Doritos", 5);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

        try {
            machine.buyItem("Skittles", 1);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

        try {
            machine.buyItem("Takis", 5);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

        try {
            machine.buyItem("Takis", 1);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

        try {
            for (String item : machine.availableFavorites(favorites)) {
                System.out.println(item);
            }
        } finally {
            System.out.println("Took a trip to the vending machine!");
        }
    }
}
