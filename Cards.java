
public class Cards {
    private String value;
    private boolean guess = false;

    //Our constructor.
    public Cards(String value) {
        this.value = value;
    }
    
    //Our getter and setter methodes.
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isGuess() {
        return guess;
    }

    public void setGuess(boolean guess) {
        this.guess = guess;
    }
}
