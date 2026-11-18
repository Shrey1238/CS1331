/**
 * A checked exception thrown when attempting to find an item that is out of stock.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class OutOfStockException extends Exception {

    /**
     * Creates an OutOfStockException for the given item.
     *
     * @param item the name of the item that is not in stock
     */
    public OutOfStockException(String item) {
        super(item + " is not in stock.");
    }
}
