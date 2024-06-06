package people;

public class Agressive extends Copycat {
    private int agressiveRounds = -1;

    @Override
    public Boolean getPlay() {
        if (lastAction && agressiveRounds == 0) {
            return true;
        }

        if (!lastAction)
            agressiveRounds = 3;

        if (agressiveRounds > 0) {
            agressiveRounds--;
            return false;
        }

        return true;
    }

    @Override
    public Person clone() {
        return new Agressive();
    }
}
