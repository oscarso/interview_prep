import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {
	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();
		
		ThreadId threadId = new Main.ThreadId();
		threadId.setId(1);
		                      //actualThreadId, nextThreadId, ThreadId
		Thread t1 = setThread(lock, condition, 1, 2, threadId);
		Thread t2 = setThread(lock, condition, 2, 3, threadId);
		Thread t3 = setThread(lock, condition, 3, 1, threadId);
		t1.start();
		t2.start();
		t3.start();
		
	}
	private static class ThreadId {
		private int id;
		public ThreadId(){}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	}
	
	private static Thread setThread(final Lock lock, final Condition condition, final int actualThreadId, final int nextThreadId, final ThreadId threadId) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					lock.lock();
					try {
						while (threadId.getId() != actualThreadId)
							try {
								condition.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						System.out.println("" + actualThreadId);
						threadId.setId(nextThreadId);
						//condition.signalAll();
						condition.signal();
					} finally {
						lock.unlock();
					}
				}
			}
		};
		return thread;
	}


	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}