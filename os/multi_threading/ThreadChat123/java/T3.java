
class T3 implements Runnable {
    Chat m;

    public T3(Chat m3) {
        this.m = m3;
        new Thread(this, "Third").start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            m.Third("3");
        }
    }
}