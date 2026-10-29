/**
 * Represents a Stone Ninja whose armor blocks up to 20 damage from the first attack.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class StoneNinja extends Ninja {
    private boolean ninjaArmor;

    /**
     * Creates a Stone Ninja with the given name, health, attack, and armor.
     *
     * @param name       the name of this Stone Ninja
     * @param health     the starting health of this Stone Ninja
     * @param attack     the attack points of this Stone Ninja
     * @param ninjaArmor whether this Stone Ninja has ninja armor
     */
    public StoneNinja(String name, int health, int attack, boolean ninjaArmor) {
        super(name, health, attack);
        this.ninjaArmor = ninjaArmor;
    }

    /**
     * Creates a Stone Ninja with the default name, 8 health, 10 attack, and ninja armor.
     */
    public StoneNinja() {
        this(null, 8, 10, true);
    }

    /**
     * Breaks this Stone Ninja's armor.
     */
    public void breakArmor() {
        ninjaArmor = false;
    }

    /**
     * Takes damage, with armor blocking up to 20 damage from the first attack.
     *
     * @param damage the amount of incoming damage
     */
    @Override
    public void getAttacked(int damage) {
        if (ninjaArmor) {
            damage = damage <= 20 ? 0 : damage - 20;
            ninjaArmor = false;
        }
        super.getAttacked(damage);
    }

    /**
     * Returns the String representation of this Stone Ninja.
     *
     * @return the String in the form Stone Ninja: name/attack/health/ninjaArmor
     */
    @Override
    public String toString() {
        return "Stone Ninja: " + super.toString() + "/" + ninjaArmor;
    }

    /**
     * Returns whether this Stone Ninja has ninja armor.
     *
     * @return true if this Stone Ninja has ninja armor
     */
    public boolean hasNinjaArmor() {
        return ninjaArmor;
    }
}
