class Chat {
	enum EFLAG {FIRST, SECOND, THIRD};
	EFLAG eFlag = EFLAG.THIRD; 
	//boolean bFlag = false;

    public synchronized void First(String msg) {
        if (eFlag == EFLAG.FIRST) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        eFlag = EFLAG.FIRST;
        notify();
    }

    public synchronized void Second(String msg) {
    	if (eFlag == EFLAG.SECOND) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(msg);
        eFlag = EFLAG.THIRD;
        notify();
    }

    public synchronized void Third(String msg) {
        if (eFlag == EFLAG.THIRD) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(msg);
        eFlag = EFLAG.FIRST;
        notify();
    }
}