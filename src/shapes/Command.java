package shapes;

public interface Command {
	
		void execute();

		void unexecute();
		
		String toString();
}
