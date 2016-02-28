class T1 implements Runnable {
    Chat m;

    public T1(Chat m1) {
        this.m = m1;
        new Thread(this, "First").start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            m.First("1");
        }
    }
}