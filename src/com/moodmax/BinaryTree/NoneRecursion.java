package com.moodmax.BinaryTree;

import java.util.Stack;

/*
* 用非递归方式实现二叉树的先序中序和后序遍历
* */
public class NoneRecursion {

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
        if(head == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while(!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.value + " ");
            if(head.right != null)
                stack.push(head.right);
            if(head.left != null)
                stack.push(head.left);
        }
    }

    // 中序遍历
    public static void inOrder(Node head) {
        if(head == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while(!stack.isEmpty() || head != null) {
            if(head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }

        }
    }

    // 后序遍历
    public static void lastOrder2Stack(Node head) {
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.push(head);
        while(!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if(head.left != null)
                stack1.push(head.left);
            if(head.right != null)
                stack1.push(head.right);
        }

        while(!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }

    public static void lastOrder1Stack(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node h = head;  // 最近弹出节点
        Node c = null;  // 当前栈顶节点
        stack.push(head);
        while(!stack.isEmpty()) {
            c = stack.peek();
            if(c.left!=null && h!=c.left && h!=c.right) {
                stack.push(c.left);
            } else if(c.right!=null && h!=c.left && h!=c.right) {
                stack.push(c.right);
            } else {
                h = stack.pop();
                System.out.print(h.value + " ");
            }
        }
    }

}
