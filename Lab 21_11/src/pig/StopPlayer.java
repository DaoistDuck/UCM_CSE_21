package pig;

public class StopPlayer extends Player{
    boolean bool = true;

    @Override
    public boolean throwAgain(Player opponent) {
        if(super.turnTotal() < 4){
            bool = true;
        }
        else{
            bool = false;
        }
        return bool;
    }
}
