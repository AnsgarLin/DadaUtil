package observer;

public interface IObserver<P> {

	public void onUpdate(P production, Object obj);
}
