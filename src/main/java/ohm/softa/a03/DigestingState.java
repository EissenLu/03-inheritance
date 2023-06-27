package ohm.softa.a03;

public class DigestingState extends State{
    private final int remainingWakeTime;
    public DigestingState(int duration, int remainingWakeTime){
        super(duration);
        this.remainingWakeTime =remainingWakeTime;
    }
    @Override
    State successor(Cat cat) {
        return new PlayfulState(remainingWakeTime - cat.getDigest());
    }
}
