package offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * 思路:
 * 1.入列，往s1压入数据，这个时候不需要判断s1，s2的状态。
 * 这里有个条件就是，必须把s2清空，才能够push元素到s1。
 * 2.出列，判断s2是否为空，不为空直接pop,否在倒入s1.size()-1个倒入s2。最后从s1 pop
 */
public class Queue_double_stack<T> {

    public static void main(String[] args) {

    }


    private Stack<T> stackA = new Stack<>();
    private Stack<T> stackB = new Stack<>();


    private void push(T t) {
        while (!stackB.isEmpty()) {
            stackB.pop();
        }
        stackA.push(t);
    }

    public T pop() {
        if (stackB.isEmpty()) {
            if (stackA == null) {
                return null;
            }
            while (stackA.size() > 1) {
                T e = stackA.pop();
                stackB.push(e);
            }
            return stackA.pop();
        } else {
            return stackB.pop();
        }
    }

}
