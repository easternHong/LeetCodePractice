package test;

import adt.sort.QuickSort;
import adt.tree.BTree;
import utils.Utils;

import java.util.*;

import static adt.tree.BTree.tree;

public class Test {

    private String name;
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (name != null ? !name.equals(test.name) : test.name != null) return false;
        return content != null ? content.equals(test.content) : test.content == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        print_99_table(10);
        int[] array = {0, 30, 5, 40, 15, 20, 7};
        optBubble(array);
        System.out.println("优化版冒泡：" + Arrays.toString(array));
        System.out.println("二分搜索:30:" + bSearch(array, 30));

        BTree.BNode root = tree();
        invertBT_(root);
        System.out.println(root);

        int a = 1027 & 0x06;
        System.out.println(Integer.toBinaryString(1027));
        System.out.println(Integer.toBinaryString(0x06));
        System.out.println(a);

        a = (byte) 0xffff;

        System.out.println(a);
        r();
    }

    public static void r() {
        int[] array = new int[100];
        Map<Integer, Integer> set = new HashMap<>();
        while (true) {
            int r = Math.abs(new Random().nextInt() % 100);
            if (!set.containsKey(r)) {
                set.put(r, r);
                array[set.size() - 1] = r;
            }
            if (set.size() == 100) break;
        }
        qSort(array);
        System.out.println(array);
    }

    public static void qSort(int[] array) {
        if (array == null) return;
        quickSort(0, array.length - 1, array);
    }

    public static void quickSort(int l, int h, int[] array) {
        if (l < h) {
            int p = partition(l, h, array);
            quickSort(l, p - 1, array);
            quickSort(p + 1, h, array);
        }
    }

    /**
     * 1.找一个target = array[array.length - 1]
     * 2.两头向中间偏移，交换 array[x]，array[y]
     * 3.array[x]和target比较，否则x++
     * 4.返回x
     *
     * @param l
     * @param h
     * @param array
     * @return
     */
    public static int partition(int l, int h, int[] array) {
        int x = l;
        int y = h;
        int target = array[h];
        while (x < y) {
            while (x < y && array[x] < target) x++;
            while (x < y && array[y] >= target) y--;
            if (array[x] >= array[y]) {
                swap(x, y, array);
            }
        }
        if (array[x] >= target) {
            swap(x, h, array);
        } else x++;
        return x;
    }

    private static void swap(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    public static void reverseBT(BTree.BNode root) {
        if (root == null) {
            return;
        }
        BTree.BNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reverseBT(root.left);
        reverseBT(root.right);
    }

    public static void invertBT_(BTree.BNode root) {
        if (root == null) {
            return;
        }
        Stack<BTree.BNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BTree.BNode tmpRoot = stack.pop();
            System.out.println("pop:" + tmpRoot.data);
            BTree.BNode tmp = tmpRoot.left;
            tmpRoot.left = tmpRoot.right;
            tmpRoot.right = tmp;
            if (tmpRoot.left != null) {
                stack.push(tmpRoot.left);
            }
            if (tmpRoot.right != null) {
                stack.push(tmpRoot.right);
            }
        }
    }


    public static void optBubble(int[] array) {
        if (array == null || array.length == 1) return;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[i] > array[j]) {
//                    swap(i, j, array);
//                }
//            }
//        }
        boolean flag = true;
        for (int i = 0; i < array.length && flag; i++) {
            flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                    flag = true;
                }
            }
        }

    }

    public static int bSearch(int[] array, int target) {
        if (array == null) return -1;
        int low = 0, high = array.length - 1;
        int startIndex = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                startIndex = mid;
                //第一位
                high = mid - 1;
                //最后一位，low = mid + 1;
            }
        }
        return startIndex;
    }

    /**
     * 一个for打印99乘法表
     */
    private static void print_99_table(int n) {
        for (int i = 1, j = 1; i < 10; j++) {
            System.out.print(i + "*" + j + "=" + (i * j) + " ");
            if (i == j) {
                i++;
                j = 0;
                System.out.println();
            }
        }
        for (int i = 1, j = 1; i < 10; j++) {

            if (i == j) {
                i++;
                j = 0;
            }

        }

    }
}
