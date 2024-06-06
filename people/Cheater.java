package people;

public class Cheater extends Person {

    @Override
    public Boolean getPlay() {
        return false;
    }

    @Override
    public Person clone() {
        return new Cheater();
    }
}
