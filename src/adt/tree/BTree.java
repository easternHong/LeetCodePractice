package adt.tree;

import java.util.Stack;

public class BTree {


    public static void main(String[] args) {
        BNode root = tree();
        invertBT(root);
        System.out.println(root);
        System.out.println("深度:" + getDepth(root));
    }

    /**
     * 递归
     *
     * @param root
     */
    public static void invertBT(BNode root) {
        if (root == null) {
            return;
        }
        BNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertBT(root.left);
        invertBT(root.right);
    }

    /**
     * 非递归
     */
    public static void invertBT_(BNode root) {
        if (root == null) {
            return;
        }
        Stack<BNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BNode tmpNode = stack.pop();
            BNode tmp = tmpNode.left;
            tmpNode.left = tmpNode.right;
            tmpNode.right = tmp;

            if (tmpNode.left != null) {
                stack.push(tmpNode.left);
            }
            if (tmpNode.right != null) {
                stack.push(tmpNode.right);
            }
        }
    }

    public static class BNode {
        public BNode left, right;
        public int data;
    }

    public static BNode tree() {
        BNode root = new BNode();
        root.data = 0;
        root.left = createNode(1);
        root.right = createNode(2);

        root.left.left = createNode(3);
        root.left.right = createNode(4);
        root.right.left = createNode(5);
        root.right.right = createNode(6);
        root.right.right.right = createNode(7);
        return root;
    }


    public static BNode createNode(int data) {
        BNode node = new BNode();
        node.data = data;
        return node;
    }


    /**
     * 二叉树的额深度
     *
     * @param root
     * @return
     */
    public static int getDepth(BNode root) {
        if (root == null) {
            return 0;
        }
        int dLeft = getDepth(root.left);
        int dRight = getDepth(root.right);
        //那为什么是Math.max(左节点的深度,右节点的深度)+1
        //一层的深度是1，
        return Math.max(dLeft, dRight) + 1;
    }
}
