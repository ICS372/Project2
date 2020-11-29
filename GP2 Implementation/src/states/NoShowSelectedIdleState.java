package states;

public class NoShowSelectedIdleState extends PlayerState {
	private static NoShowSelectedIdleState instance;

	private NoShowSelectedIdleState() {

	}

	public static NoShowSelectedIdleState instance() {
		if (instance == null) {
			instance = new NoShowSelectedIdleState();
		}
		return instance;
	}
}
