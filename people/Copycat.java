package people;

public class Copycat extends Person {
    protected Boolean lastAction = true;

    @Override
    public Boolean getPlay() {
        return lastAction;
    }
    
    @Override
    public void setLast(Boolean action) {
        lastAction = action;
    }

    @Override
    public Person clone() {
        return new Copycat();
    }
}
