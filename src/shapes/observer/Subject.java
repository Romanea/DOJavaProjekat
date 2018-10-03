package shapes.observer;

public interface Subject {

	public void addObserver(Observer observer);
	public void deleteObserver(Observer observer);
	public void notifyAllObservers();
}
