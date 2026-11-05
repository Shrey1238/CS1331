/**
 * Represents a cake, a type of Dessert with a frosting.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Cake extends Dessert {
    private String frosting;

    /**
     * Creates a Cake with the given flavor, sweetness, and frosting.
     *
     * @param flavor    the flavor of this Cake
     * @param sweetness the sweetness of this Cake
     * @param frosting  the type of frosting on this Cake
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        this.frosting = frosting;
    }

    /**
     * Creates a Cake with the given flavor, a sweetness of 45.0, and vanilla frosting.
     *
     * @param flavor the flavor of this Cake
     */
    public Cake(String flavor) {
        this(flavor, 45.0, "vanilla");
    }

    /**
     * Returns a String representation of this Cake.
     *
     * @return a String describing this Cake
     */
    @Override
    public String toString() {
        return String.format("%s cake with a %s frosting and has a sweetness of %.2f.",
            getFlavor(), frosting, getSweetness());
    }

    /**
     * Compares this Cake to another object for equality.
     * Two cakes are equal if they have the same flavor, sweetness, and frosting.
     *
     * @param o the object to compare to
     * @return true if the object is an equal Cake
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Cake other = (Cake) o;
        return frosting.equals(other.frosting);
    }

    /**
     * Returns a hash code consistent with equals.
     *
     * @return the hash code of this Cake
     */
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + frosting.hashCode();
    }
}
