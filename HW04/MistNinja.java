/**
 * Represents a stealthy Mist Ninja that may dodge attacks.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class MistNinja extends Ninja {
    private int hitChance;

    /**
     * Creates a Mist Ninja with the given name, health, attack, and hit chance.
     *
     * @param name      the name of this Mist Ninja
     * @param health    the starting health of this Mist Ninja
     * @param attack    the attack points of this Mist Ninja
     * @param hitChance the hit chance of this Mist Ninja (5 to 15)
     */
    public MistNinja(String name, int health, int attack, int hitChance) {
        super(name, health, attack);
        this.hitChance = (hitChance < 5 || hitChance > 15) ? 12 : hitChance;
    }

    /**
     * Creates a Mist Ninja with the default name and hit chance, 7 health, and 8 attack.
     */
    public MistNinja() {
        this(null, 7, 8, 12);
    }

    /**
     * Increments hit chance by 1 if it stays within its valid range.
     */
    public void getConfused() {
        if (hitChance + 1 <= 15) {
            hitChance++;
        }
    }

    /**
     * Takes damage unless the damage is a multiple of hit chance, in which case the attack is dodged.
     *
     * @param damage the amount of incoming damage
     */
    @Override
    public void getAttacked(int damage) {
        if (damage % hitChance != 0) {
            super.getAttacked(damage);
        }
    }

    /**
     * Returns the String representation of this Mist Ninja.
     *
     * @return the String in the form Mist Ninja: name/attack/health/hitChance
     */
    @Override
    public String toString() {
        return "Mist Ninja: " + super.toString() + "/" + hitChance;
    }

    /**
     * Returns the hit chance of this Mist Ninja.
     *
     * @return the hit chance
     */
    public int getHitChance() {
        return hitChance;
    }
}
