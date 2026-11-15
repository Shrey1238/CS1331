import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides static methods for reading and writing a CSV database of sports game tickets.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Ticket {

    /**
     * Reads every sports game stored in the given CSV file.
     *
     * @param pathName the path of the file to read from
     * @return an ArrayList of the SportsGame objects in the file, in order
     * @throws FileNotFoundException  if pathName is blank or null, or is not the path to a file
     * @throws InvalidTicketException if a line has a game type other than BasketballGame or FootballGame
     */
    public static ArrayList<SportsGame> retrieveGames(String pathName)
        throws FileNotFoundException, InvalidTicketException {
        if (pathName == null || pathName.isBlank()) {
            throw new FileNotFoundException("Path name cannot be blank or null.");
        }
        File file = new File(pathName);
        if (!file.isFile()) {
            throw new FileNotFoundException("No file found at path: " + pathName);
        }
        ArrayList<SportsGame> games = new ArrayList<>();
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            games.add(processInfo(scan.nextLine()));
        }
        scan.close();
        return games;
    }

    /**
     * Converts one line of the CSV file into a BasketballGame or FootballGame.
     *
     * @param line the line of info to process, in the format
     *             "GameType,venue,startTime,startDate,score1,score2,seatsLeft,league/performer"
     * @return the SportsGame described by the line
     * @throws InvalidTicketException if the game type is not BasketballGame or FootballGame
     */
    private static SportsGame processInfo(String line) throws InvalidTicketException {
        String[] tokens = line.split(",");
        String gameType = tokens[0].trim();
        String venue = tokens[1];
        String startTime = tokens[2];
        String startDate = tokens[3];
        int score1 = Integer.parseInt(tokens[4].trim());
        int score2 = Integer.parseInt(tokens[5].trim());
        int seatsLeft = Integer.parseInt(tokens[6].trim());
        String extra = tokens[7];
        if (gameType.equals("BasketballGame")) {
            return new BasketballGame(venue, startTime, startDate, score1, score2, seatsLeft, extra);
        } else if (gameType.equals("FootballGame")) {
            return new FootballGame(venue, startTime, startDate, score1, score2, seatsLeft, extra);
        }
        throw new InvalidTicketException("Invalid game type: " + gameType);
    }

    /**
     * Writes the given games to the end of the given CSV file, creating the file if it does not exist.
     * Games with no remaining seats, including ones already in the file, are not written.
     *
     * @param pathName the path of the file to write to
     * @param games    the SportsGame objects to add to the file
     * @throws IllegalArgumentException if pathName is blank or null
     * @throws FileNotFoundException    if the file cannot be opened for writing
     * @throws InvalidTicketException   if the existing file has a line with an invalid game type
     */
    public static void purchaseTickets(String pathName, ArrayList<SportsGame> games)
        throws FileNotFoundException, InvalidTicketException {
        if (pathName == null || pathName.isBlank()) {
            throw new IllegalArgumentException("Path name cannot be blank or null.");
        }
        File file = new File(pathName);
        ArrayList<SportsGame> allGames = new ArrayList<>();
        if (file.isFile()) {
            allGames = retrieveGames(pathName);
        }
        allGames.addAll(games);
        ArrayList<SportsGame> available = new ArrayList<>();
        for (SportsGame game : allGames) {
            if (game.getSeatsLeft() > 0) {
                available.add(game);
            }
        }
        writeGames(file, available);
    }

    /**
     * Finds the line numbers of every occurrence of the given game in the given CSV file.
     *
     * @param pathName the path of the file to read from
     * @param game     the SportsGame to look for
     * @return an ArrayList of the zero-based line numbers where the game is found
     * @throws FileNotFoundException  if pathName is blank or null, or is not the path to a file
     * @throws InvalidTicketException if the game is not found in the file
     */
    public static ArrayList<Integer> findTickets(String pathName, SportsGame game)
        throws FileNotFoundException, InvalidTicketException {
        ArrayList<SportsGame> games = retrieveGames(pathName);
        ArrayList<Integer> lines = new ArrayList<>();
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).equals(game)) {
                lines.add(i);
            }
        }
        if (lines.isEmpty()) {
            throw new InvalidTicketException("Ticket not found in file: " + game);
        }
        return lines;
    }

    /**
     * Removes every occurrence of the given game from the given CSV file, keeping the lines contiguous.
     *
     * @param pathName the path of the file to write to
     * @param game     the SportsGame to remove
     * @throws FileNotFoundException  if pathName is blank or null, or is not the path to a file
     * @throws InvalidTicketException if the game is not found in the file
     */
    public static void attendGame(String pathName, SportsGame game)
        throws FileNotFoundException, InvalidTicketException {
        ArrayList<Integer> lines = findTickets(pathName, game);
        ArrayList<SportsGame> games = retrieveGames(pathName);
        for (int i = lines.size() - 1; i >= 0; i--) {
            games.remove((int) lines.get(i));
        }
        writeGames(new File(pathName), games);
    }

    /**
     * Writes each game to its own line of the given file, replacing any existing contents.
     *
     * @param file  the file to write to
     * @param games the SportsGame objects to write
     * @throws FileNotFoundException if the file cannot be opened for writing
     */
    private static void writeGames(File file, ArrayList<SportsGame> games) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        for (SportsGame game : games) {
            writer.println(game);
        }
        writer.close();
    }
}
