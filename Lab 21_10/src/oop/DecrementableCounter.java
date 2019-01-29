package oop;

public class DecrementableCounter extends Counter{

    private int cycleLength;


    public DecrementableCounter(int n) {
        cycleLength = n;

    }


    public void decrement() {
        int placeHolder = super.value();
        if(super.value() >= placeHolder) {
            super.reset();
        }
        while(super.value() < placeHolder){
            placeHolder --;
            super.increment();
            if(placeHolder == 0){
                super.reset();
            }
        }
    }
}
