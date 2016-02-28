class T2 implements Runnable {
    Chat m;

    public T2(Chat m2) {
        this.m = m2;
        new Thread(this, "Second").start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            m.Second("2");
        }
    }
}