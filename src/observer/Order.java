package observer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Order<P> {

	Map<P, Set<IObserver<P>>> mMap = new HashMap<>();
	private final Set<IObserver<P>> Empty = new HashSet<>();
	
	public void addUser(P production, IObserver<P> observer) {
		synchronized (mMap) {
			Set<IObserver<P>> set = mMap.get(production);
			if (set == null) {
				set = new HashSet<>();
				mMap.put(production, set);
				set.add(observer);
			}
			else {
				set.add(observer);
			}
		}
	}
	
	public void removeUser(P production, IObserver<P> observer) {
		synchronized (mMap) {
			Set<IObserver<P>> set = mMap.get(production);
			if (set == null) {
				return;
			}
			set.remove(observer);
		}
	}
	
	public Set<IObserver<P>> getUser(P production) {
		synchronized (mMap) {
			Set<IObserver<P>> ret = mMap.get(production);
			return ret == null ? Empty : new HashSet<>(ret);
		}
	}
	
}
