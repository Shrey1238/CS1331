/**
 * Represents a basketball game, a type of SportsGame with a league.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class BasketballGame extends SportsGame {
    private String league;

    /**
     * Creates a BasketballGame with the given details.
     *
     * @param venue     the location of this game
     * @param startTime the start time of this game in the format "HH:MM"
     * @param startDate the start date of this game in the format "MM-DD-YYYY"
     * @param score1    the score of the first team
     * @param score2    the score of the second team
     * @param seatsLeft the number of remaining seats at this game
     * @param league    the league the teams in this game are a part of
     * @throws IllegalArgumentException if league is blank or null
     */
    public BasketballGame(String venue, String startTime, String startDate, int score1, int score2,
        int seatsLeft, String league) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (league == null || league.isBlank()) {
            throw new IllegalArgumentException("League cannot be blank or null.");
        }
        this.league = league.trim();
    }

    /**
     * Returns a comma-separated String of this game's details.
     *
     * @return a String in the format "BasketballGame,venue,startTime,startDate,score1,score2,seatsLeft,league"
     */
    @Override
    public String toString() {
        return "BasketballGame," + super.toString() + "," + league;
    }

    /**
     * Checks whether this BasketballGame equals another object. Two BasketballGame objects are equal if
     * they have the same venue, startTime, startDate, score1, score2, seatsLeft, and league.
     *
     * @param o the object to compare to
     * @return true if the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BasketballGame)) {
            return false;
        }
        return super.equals(o) && league.equals(((BasketballGame) o).league);
    }

    /**
     * Returns a hash code consistent with equals.
     *
     * @return the hash code of this BasketballGame
     */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Returns the league of this game.
     *
     * @return the league
     */
    public String getLeague() {
        return league;
    }

    /**
     * Sets the league of this game.
     *
     * @param league the new league
     */
    public void setLeague(String league) {
        this.league = league;
    }
}
