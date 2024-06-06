package people;

public abstract class Person {
    private int coins = 10;
    
    public void decrementCoins() {
        coins--;
    }
    
    public void decrementCoins(int amount) {
        coins-= amount;
    }

    public void earnCoins(int amount) {
        coins += amount;
    }

    public void win(Boolean action) {
        if (action) {
            coins += 2;
            return;
        }
        coins += 6;
    }
    
    
    public void setLast(Boolean action) {
        
    }
    
    public int getCoins() {
        return coins;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
    public abstract  Person clone();
    public abstract Boolean getPlay();
}