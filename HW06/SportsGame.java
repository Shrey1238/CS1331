/**
 * Represents a general sports game with a venue, start time, start date, scores, and seats left.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public abstract class SportsGame {
    private String venue;
    private String startTime;
    private String startDate;
    private int score1;
    private int score2;
    private int seatsLeft;

    /**
     * Creates a SportsGame with the given details.
     *
     * @param venue     the location of this game
     * @param startTime the start time of this game in the format "HH:MM"
     * @param startDate the start date of this game in the format "MM-DD-YYYY"
     * @param score1    the score of the first team
     * @param score2    the score of the second team
     * @param seatsLeft the number of remaining seats at this game
     * @throws IllegalArgumentException if a String is blank or null, or a number is negative
     */
    public SportsGame(String venue, String startTime, String startDate, int score1, int score2, int seatsLeft) {
        if (venue == null || venue.isBlank()) {
            throw new IllegalArgumentException("Venue cannot be blank or null.");
        }
        if (startTime == null || startTime.isBlank()) {
            throw new IllegalArgumentException("Start time cannot be blank or null.");
        }
        if (startDate == null || startDate.isBlank()) {
            throw new IllegalArgumentException("Start date cannot be blank or null.");
        }
        if (score1 < 0) {
            throw new IllegalArgumentException("Score of the first team cannot be negative.");
        }
        if (score2 < 0) {
            throw new IllegalArgumentException("Score of the second team cannot be negative.");
        }
        if (seatsLeft < 0) {
            throw new IllegalArgumentException("Seats left cannot be negative.");
        }
        this.venue = venue.trim();
        this.startTime = startTime.trim();
        this.startDate = startDate.trim();
        this.score1 = score1;
        this.score2 = score2;
        this.seatsLeft = seatsLeft;
    }

    /**
     * Returns a comma-separated String of this game's details.
     *
     * @return a String in the format "venue,startTime,startDate,score1,score2,seatsLeft"
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d,%d,%d", venue, startTime, startDate, score1, score2, seatsLeft);
    }

    /**
     * Checks whether this SportsGame equals another object. Two SportsGame objects are equal if they have
     * the same venue, startTime, startDate, score1, score2, and seatsLeft.
     *
     * @param o the object to compare to
     * @return true if the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SportsGame)) {
            return false;
        }
        SportsGame other = (SportsGame) o;
        return venue.equals(other.venue) && startTime.equals(other.startTime)
            && startDate.equals(other.startDate) && score1 == other.score1
            && score2 == other.score2 && seatsLeft == other.seatsLeft;
    }

    /**
     * Returns a hash code consistent with equals.
     *
     * @return the hash code of this SportsGame
     */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Returns the venue of this game.
     *
     * @return the venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     * Sets the venue of this game.
     *
     * @param venue the new venue
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * Returns the start time of this game.
     *
     * @return the start time
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of this game.
     *
     * @param startTime the new start time
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Returns the start date of this game.
     *
     * @return the start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of this game.
     *
     * @param startDate the new start date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns the score of the first team.
     *
     * @return the first team's score
     */
    public int getScore1() {
        return score1;
    }

    /**
     * Sets the score of the first team.
     *
     * @param score1 the new first team's score
     */
    public void setScore1(int score1) {
        this.score1 = score1;
    }

    /**
     * Returns the score of the second team.
     *
     * @return the second team's score
     */
    public int getScore2() {
        return score2;
    }

    /**
     * Sets the score of the second team.
     *
     * @param score2 the new second team's score
     */
    public void setScore2(int score2) {
        this.score2 = score2;
    }

    /**
     * Returns the number of remaining seats at this game.
     *
     * @return the seats left
     */
    public int getSeatsLeft() {
        return seatsLeft;
    }

    /**
     * Sets the number of remaining seats at this game.
     *
     * @param seatsLeft the new number of seats left
     */
    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }
}
