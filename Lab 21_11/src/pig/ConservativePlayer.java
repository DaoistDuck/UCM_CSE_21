package pig;

public class ConservativePlayer extends Player {

    @Override
    public boolean throwAgain(Player opponent) {
        return false;
    }
}
