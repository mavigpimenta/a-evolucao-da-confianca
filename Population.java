import people.*;
import java.util.LinkedList;
import java.util.Random;

public class Population {
    LinkedList<Person> population;

    public void generatePopulation(int count) {
        Random rd = new Random();

        for (int i = 0; i < count; i++) {
            switch (rd.nextInt(5)) {
                case 0:
                    population.add(new Agressive());
                    break;
                case 1:
                    population.add(new Kind());
                    break;
                case 2:
                    population.add(new Cheater());
                    break;
                case 3:
                    population.add(new Copycat());
                    break;
                case 4:
                    population.add(new Resentful());
                    break;
            }
        }
    }

    public int size() {
        return population.size();
    }

    public Person getPerson(int index) {
        return population.get(index);
    }

    public void removePerson(int index) {
        population.remove(index);
    }

    public void removePerson(Person person) {
        population.remove(person);
    }

    public void add(Person person) {
        population.add(person);
    }

    Population() {
        population = new LinkedList<>();
    }
}
