package ohm.softa.a03;

public class DeathState extends State{

    public DeathState(){
        super(0);
    }

    @Override
    State successor(Cat cat) {
        return null;
    }
}
