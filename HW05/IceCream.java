/**
 * Represents ice cream, a type of Dessert with a number of scoops and optionally a cone.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class IceCream extends Dessert {
    private int scoops;
    private boolean cone;

    /**
     * Creates an IceCream with the given flavor, sweetness, scoops, and cone.
     *
     * @param flavor    the flavor of this IceCream
     * @param sweetness the sweetness of this IceCream
     * @param scoops    the number of scoops of this IceCream
     * @param cone      whether this IceCream has a cone
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        this.scoops = scoops;
        this.cone = cone;
    }

    /**
     * Creates a vanilla IceCream with a sweetness of 45.0 and the given scoops and cone.
     *
     * @param scoops the number of scoops of this IceCream
     * @param cone   whether this IceCream has a cone
     */
    public IceCream(int scoops, boolean cone) {
        this("vanilla", 45.0, scoops, cone);
    }

    /**
     * Creates a vanilla IceCream with a sweetness of 45.0, 1 scoop, and no cone.
     */
    public IceCream() {
        this(1, false);
    }

    /**
     * Returns a String representation of this IceCream.
     *
     * @return a String describing this IceCream
     */
    @Override
    public String toString() {
        return String.format("%s ice cream with %d scoops and %s a cone.",
            getFlavor(), scoops, cone ? "has" : "does not have");
    }

    /**
     * Compares this IceCream to another object for equality.
     * Two ice creams are equal if they have the same flavor, sweetness, scoops, and cone.
     *
     * @param o the object to compare to
     * @return true if the object is an equal IceCream
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        IceCream other = (IceCream) o;
        return scoops == other.scoops && cone == other.cone;
    }

    /**
     * Returns a hash code consistent with equals.
     *
     * @return the hash code of this IceCream
     */
    @Override
    public int hashCode() {
        return 31 * (31 * super.hashCode() + scoops) + (cone ? 1 : 0);
    }
}
