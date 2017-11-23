package offer;

public class Singleton {


    /**
     * 饿汉，线程不安全
     */
    public static class T {
        private T() {
        }

        private static T instance = new T();

        public static T getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉，线程不安全
     */
    public static class T1 {

        private T1() {
        }

        private static T1 instance;

        public static T1 getInstance() {
            if (instance == null) instance = new T1();
            return instance;
        }
    }

    /**
     * 懒汉，线程安全
     */
    public static class T2 {
        private T2() {
        }

        private static T2 instance;

        public static synchronized T2 getInstance() {
            if (instance == null) {
                instance = new T2();
            }
            return instance;
        }
    }


    /**
     * 懒汉，线程安全
     */
    public static class T3 {

        private T3() {
        }

        private static T3 instance;

        static {
            instance = new T3();
        }

        public static T3 getInstance() {
            return instance;
        }
    }

    /**
     * 线程安全
     */
    private static class T4 {

        private T4() {
        }

        private static final class InstanceHolder {
            private static T4 INSTANCE = new T4();
        }

        public static T4 getInstance() {
            return InstanceHolder.INSTANCE;
        }

    }

    /**
     * 线程安全
     */
    public enum T5 {

        INSTANCE;

        public void what() {
        }
    }

    /**
     * 懒汉，线程安全
     */
    public static class T6 {

        private T6() {
        }

        private static T6 instance;


        public static T6 getInstance() {
            if (instance == null) {
                synchronized (T6.class) {
                    if (instance == null) {
                        instance = new T6();
                    }
                }
            }
            return instance;
        }
    }
}
