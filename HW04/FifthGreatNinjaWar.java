/**
 * Represents the Fifth Great Ninja War where two teams of Ninjas battle.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class FifthGreatNinjaWar {
    private Ninja[] firstTeam;
    private Ninja[] secondTeam;

    /**
     * Creates a war between two teams of exactly 5 Ninjas each.
     *
     * @param firstTeam  the first team of Ninjas
     * @param secondTeam the second team of Ninjas
     */
    public FifthGreatNinjaWar(Ninja[] firstTeam, Ninja[] secondTeam) {
        if (firstTeam == null || secondTeam == null || firstTeam.length != 5 || secondTeam.length != 5) {
            this.firstTeam = new Ninja[5];
            this.secondTeam = new Ninja[5];
        } else {
            this.firstTeam = firstTeam;
            this.secondTeam = secondTeam;
        }
    }

    /**
     * Returns a String representation of one team.
     *
     * @param team the team to represent
     * @return the Ninjas of the team separated by commas
     */
    private String teamString(Ninja[] team) {
        String result = "";
        for (int i = 0; i < team.length; i++) {
            if (i > 0) {
                result += ", ";
            }
            result += team[i] == null ? "Empty" : team[i].toString();
        }
        return result;
    }

    /**
     * Returns the String representation of this war.
     *
     * @return the String showing both teams
     */
    @Override
    public String toString() {
        return "First Team: " + teamString(firstTeam) + " vs Second Team: " + teamString(secondTeam);
    }

    /**
     * Compares Ninjas at matching indices and prints which team will probably win.
     */
    public void compareTeams() {
        int firstWins = 0;
        int secondWins = 0;
        for (int i = 0; i < firstTeam.length; i++) {
            Ninja a = firstTeam[i];
            Ninja b = secondTeam[i];
            int result;
            if (a == null && b == null) {
                result = 0;
            } else if (a == null) {
                result = -1;
            } else {
                result = a.compareTo(b);
            }
            if (result > 0) {
                firstWins++;
            } else if (result < 0) {
                secondWins++;
            }
        }
        if (firstWins > secondWins) {
            System.out.println("The first team will probably win.");
        } else if (secondWins > firstWins) {
            System.out.println("The second team will probably win.");
        } else {
            System.out.println("It is an even match.");
        }
    }

    /**
     * Returns the index of the next Ninja on a team that has not fainted, starting at the given index.
     *
     * @param team  the team to search
     * @param start the index to start searching from
     * @return the index of the next standing Ninja, or the team length if none remain
     */
    private int nextNinja(Ninja[] team, int start) {
        int i = start;
        while (i < team.length && (team[i] == null || team[i].hasFainted())) {
            team[i] = null;
            i++;
        }
        return i;
    }

    /**
     * Battles the two teams until at least one team has completely fainted, then prints the result.
     */
    public void battle() {
        int i = nextNinja(firstTeam, 0);
        int j = nextNinja(secondTeam, 0);
        while (i < firstTeam.length && j < secondTeam.length) {
            Ninja a = firstTeam[i];
            Ninja b = secondTeam[j];
            a.attackNinja(b);
            b.attackNinja(a);
            if (a.hasFainted()) {
                i = nextNinja(firstTeam, i);
            }
            if (b.hasFainted()) {
                j = nextNinja(secondTeam, j);
            }
        }
        boolean firstAlive = i < firstTeam.length;
        boolean secondAlive = j < secondTeam.length;
        if (firstAlive) {
            System.out.println("The first team won!");
        } else if (secondAlive) {
            System.out.println("The second team won!");
        } else {
            System.out.println("Both teams fainted.");
        }
    }

    /**
     * Tests the Fifth Great Ninja War simulator.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Ninja[] first = {new StoneNinja(), null, new MistNinja("Zabuza", 12, 9, 7),
            new LeafNinja("Kakashi", 10, 6, 1), null};
        Ninja[] second = {new LeafNinja(), new MistNinja(), null,
            new StoneNinja("Gaara", 15, 7, true), new LeafNinja("Sakura", 6, 5, 3)};
        FifthGreatNinjaWar war = new FifthGreatNinjaWar(first, second);
        System.out.println(war);
        war.compareTeams();
        war.battle();
        System.out.println(war);

        FifthGreatNinjaWar empty = new FifthGreatNinjaWar(new Ninja[3], second);
        System.out.println(empty);
        empty.compareTeams();
        empty.battle();
    }
}
