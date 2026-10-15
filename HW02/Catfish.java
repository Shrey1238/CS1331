/**
 * Represents a catfish, a fish with whiskers.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Catfish extends Fish {
    private Double whiskerLength;

    /**
     * Creates a catfish with the given name, length, weight, and whisker length.
     *
     * @param name          the name of this catfish
     * @param length        the end-to-end length of this catfish in inches
     * @param weight        the weight of this catfish in ounces
     * @param whiskerLength the length of this catfish's longest whisker in inches
     */
    public Catfish(String name, Double length, Double weight, Double whiskerLength) {
        super(name, length, weight);
        setWhiskerLength(whiskerLength);
    }

    /**
     * Creates the default catfish: Bubba, 52.0 inches long, weighing 720.0 ounces,
     * with a 5.0 inch whisker.
     */
    public Catfish() {
        this("Bubba", 52.0, 720.0, 5.0);
    }

    /**
     * Creates a deep copy of the given catfish.
     *
     * @param other the catfish to copy
     */
    public Catfish(Catfish other) {
        this(other.name, other.length, other.weight, other.whiskerLength);
    }

    /**
     * Determines whether this catfish is shaggy.
     *
     * @return true if this catfish's longest whisker is longer than its length
     */
    public boolean isShaggy() {
        return whiskerLength > length;
    }

    /**
     * Sets the length of this catfish's longest whisker.
     *
     * @param whiskerLength the new whisker length in inches; defaults to 8.0 if invalid
     */
    public void setWhiskerLength(Double whiskerLength) {
        this.whiskerLength = isValidMeasurement(whiskerLength) ? whiskerLength : 8.0;
    }

    /**
     * Returns a description of this catfish.
     *
     * @return a String describing this catfish
     */
    @Override
    public String toString() {
        return super.toString() + String.format(
                " I'm a catfish whose longest whisker is %.2f, so I %s shaggy.",
                whiskerLength, isShaggy() ? "am" : "am not");
    }
}
