/**
 * A checked exception thrown when an invalid ticket is encountered.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class InvalidTicketException extends Exception {

    /**
     * Creates an InvalidTicketException with the given message.
     *
     * @param message the message describing this exception
     */
    public InvalidTicketException(String message) {
        super(message);
    }

    /**
     * Creates an InvalidTicketException with the default message "Invalid ticket".
     */
    public InvalidTicketException() {
        this("Invalid ticket");
    }
}
