import java.util.Random;

/**
 * Represents the roster of players on Java FC.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Roster {
    private Player[] players;
    private int size;

    /**
     * Creates a roster from the given players. Null elements represent empty slots.
     *
     * @param players the players on the roster
     */
    public Roster(Player[] players) {
        this.players = new Player[players.length];
        for (int i = 0; i < players.length; i++) {
            this.players[i] = players[i];
            if (players[i] != null) {
                size++;
            }
        }
    }

    /**
     * Creates an empty roster with 4 slots.
     */
    public Roster() {
        this(new Player[4]);
    }

    /**
     * Returns whether the given index is a slot on this roster.
     *
     * @param index the index to check
     * @return true if the index is within the bounds of the players array
     */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < players.length;
    }

    /**
     * Returns whether there is a player in the given slot.
     *
     * @param index the index to check
     * @return true if the index is valid and the slot is occupied
     */
    private boolean hasPlayerAt(int index) {
        return isValidIndex(index) && players[index] != null;
    }

    /**
     * Signs a player into the given slot on the roster.
     *
     * @param index  the slot to sign the player into
     * @param player the player to sign
     * @return the player previously in that slot, or null if the slot was empty or the signing failed
     */
    public Player signPlayer(int index, Player player) {
        if (!isValidIndex(index) || player == null) {
            System.out.println("Cannot add a player to this spot on the roster.");
            return null;
        }
        Player oldPlayer = players[index];
        players[index] = player;
        if (oldPlayer != null) {
            System.out.println("Replaced: " + oldPlayer);
        } else {
            System.out.println("Signed: " + player);
            size++;
        }
        return oldPlayer;
    }

    /**
     * Transfers the player in the given slot off the roster.
     *
     * @param index the slot of the player to transfer
     * @return the transferred player, or null if there was no player to transfer
     */
    public Player transferPlayer(int index) {
        if (!hasPlayerAt(index)) {
            System.out.println("There was no player to transfer!");
            return null;
        }
        Player player = players[index];
        players[index] = null;
        size--;
        System.out.println("Transferred: " + player);
        return player;
    }

    /**
     * Prints every player with a skill rating greater than the given value.
     *
     * @param skillRating the skill rating players must exceed to be shown
     */
    public void showBestPlayers(int skillRating) {
        for (Player player : players) {
            if (player != null && player.getSkillRating() > skillRating) {
                System.out.println(player);
            }
        }
    }

    /**
     * Trains every trainable player by a random amount in [1, 10].
     */
    public void trainAllPlayers() {
        Random random = new Random();
        boolean trainedAny = false;
        for (Player player : players) {
            if (player != null && player.isTrainable()) {
                String oldPlayer = player.toString();
                player.setSkillRating(player.getSkillRating() + random.nextInt(10) + 1);
                System.out.println("Trained to " + player.getSkillRating() + ": " + oldPlayer);
                trainedAny = true;
            }
        }
        if (!trainedAny) {
            System.out.println("There were no players to train.");
        }
    }

    /**
     * Plays the player in the given slot in a league match at the given position.
     *
     * @param index    the slot of the player to play
     * @param position the position to play the player in
     */
    public void play(int index, Position position) {
        if (!hasPlayerAt(index)) {
            System.out.println("Cannot play the player in this spot.");
            return;
        }
        Player player = players[index];
        Random random = new Random();
        if (player.preferredPosition() == position) {
            player.setStamina(player.getStamina() - (random.nextInt(5) + 1));
        } else if (player.canPlayAs(position)) {
            player.setStamina(player.getStamina() - (random.nextInt(6) + 5));
        } else {
            System.out.println("This player cannot be played in position " + position + ".");
            return;
        }
        System.out.println("Played: " + player);
    }

    /**
     * Returns a String representation of this roster.
     *
     * @return the roster's size followed by each player on its own line, or a message if it is empty
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "The team has no players!";
        }
        String result = String.format("There are %d players on Java FC.", size);
        for (Player player : players) {
            if (player != null) {
                result += "\n" + player;
            }
        }
        return result;
    }
}
