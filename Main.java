import java.util.*;

public class Main {
    public static void main(String[] args) {
        Population p = new Population();
        p.generatePopulation(50);

        Game g = new Game(p);

        while (p.size() > 0 || p.size() % 2 == 0) {
            g.run();

        }
    }
}
