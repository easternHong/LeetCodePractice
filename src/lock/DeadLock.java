package lock;


/**
 * 死锁：两个以上的计算单元（进程），双方都在等待对方停止运行，以获取系统资源，但是没有一方提前退出时
 * 就称为死锁。
 * 四个必要条件：
 * 1。互斥
 * 2。持有与保持
 * 3。禁止抢占
 * 4。循环等待
 */
public class DeadLock {

    private static final Object locka = new Object();
    private static final Object lockb = new Object();

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {

            System.out.println("try getting locka");
            synchronized (locka) {

                System.out.println("get lock a ok");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("try get lockb");
                synchronized (lockb) {
                    System.out.println("get lockb ing ");
                }
            }


        }, "thread1");

        Thread t2 = new Thread(() -> {
            System.out.println("try get lock b");
            synchronized (lockb) {
                System.out.println("get lock b ok");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("try get locka");
                synchronized (locka) {
                    System.out.println("get locka ing ");
                }
            }
        }, "thread2");

        t1.start();
        t2.start();

    }


}



