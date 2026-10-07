/**
 * Represents a player on Java FC.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Player {
    private final String playerName;
    private int stamina;
    private Position[] positions;
    private int skillRating;

    /**
     * Creates a player with the given name, stamina, positions, and skill rating.
     *
     * @param playerName  the name of this player
     * @param stamina     the stamina of this player, in [0, 100]
     * @param positions   the positions this player can play; the first is preferred
     * @param skillRating the skill rating of this player, in [40, 100]
     */
    public Player(String playerName, int stamina, Position[] positions, int skillRating) {
        this.playerName = playerName;
        this.stamina = (stamina >= 0 && stamina <= 100) ? stamina : 75;
        if (positions.length == 0) {
            this.positions = new Position[] {Position.MIDFIELDER};
        } else {
            this.positions = new Position[positions.length];
            for (int i = 0; i < positions.length; i++) {
                this.positions[i] = positions[i];
            }
        }
        this.skillRating = (skillRating >= 40 && skillRating <= 100) ? skillRating : 80;
        printSkillRating();
    }

    /**
     * Creates a player with the given name and positions, a stamina of 75, and a skill rating of 80.
     *
     * @param playerName the name of this player
     * @param positions  the positions this player can play; the first is preferred
     */
    public Player(String playerName, Position[] positions) {
        this(playerName, 75, positions, 80);
    }

    /**
     * Creates the default player: Lionel Messi, a forward with 75 stamina and a skill rating of 100.
     */
    public Player() {
        this("Lionel Messi", 75, new Position[] {Position.FORWARD}, 100);
    }

    /**
     * Prints the description of this player's skill rating.
     */
    private void printSkillRating() {
        String description;
        if (skillRating >= 90) {
            description = "Excellent";
        } else if (skillRating >= 80) {
            description = "Great";
        } else if (skillRating >= 70) {
            description = "Very Good";
        } else if (skillRating >= 60) {
            description = "Good";
        } else if (skillRating >= 50) {
            description = "Fine";
        } else {
            description = "Bad";
        }
        System.out.println("Skill rating: " + description);
    }

    /**
     * Returns whether this player can be trained.
     *
     * @return true if this player's skill rating is in [50, 89], false otherwise
     */
    public boolean isTrainable() {
        return skillRating >= 50 && skillRating <= 89;
    }

    /**
     * Returns this player's preferred position.
     *
     * @return the first position in this player's positions
     */
    public Position preferredPosition() {
        return positions[0];
    }

    /**
     * Returns whether this player can play the given position.
     *
     * @param position the position to check
     * @return true if this player can play the given position, false otherwise
     */
    public boolean canPlayAs(Position position) {
        for (Position p : positions) {
            if (p == position) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a String representation of this player.
     *
     * @return this player in the format {@code <name,stamina,preferredPosition,skillRating,isTrainable>}
     */
    @Override
    public String toString() {
        return String.format("<%s,%d,%s,%d,%b>", playerName, stamina, preferredPosition(), skillRating,
                isTrainable());
    }

    /**
     * Returns the stamina of this player.
     *
     * @return the stamina of this player
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Sets the stamina of this player, clamped to [0, 100].
     *
     * @param stamina the new stamina of this player
     */
    public void setStamina(int stamina) {
        this.stamina = clamp(stamina, 0, 100);
    }

    /**
     * Returns the skill rating of this player.
     *
     * @return the skill rating of this player
     */
    public int getSkillRating() {
        return skillRating;
    }

    /**
     * Sets the skill rating of this player, clamped to [40, 100].
     *
     * @param skillRating the new skill rating of this player
     */
    public void setSkillRating(int skillRating) {
        this.skillRating = clamp(skillRating, 40, 100);
    }

    /**
     * Restricts a value to the range [min, max].
     *
     * @param value the value to restrict
     * @param min   the minimum allowed value
     * @param max   the maximum allowed value
     * @return the value restricted to [min, max]
     */
    private int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }
}
