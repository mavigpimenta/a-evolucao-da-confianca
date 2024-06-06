import java.util.Random;
import java.util.Scanner;
import people.*;

public class Game {
    Population population;
    private int rounds = 1;

    public Boolean gameFinished() {
        if (population.size() < 2)
            return true;
        return false;
    }

    public void run() {

        Random rd = new Random();
        int pairs = population.size() / 2;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nRound " + rounds + " started!\n");
        
        for (int i = 0; i < 10; i++) {
            int index;

            index = rd.nextInt(population.size());

            Person underdog = population.getPerson(index);
            System.out.println(underdog.toString() + " is a underdog, so he lost a coin in russian roulette :b");
            underdog.decrementCoins(1);
        }

        for (int i = 0; i < pairs; i++) {
            int index = 0, indexTwo = 0;
            sc.nextLine();

            index = rd.nextInt(population.size());
            
            while (indexTwo == index) {
                indexTwo = rd.nextInt(population.size());
            }

            Person personOne = population.getPerson(index);
            Person personTwo = population.getPerson(indexTwo);
    
            round(personOne, personTwo);
            
            if (personOne.getCoins() >= 20) {
                System.out.println("Player One became to rich, so he get a son!");
                personOne.decrementCoins(10);
                Person personOneSon = (Person)personOne.clone();
                population.add(personOneSon);
                personOneSon.earnCoins(10);
            } if (personTwo.getCoins() >= 20) {
                System.out.println("Player Two became to rich, so he get a son!");
                personTwo.decrementCoins(10);
                Person personTwoSon = (Person)personTwo.clone();
                population.add(personTwoSon);
                personTwoSon.earnCoins(10);
            }
            
            personOne.decrementCoins();
            personTwo.decrementCoins();
            System.out.println("\nThe population needs pay a one coin fee in order to survive . . .");
            
            System.out.println("\nPlayer One was " + personOne.getCoins() + " coins remaing");
            System.out.println("Player Two was " + personTwo.getCoins() + " coins remaing");
            
            if (personOne.getCoins() <= 0) {
                population.removePerson(personOne);
                System.out.println("\nOmg! " + personOne.toString() + " doens't has enought coins to pay the fee, so he DIED x.x");
            } if (personTwo.getCoins() <= 0) { 
                population.removePerson(personTwo);
                System.out.println("\nOmg! " + personTwo.toString() + " doens't has enought coins to pay the fee, so he DIED x.x");
            }
        }
        rounds++;   
    }

    public void round(Person personOne, Person personTwo) {
        
        Boolean playOne = personOne.getPlay();
        Boolean playTwo = personTwo.getPlay();

        personOne.decrementCoins();
        personTwo.decrementCoins();

        personOne.setLast(playTwo);
        personTwo.setLast(playOne);

        System.out.println("\n" + personOne.toString() + " vs " + personTwo.toString());

        if (playOne && playTwo) {
            personOne.win(playOne);
            personTwo.win(playTwo);
            System.out.println(personOne.toString() + " and " + personTwo.toString() + " wins 1 coin!");
            return;
        } 
        
        if (playOne && !playTwo) {
            personTwo.win(playTwo);
            System.out.println(personTwo.toString() + ": player two cheated on person one and wins 5 coins!");
            return;
        } else if (!playOne && playTwo) {
            personOne.win(playOne);
            System.out.println(personOne.toString() + ": player one cheated on person two and wins 5 coins!");
            return;
        } 

        System.out.println("Oh no! Both players cheated! No one wins . . .");
    }

    public Game(Population population) {
        this.population = population;
    }
}
