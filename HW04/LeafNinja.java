/**
 * Represents a Leaf Ninja that can poison other Ninjas.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class LeafNinja extends Ninja {
    private int poisonAmount;

    /**
     * Creates a Leaf Ninja with the given name, health, attack, and poison amount.
     *
     * @param name         the name of this Leaf Ninja
     * @param health       the starting health of this Leaf Ninja
     * @param attack       the attack points of this Leaf Ninja
     * @param poisonAmount the amount of poison this Leaf Ninja has
     */
    public LeafNinja(String name, int health, int attack, int poisonAmount) {
        super(name, health, attack);
        this.poisonAmount = poisonAmount <= 0 ? 5 : poisonAmount;
    }

    /**
     * Creates a Leaf Ninja with the default name, 5 health, 9 attack, and 10 poison.
     */
    public LeafNinja() {
        this(null, 5, 9, 10);
    }

    /**
     * Inflicts a poison attack on another Ninja if this Leaf Ninja has poison.
     *
     * @param other the Ninja being poisoned
     */
    public void poisonAttack(Ninja other) {
        if (poisonAmount <= 0) {
            return;
        }
        poisonAmount--;
        if (other instanceof StoneNinja) {
            StoneNinja stone = (StoneNinja) other;
            if (stone.hasNinjaArmor()) {
                stone.breakArmor();
            }
        } else if (other instanceof MistNinja) {
            ((MistNinja) other).getConfused();
        } else if (other instanceof LeafNinja) {
            LeafNinja leaf = (LeafNinja) other;
            int result = compareTo(leaf);
            if (result > 0) {
                poisonAmount += 2;
            } else if (result < 0) {
                leaf.poisonAmount += 2;
            }
        }
    }

    /**
     * Poisons the other Ninja, then attacks it, at half attack if out of poison.
     *
     * @param other the Ninja being attacked
     */
    @Override
    public void attackNinja(Ninja other) {
        poisonAttack(other);
        if (poisonAmount > 0) {
            super.attackNinja(other);
        } else {
            other.getAttacked(getAttack() / 2);
        }
    }

    /**
     * Returns the String representation of this Leaf Ninja.
     *
     * @return the String in the form Leaf Ninja: name/attack/health/poisonAmount
     */
    @Override
    public String toString() {
        return "Leaf Ninja: " + super.toString() + "/" + poisonAmount;
    }

    /**
     * Returns the poison amount of this Leaf Ninja.
     *
     * @return the poison amount
     */
    public int getPoisonAmount() {
        return poisonAmount;
    }
}
