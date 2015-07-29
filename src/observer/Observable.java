package observer;

import java.util.Set;

public class Observable<P> {

	protected Order<P> mOrder = new Order<>();
	
	public void addUser(P production, IObserver<P> observer) {
		mOrder.addUser(production, observer);
	}
	
	public void removeUser(P production, IObserver<P> observer) {
		mOrder.removeUser(production, observer);
	}
	
	public void setChanged(P production, Object obj) {
		Set<IObserver<P>> user = mOrder.getUser(production);
		for (IObserver<P> u : user) {
			notifyChanged(u, production, obj);
		}
	}
	
	protected void notifyChanged(IObserver<P> observer, P production, Object obj) {
		observer.onUpdate(production, obj);
	}
}
