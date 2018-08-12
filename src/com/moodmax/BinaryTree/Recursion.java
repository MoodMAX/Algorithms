package com.moodmax.BinaryTree;

/*
* 用递归的方式实现二叉树的先序、中序和后序遍历
* */
public class Recursion {

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //先序遍历
    public void preOrderRecur(Node head) {
        if (head==null) //defensive coding
            return;
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //中序遍历
    public void inOrderRecur(Node head) {
        if (head==null)
            return;
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    //后序遍历
    public void posOrderRecur(Node head) {
        if (head==null)
            return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

}
