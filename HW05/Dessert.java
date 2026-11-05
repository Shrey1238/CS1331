/**
 * Represents an abstract dessert with a flavor and a sweetness.
 * Desserts are naturally ordered by sweetness, then by flavor.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public abstract class Dessert implements Comparable<Dessert> {
    private String flavor;
    private double sweetness;

    /**
     * Creates a Dessert with the given flavor and sweetness.
     *
     * @param flavor    the flavor of this Dessert
     * @param sweetness the sweetness of this Dessert
     */
    public Dessert(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
    }

    /**
     * Creates a vanilla Dessert with a sweetness of 25.0.
     */
    public Dessert() {
        this("vanilla", 25.0);
    }

    /**
     * Returns a String representation of this Dessert.
     *
     * @return a String describing this Dessert
     */
    @Override
    public String toString() {
        return String.format("%s dessert with a sweetness of %.2f.", flavor, sweetness);
    }

    /**
     * Compares this Dessert to another object for equality.
     * Two desserts are equal if they are the same type of dessert and have the same flavor and sweetness.
     *
     * @param o the object to compare to
     * @return true if the object is an equal Dessert
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dessert other = (Dessert) o;
        return flavor.equals(other.flavor) && sweetness == other.sweetness;
    }

    /**
     * Returns a hash code consistent with equals.
     *
     * @return the hash code of this Dessert
     */
    @Override
    public int hashCode() {
        return 31 * flavor.hashCode() + Double.hashCode(sweetness);
    }

    /**
     * Compares this Dessert to another Dessert based on sweetness first, then flavor.
     *
     * @param other the Dessert to compare to
     * @return a negative number, zero, or a positive number if this Dessert is less than,
     *         equal to, or greater than the other Dessert
     */
    @Override
    public int compareTo(Dessert other) {
        int result = Double.compare(sweetness, other.sweetness);
        if (result != 0) {
            return result;
        }
        return flavor.compareTo(other.flavor);
    }

    /**
     * Returns the flavor of this Dessert.
     *
     * @return the flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Sets the flavor of this Dessert.
     *
     * @param flavor the new flavor
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * Returns the sweetness of this Dessert.
     *
     * @return the sweetness
     */
    public double getSweetness() {
        return sweetness;
    }

    /**
     * Sets the sweetness of this Dessert.
     *
     * @param sweetness the new sweetness
     */
    public void setSweetness(double sweetness) {
        this.sweetness = sweetness;
    }
}
