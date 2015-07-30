package dada.observer;

import org.junit.Assert;
import org.junit.Test;

public class ObserverTest {

	private enum TestProduction {
		P1, P2, P3
	}
	
	private class Receive {
		boolean m_Receive = false;
	}
	
	@Test
	public void Test1() {
		Observable<TestProduction> ob1 = new Observable<>();
		final Receive receive = new Receive();;
		IObserver<TestProduction> observer = new IObserver<TestProduction>() {

			@Override
			public void onUpdate(TestProduction production, Object obj) {
				receive.m_Receive = true;				
			}
			
		};
		ob1.addUser(TestProduction.P1, observer);
		ob1.setChanged(TestProduction.P1, 0);
		Assert.assertTrue(receive.m_Receive);
		
		// It shouldn't receive again after remove user.
		ob1.removeUser(TestProduction.P1, observer);
		receive.m_Receive = false;
		ob1.setChanged(TestProduction.P1, 0);
		Assert.assertFalse(receive.m_Receive);
	}
	
	@Test
	public void Test2() {
		Observable<TestProduction> ob1 = new Observable<>();
		final Receive receive = new Receive();;
		ob1.addUser(TestProduction.P2, new IObserver<TestProduction>() {
			
			@Override
			public void onUpdate(TestProduction production, Object obj) {
				receive.m_Receive = true;
			}
		});
		ob1.setChanged(TestProduction.P1, 0);
		Assert.assertFalse(receive.m_Receive);
	}
	
}
