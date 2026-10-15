/**
 * Represents a flying fish, a fish that can stay in the air for some time.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class FlyingFish extends Fish {
    private int flightTime;

    /**
     * Creates a flying fish with the given name, length, weight, and flight time.
     *
     * @param name       the name of this flying fish
     * @param length     the end-to-end length of this flying fish in inches
     * @param weight     the weight of this flying fish in ounces
     * @param flightTime the time in seconds this flying fish can stay in the air;
     *                   defaults to 30 if nonpositive
     */
    public FlyingFish(String name, Double length, Double weight, int flightTime) {
        super(name, length, weight);
        this.flightTime = (flightTime > 0) ? flightTime : 30;
    }

    /**
     * Creates the default flying fish: Gilbert, 12.0 inches long, weighing 24.0 ounces,
     * with a flight time of 36 seconds.
     */
    public FlyingFish() {
        this("Gilbert", 12.0, 24.0, 36);
    }

    /**
     * Creates a deep copy of the given flying fish.
     *
     * @param other the flying fish to copy
     */
    public FlyingFish(FlyingFish other) {
        this(other.name, other.length, other.weight, other.flightTime);
    }

    /**
     * Calculates the power of this flying fish.
     *
     * @return the product of this flying fish's weight and flight time
     */
    public double calculatePower() {
        return weight * flightTime;
    }

    /**
     * Makes this flying fish fly for a random time in (0, flightTime] seconds and prints it.
     */
    public void fly() {
        double time = flightTime - Math.random() * flightTime;
        System.out.printf("Woohoo! %s flew for %.2f seconds.%n", name, time);
    }

    /**
     * Returns a description of this flying fish.
     *
     * @return a String describing this flying fish
     */
    @Override
    public String toString() {
        return super.toString() + String.format(
                " I'm a flying fish, and my flight time record is %d, so my power is %.2f.",
                flightTime, calculatePower());
    }
}
