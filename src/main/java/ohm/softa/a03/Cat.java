package ohm.softa.a03;
import ohm.softa.a03.SleepingState;
import ohm.softa.a03.DeathState;
import ohm.softa.a03.DigestingState;
import ohm.softa.a03.HungryState;
import ohm.softa.a03.PlayfulState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Cat{

	private State state;

	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;

		this.state = new SleepingState(sleep);
	}

	public void tick(){
		this.state = state.tick(this);
	}

	public void feed(){
		if(!isHungry()){
			throw new IllegalStateException("Error");

		}else{
			this.state = ((HungryState) state).feed(this);
		}


	}

	public State getState(){
		return this.state;
	}
	public boolean isAsleep() {
		return state instanceof SleepingState;
	}

	public boolean isPlayful() {
		return state instanceof PlayfulState;
	}

	public boolean isHungry() {
		return state instanceof HungryState;
	}

	public boolean isDigesting() {
		return state instanceof DigestingState;
	}

	public boolean isDead() {
		return state instanceof DeathState;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getSleep() {
		return sleep;
	}

	public int getAwake() {
		return awake;
	}

	public int getDigest() {
		return digest;
	}

	public String getName() {
		return name;
	}
}

