package ohm.softa.a03;
import  ohm.softa.a03.Cat;
import ohm.softa.a03.State;
import ohm.softa.a03.HungryState;

public class SleepingState extends State{


    public SleepingState(int duration) {
        super(duration);
    }

    @Override
    State successor(Cat cat) {

        logger.info("Yoan... getting hungry!");
        return new HungryState(cat.getAwake());
    }
}
