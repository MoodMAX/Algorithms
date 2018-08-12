package com.moodmax.BinaryTree;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }

    public void display() {
        System.out.print(this.value + "\t");
    }
}

// 需要实现的二叉树操作
class BinaryTree {
    private Node root = null;

    BinaryTree(int value) {
        root = new Node(value);
        root.left = null;
        root.right = null;
    }

    // 查找
    public Node findKey(int value) {
        Node cur = root;
        while(true) {
            if(value == cur.value) {
                return cur;
            } else if(value < cur.value) {
                cur = cur.left;
            } else
                cur = cur.right;

            if(cur == null) {
                return null;
            }
        }
    }

    // 插入
    public String insert(int value) {
        String error = null;
        Node node = new Node(value);
        if(root==null) {
            root = node;
            root.left = null;
            root.right = null;
        } else {
            Node cur = root;
            Node parent = null;
            while(true) {
                if(value<cur.value) {
                    parent = cur;
                    cur = cur.left;
                    if(cur == null) {
                        parent.left = node;
                        break;
                    }
                } else if (value > cur.value) {
                    parent = cur;
                    cur = cur.right;
                    if(cur == null) {
                        parent.right = node;
                        break;
                    }
                } else {
                    error = "having same value in binary tree";
                }
            }
        }
        return error;
    }

    // 中序遍历递归操作
    public void inOrderTraverse() {

    }

    // 中序遍历非递归操作
    public void inOrderByStack() {

    }

    // 先序遍历递归操作
    public void preOrderTraverse() {

    }

    // 先序遍历非递归操作
    public void preOrderByStakc() {

    }

    // 后序遍历递归操作
    public void postOrderTraverse() {

    }

    // 后序遍历非递归操作
    public void postOrderByStakc() {

    }

}

public class ImpBinaryTree {

}
