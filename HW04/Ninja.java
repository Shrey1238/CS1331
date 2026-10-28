/**
 * Represents an abstract Ninja with a name, health, and attack.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public abstract class Ninja implements Comparable<Ninja> {
    private String name;
    private int health;
    private int attack;

    /**
     * Creates a Ninja with the given name, health, and attack.
     *
     * @param name   the name of this Ninja
     * @param health the starting health of this Ninja
     * @param attack the attack points of this Ninja
     */
    public Ninja(String name, int health, int attack) {
        this.name = (name == null || name.isBlank()) ? "Naruto Uzumaki" : name;
        this.health = health <= 0 ? 1 : health;
        this.attack = attack < 2 ? 2 : attack;
    }

    /**
     * Returns whether this Ninja has fainted.
     *
     * @return true if this Ninja's health is zero or negative
     */
    public boolean hasFainted() {
        return health <= 0;
    }

    /**
     * Decreases this Ninja's health by the given damage.
     *
     * @param damage the amount of damage taken
     */
    public void getAttacked(int damage) {
        health -= damage;
    }

    /**
     * Attacks another Ninja using this Ninja's attack points.
     *
     * @param other the Ninja being attacked
     */
    public void attackNinja(Ninja other) {
        other.getAttacked(attack);
    }

    /**
     * Returns the String representation of this Ninja.
     *
     * @return the String in the form name/attack/health
     */
    @Override
    public String toString() {
        return name + "/" + attack + "/" + health;
    }

    /**
     * Compares this Ninja to another based on the sum of health and attack.
     *
     * @param other the Ninja to compare to
     * @return a negative, zero, or positive integer as this Ninja is less than, equal to, or greater than other
     */
    @Override
    public int compareTo(Ninja other) {
        if (other == null) {
            return 1;
        }
        return (health + attack) - (other.health + other.attack);
    }

    /**
     * Returns the name of this Ninja.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the health of this Ninja.
     *
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the attack of this Ninja.
     *
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }
}
