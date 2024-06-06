package people;

public class Resentful extends Copycat {

    @Override
    public Boolean getPlay() {
        return lastAction;
    }

    @Override
    public void setLast(Boolean action) {
        if (lastAction && !action)
            lastAction = false;
    }

    @Override
    public Person clone() {
        return new Resentful();
    }
}
