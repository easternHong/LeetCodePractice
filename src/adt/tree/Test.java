package adt.tree;

import java.util.List;

public class Test {


    public static void main(String[] args) {
        //
        long sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += base(10, i);
        }
        System.out.println(sum);

        System.out.println(60 * 99999999);
        String name = "BLAKE";

        System.out.println(hash(name));
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    static int base(int base, int powder) {
        return (int) Math.pow(base, powder);
    }

    class Node<T> {
        T data;
        List<Node<T>> subTree;
    }
}
