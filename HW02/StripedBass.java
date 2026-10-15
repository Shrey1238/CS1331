/**
 * Represents a striped bass, a fish that may be best friends with a catfish.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class StripedBass extends Fish {
    private int stripeCount;
    private boolean isSaltwater;
    private Catfish bestFriend;

    /**
     * Creates a striped bass with the given attributes.
     *
     * @param name        the name of this striped bass
     * @param length      the end-to-end length of this striped bass in inches
     * @param weight      the weight of this striped bass in ounces
     * @param stripeCount the number of stripes on this striped bass; defaults to 25 if nonpositive
     * @param isSaltwater whether this striped bass lives in saltwater
     * @param bestFriend  the catfish best friend of this striped bass, or null; deep copied
     */
    public StripedBass(String name, Double length, Double weight, int stripeCount,
                       boolean isSaltwater, Catfish bestFriend) {
        super(name, length, weight);
        this.stripeCount = (stripeCount > 0) ? stripeCount : 25;
        this.isSaltwater = isSaltwater;
        this.bestFriend = (bestFriend == null) ? null : new Catfish(bestFriend);
    }

    /**
     * Creates the default striped bass: Striper, 30.0 inches long, weighing 320.0 ounces,
     * with 14 stripes, living in freshwater, and with no best friend.
     */
    public StripedBass() {
        this("Striper", 30.0, 320.0, 14, false, null);
    }

    /**
     * Creates a deep copy of the given striped bass.
     *
     * @param other the striped bass to copy
     */
    public StripedBass(StripedBass other) {
        this(other.name, other.length, other.weight, other.stripeCount, other.isSaltwater,
                other.bestFriend);
    }

    /**
     * Moves this striped bass to the opposite kind of water body if it has no best friend.
     */
    public void migrate() {
        if (bestFriend == null) {
            isSaltwater = !isSaltwater;
        }
    }

    /**
     * Returns a description of this striped bass.
     *
     * @return a String describing this striped bass
     */
    @Override
    public String toString() {
        String friend = (bestFriend == null) ? "no best friend"
                : "a best friend named " + bestFriend.name;
        return super.toString() + String.format(" I'm a %s striped bass with %d stripes. I have %s.",
                isSaltwater ? "saltwater" : "freshwater", stripeCount, friend);
    }
}
