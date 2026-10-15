/**
 * Represents a talking fish with a name, a length, and a weight.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Fish {
    private static int totalFish = 0;

    protected final String name;
    protected Double length;
    protected Double weight;

    /**
     * Creates a fish with the given name, length, and weight.
     *
     * @param name   the name of this fish; defaults to "Nemo" if null, empty, or blank
     * @param length the end-to-end length of this fish in inches; defaults to 8.0 if invalid
     * @param weight the weight of this fish in ounces; defaults to 2.0 if invalid
     */
    public Fish(String name, Double length, Double weight) {
        this.name = (name == null || name.trim().isEmpty()) ? "Nemo" : name;
        this.length = isValidMeasurement(length) ? length : 8.0;
        this.weight = isValidMeasurement(weight) ? weight : 2.0;
        totalFish++;
    }

    /**
     * Creates the default fish: Nemo, 5.0 inches long and weighing 12.0 ounces.
     */
    public Fish() {
        this("Nemo", 5.0, 12.0);
    }

    /**
     * Creates a deep copy of the given fish.
     *
     * @param other the fish to copy
     */
    public Fish(Fish other) {
        this(other.name, other.length, other.weight);
    }

    /**
     * Checks whether a measurement is a finite, positive, non-null number.
     *
     * @param value the measurement to check
     * @return true if the measurement is valid, false otherwise
     */
    protected boolean isValidMeasurement(Double value) {
        return value != null && !value.isNaN() && !value.isInfinite() && value > 0;
    }

    /**
     * Formats the length of this fish in feet and inches.
     *
     * @return the length of this fish as "&lt;feet&gt; ft &lt;inches&gt; in"
     */
    public String formatLength() {
        int feet = (int) (length / 12);
        double inches = length % 12;
        return String.format("%d ft %.2f in", feet, inches);
    }

    /**
     * Formats the weight of this fish in pounds and ounces.
     *
     * @return the weight of this fish as "&lt;pounds&gt; lb/lbs &lt;ounces&gt; oz"
     */
    public String formatWeight() {
        int pounds = (int) (weight / 16);
        double ounces = weight % 16;
        String unit = (pounds == 1) ? "lb" : "lbs";
        return String.format("%d %s %.2f oz", pounds, unit, ounces);
    }

    /**
     * Returns a description of this fish.
     *
     * @return a String describing this fish's name, length, and weight
     */
    @Override
    public String toString() {
        return String.format("I'm a talking fish named %s. My length is %s and my weight is %s.",
                name, formatLength(), formatWeight());
    }
}
