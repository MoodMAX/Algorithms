package com.moodmax.BinaryTree;

/*
* 用递归的方式实现二叉树的先序、中序和后序遍历
* */
public class Recursion {
    class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 先序遍历
    public static void preOrder(Node head) {
        if (head == null)
            return;
        System.out.print(head.value + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    // 中序遍历
    public static void inOrder(Node head) {
        if(head == null)
            return;
        inOrder(head.left);
        System.out.print(head.value + " ");
        inOrder(head.right);
    }

    // 后序遍历
    public static void lastOrder(Node head) {
        if(head == null)
            return;
        lastOrder(head.left);
        lastOrder(head.right);
        System.out.print(head.value + " ");
    }
}
