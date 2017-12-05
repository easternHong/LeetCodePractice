package misc;

import java.util.Stack;

public class Consumer {


    private static Stack<Integer> stack = new Stack<>();

    private final static Object lock = new Object();

    public static void main(String[] args) {
        Consumer.C consumer = new C();
        Consumer.P producer = new P();
        producer.start();
        consumer.start();
    }


    public static class C extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    for (int i = 0; i < 3; i++) {
                        stack.push(i);
                    }
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("释放锁");
            }
        }
    }

    public static class P extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (stack.size() < 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("没有锁："+stack.size());
                stack.clear();
            }
        }
    }
}
