package people;

public class Kind extends Person {

    @Override
    public Boolean getPlay() {
        return true;
    }

    @Override
    public Person clone() {
        return new Kind();
    }
}
