package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected static final Logger logger = LogManager.getLogger();

    private int t = 0;

    private final int duration;

    final State tick(Cat cat){
        t = t + 1;

        if(t < duration) {
            logger.info("Still in {}", getClass().getSimpleName());
            return this;
        } else {
            return successor(cat);
        }
    };

    protected State(int duration){
        this.duration = duration;
    }

    abstract State successor(Cat cat);

    public int getTime(){
        return this.t;
    }

    public int getDuration(){
        return this.duration;
    }
}
