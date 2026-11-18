/**
 * An unchecked exception thrown when attempting to buy an item without sufficient funds.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class NotEnoughMoneyException extends RuntimeException {

    /**
     * Creates a NotEnoughMoneyException with the insufficient funds message.
     */
    public NotEnoughMoneyException() {
        super("Item not vended. Insufficient funds.");
    }
}
