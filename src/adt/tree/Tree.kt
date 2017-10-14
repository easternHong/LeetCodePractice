package adt.tree

import adt.utils.Utils

/**
 * Created by hds on 17-10-14.
 */
object Tree {
//    （1）：前序遍历，中序遍历，后序遍历；
//    （2）：层次遍历；
//    （3）：求树的结点数；
//    （4）：求树的叶子数；
//    （5）：求树的深度；
//    （6）：求二叉树第 k 层的结点个数;
//    （7）：判断两棵二叉树是否结构相同；
//    （8）：求二叉树的镜像；
//    （9）：求两个结点的最低公共祖先结点；
//    （10）：求任意两结点距离；
//    （11）：找出二叉树中某个结点的所有祖先结点；
//    （12）：不使用递归和栈遍历二叉树；
//    （13）：二叉树前序中序推后序；
//    （14）：判断二叉树是不是完全二叉树;
//    （15）：判断是否是二叉查找树的后序遍历结果；
//    （16）：给定一个二叉查找树中的结点，找出在中序遍历下它的后继和前驱；
//    （17）：二分查找树转化为排序的循环双链表；
//    （18）：有序链表转化为平衡的二分查找树；
//    （19）：判断是否是二叉查找树。

    //    LeetCode 二叉树经典题目
//    说明
//    题目
//    144. Binary Tree Preorder Traversal
//    递归
//    非递归
//    94. Binary Tree Inorder Traversal
//    递归
//    非递归
//    145. Binary Tree Postorder Traversal
//    递归
//    非递归
//    102. Binary Tree Level Order Traversal
//    103. Binary Tree Zigzag Level Order Traversal
//    199. Binary Tree Right Side View
//    105. Construct Binary Tree from Preorder and Inorder Traversal
//    106. Construct Binary Tree from Inorder and Postorder Traversal
//    95. Unique Binary Search Trees II
//    96. Unique Binary Search Trees
//    98. Validate Binary Search Tree
//    100. Same Tree
//    101. Symmetric Tree
//    104. Maximum Depth of Binary Tree
//    110. Balanced Binary Tree
//    111. Minimum Depth of Binary Tree
//    112. Path Sum
//    113. Path Sum II
//    129. Sum Root to Leaf Numbers
//    257. Binary Tree Paths
//    108. Convert Sorted Array to Binary Search Tree
//    116. Populating Next Right Pointers in Each Node
//    222. Count Complete Tree Nodes
//    226. Invert Binary Tree
//    230. Kth Smallest Element in a BST
//    235. Lowest Common Ancestor of a Binary Search Tree
//    236. Lowest Common Ancestor of a Binary Tree
//    297. Serialize and Deserialize Binary Tree
//    337. House Robber III
//
    private val TYPE_PRE: Int = 0
    private val TYPE_IN: Int = 1
    private val TYPE_AFTER: Int = 2

    class Node<T>(leftNode: Node<T>?, rightNode: Node<T>?, data: T) {
        var leftNode: Node<T>? = leftNode
        var rightNode: Node<T>? = rightNode
        var data: T? = data
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("Tree")
        var node = createRandomTree(10)
        traversal(node, TYPE_PRE)
        traversal(node, TYPE_IN)
        traversal(node, TYPE_AFTER)
    }

    /**
     * 前序遍历，中序遍历，后序遍历
     * 只不过是打印的位置不同
     */
    private fun traversal(node: Node<Int>?, type: Int) {
        if (node == null) return
        if (type == TYPE_PRE)
            println("pre: " + node.data)
        traversal(node.leftNode, type)
        if (type == TYPE_IN)
            println("In: " + node.data)
        traversal(node.rightNode, type)
        if (type == TYPE_AFTER)
            println("after: " + node.data)
    }

    private fun traversalLevel(node: Node<Int>?) {

    }

    private fun createRandomTree(cnt: Int): Node<Int> {
        var head = createNode(10)
        var first = head
        for (i in 0..cnt) {
            val r = Utils.getRandom(20)
            println("random:" + r)
            if (r % 2 == 0) {
                var leftChild = createNode(i)
                head.rightNode = leftChild
                head = leftChild
            } else {
                var rightChild = createNode(i)
                head.leftNode = rightChild
                head = rightChild
            }
        }
        return first
    }

    private fun createNode(data: Int): Node<Int> {
        return Node(null, null, data)
    }


}