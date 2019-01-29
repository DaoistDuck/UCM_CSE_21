package pig;

public class OkayPlayer extends Player {
    boolean bool = true;
    @Override
    public boolean throwAgain(Player opponent) {
        if(super.total() > 50){
           bool = true;
        }
        else{
            bool = false;
        }
        return bool;
    }
}
