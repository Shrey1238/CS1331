/**
 * Represents a football game, a type of SportsGame with a halftime performer.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class FootballGame extends SportsGame {
    private String performer;

    /**
     * Creates a FootballGame with the given details.
     *
     * @param venue     the location of this game
     * @param startTime the start time of this game in the format "HH:MM"
     * @param startDate the start date of this game in the format "MM-DD-YYYY"
     * @param score1    the score of the first team
     * @param score2    the score of the second team
     * @param seatsLeft the number of remaining seats at this game
     * @param performer the name of the halftime performer at this game
     * @throws IllegalArgumentException if performer is blank or null
     */
    public FootballGame(String venue, String startTime, String startDate, int score1, int score2,
        int seatsLeft, String performer) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (performer == null || performer.isBlank()) {
            throw new IllegalArgumentException("Performer cannot be blank or null.");
        }
        this.performer = performer.trim();
    }

    /**
     * Returns a comma-separated String of this game's details.
     *
     * @return a String in the format "FootballGame,venue,startTime,startDate,score1,score2,seatsLeft,performer"
     */
    @Override
    public String toString() {
        return "FootballGame," + super.toString() + "," + performer;
    }

    /**
     * Checks whether this FootballGame equals another object. Two FootballGame objects are equal if
     * they have the same venue, startTime, startDate, score1, score2, seatsLeft, and performer.
     *
     * @param o the object to compare to
     * @return true if the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FootballGame)) {
            return false;
        }
        return super.equals(o) && performer.equals(((FootballGame) o).performer);
    }

    /**
     * Returns a hash code consistent with equals.
     *
     * @return the hash code of this FootballGame
     */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Returns the performer of this game.
     *
     * @return the performer
     */
    public String getPerformer() {
        return performer;
    }

    /**
     * Sets the performer of this game.
     *
     * @param performer the new performer
     */
    public void setPerformer(String performer) {
        this.performer = performer;
    }
}
