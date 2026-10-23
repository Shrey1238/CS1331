/**
 * Tests the Task, CellPhone, and Laptop classes.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Driver {
    /**
     * Runs tests on tasks, cell phones, and laptops.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Task email = new Task("Email", 16);
        Task video = new Task("Video", 200);
        Task game = new Task("Game", 300);
        Task tiny = new Task(null, 2);
        System.out.println(email);
        System.out.println(tiny);
        System.out.println("email equals new Email(16): " + email.equals(new Task("Email", 16)));
        System.out.println("email equals video: " + email.equals(video));

        System.out.println("\n--- CellPhones ---");
        CellPhone phone1 = new CellPhone(1001, 256);
        CellPhone phone2 = new CellPhone(1001, 256, 3);
        System.out.println(phone1);
        System.out.println("phone1 equals phone2: " + phone1.equals(phone2));
        System.out.println("add email: " + phone1.addTask(email));
        System.out.println("add video: " + phone1.addTask(video));
        System.out.println("add game (not enough CPU): " + phone1.addTask(game));
        System.out.println(phone1);
        System.out.println("process video: " + phone1.processTask(video));
        System.out.println("process video again: " + phone1.processTask(video));
        System.out.println("process null: " + phone1.processTask(null));
        System.out.println(phone1);
        phone2.addTask(tiny);
        phone2.addTask(tiny);
        phone2.addTask(tiny);
        System.out.println("add to full phone2: " + phone2.addTask(tiny));
        System.out.println(phone2);
        CellPhone phone3 = new CellPhone(1001, 256);
        phone3.addTask(new Task("Email", 16));
        System.out.println("phone1 equals phone3 (0 completed): " + phone1.equals(phone3));
        phone3.addTask(video);
        phone3.processTask(video);
        System.out.println("phone1 equals phone3 (1 completed): " + phone1.equals(phone3));

        System.out.println("\n--- Laptops ---");
        Laptop laptop1 = new Laptop(2001, 512, 6, true);
        Laptop laptop2 = new Laptop(2001, 512, 6);
        System.out.println(laptop1);
        System.out.println(laptop2);
        System.out.println("laptop1 equals laptop2: " + laptop1.equals(laptop2));
        System.out.println("buffer slots at 100: " + laptop1.bufferSlotsRequired(100));
        System.out.println("buffer slots at 128: " + laptop1.bufferSlotsRequired(128));
        System.out.println("buffer slots on length-4 laptop: " + new Laptop(1, 512, 4).bufferSlotsRequired(0));
        System.out.println("add game: " + laptop1.addTask(game));
        System.out.println("add video: " + laptop1.addTask(video));
        System.out.println(laptop1);
        System.out.println("add game (too big even with overclock): " + laptop1.addTask(game));
        Task compile = new Task("Compile", 100);
        System.out.println("add compile (overclock needed): " + laptop1.addTask(compile));
        System.out.println(laptop1);
        System.out.println("add compile again (no more overclocking): " + laptop1.addTask(compile));
        System.out.println("process game: " + laptop1.processTask(game));
        System.out.println("process compile: " + laptop1.processTask(compile));
        System.out.println(laptop1);
        System.out.println("add game to laptop2 (no overclock): " + laptop2.addTask(game));
        System.out.println("add video to laptop2 (no overclock): " + laptop2.addTask(video));
        System.out.println(laptop2);

        Laptop bufferTest = new Laptop(3001, 512, 5);
        int added = 0;
        while (bufferTest.addTask(email)) {
            added++;
        }
        System.out.println("email tasks added to length-5 laptop (1 buffer slot): " + added);
        System.out.println(bufferTest);

        Laptop laptop3 = new Laptop(2001, 512, 6, true);
        Laptop laptop4 = new Laptop(2001, 512, 10, true);
        System.out.println("laptop3 equals laptop4: " + laptop3.equals(laptop4));
        System.out.println("laptop3 equals phone with same specs: " + laptop3.equals(new CellPhone(2001, 512)));
    }
}
