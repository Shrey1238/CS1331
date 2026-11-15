import java.util.ArrayList;

/**
 * Tests the Ticket database methods with BasketballGame and FootballGame objects.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Driver {

    /**
     * Writes, reads, and removes sports games from TestTickets.csv.
     *
     * @param args command line arguments, unused
     * @throws Exception if a file cannot be found or a ticket is invalid
     */
    public static void main(String[] args) throws Exception {
        String path = "TestTickets.csv";

        BasketballGame b1 = new BasketballGame("McCamish Pavilion", "19:30", "11-07-2022", 93, 63, 6192,
            "Atlantic Coast Conference");
        BasketballGame b2 = new BasketballGame("State Farm Arena", "20:00", "12-01-2022", 110, 104, 0, "NBA");
        FootballGame f1 = new FootballGame("Bobby Dodd Stadium", "16:00", "10-08-2022", 23, 20, 17267, "Buzz");
        FootballGame f2 = new FootballGame("Mercedes-Benz Stadium", "13:00", "11-20-2022", 27, 24, 350, "Usher");

        ArrayList<SportsGame> games = new ArrayList<>();
        games.add(b1);
        games.add(b2);
        games.add(f1);
        games.add(f2);
        Ticket.purchaseTickets(path, games);

        ArrayList<SportsGame> more = new ArrayList<>();
        more.add(new BasketballGame("McCamish Pavilion", "19:30", "11-07-2022", 93, 63, 6192,
            "Atlantic Coast Conference"));
        Ticket.purchaseTickets(path, more);

        System.out.println("Games in file:");
        for (SportsGame game : Ticket.retrieveGames(path)) {
            System.out.println(game);
        }

        System.out.println("b1 found on lines: " + Ticket.findTickets(path, b1));

        Ticket.attendGame(path, b1);
        System.out.println("After attending b1:");
        for (SportsGame game : Ticket.retrieveGames(path)) {
            System.out.println(game);
        }

        try {
            Ticket.findTickets(path, b1);
        } catch (InvalidTicketException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
