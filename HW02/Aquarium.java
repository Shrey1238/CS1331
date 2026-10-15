/**
 * Test driver for Fish and its subclasses.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Aquarium {
    /**
     * Creates fish of every kind with every constructor and exercises their methods.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Fish fish1 = new Fish("Dory", 25.015, 16.015);
        Fish fish2 = new Fish();
        Fish fish3 = new Fish(fish1);
        Fish fish4 = new Fish("   ", Double.NaN, -3.0);
        Fish fish5 = new Fish(null, Double.POSITIVE_INFINITY, null);
        System.out.println(fish1.formatLength());
        System.out.println(fish1.formatWeight());
        System.out.println(fish1);
        System.out.println(fish2);
        System.out.println(fish3);
        System.out.println(fish4);
        System.out.println(fish5);
        System.out.println();

        Catfish cat1 = new Catfish("Whiskers", 10.0, 40.0, 12.5);
        Catfish cat2 = new Catfish();
        Catfish cat3 = new Catfish(cat1);
        System.out.println(cat1.isShaggy());
        System.out.println(cat2.isShaggy());
        cat3.setWhiskerLength(-1.0);
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println();

        StripedBass bass1 = new StripedBass("Stripes", 20.0, 100.0, 10, true, cat1);
        StripedBass bass2 = new StripedBass();
        StripedBass bass3 = new StripedBass(bass1);
        StripedBass bass4 = new StripedBass("Loner", 18.0, 64.0, 0, false, null);
        cat1.setWhiskerLength(1.0);
        bass1.migrate();
        bass2.migrate();
        System.out.println(bass1);
        System.out.println(bass2);
        System.out.println(bass3);
        System.out.println(bass4);
        System.out.println();

        FlyingFish fly1 = new FlyingFish("Skipper", 9.0, 8.0, 45);
        FlyingFish fly2 = new FlyingFish();
        FlyingFish fly3 = new FlyingFish(fly1);
        FlyingFish fly4 = new FlyingFish("Grounded", 6.0, 4.0, -5);
        System.out.println(fly1.calculatePower());
        fly1.fly();
        fly2.fly();
        fly3.fly();
        fly4.fly();
        System.out.println(fly1);
        System.out.println(fly2);
        System.out.println(fly3);
        System.out.println(fly4);
    }
}
