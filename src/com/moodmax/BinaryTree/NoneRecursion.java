package com.moodmax.BinaryTree;

import java.util.Stack;

/*
* 用非递归方式实现二叉树的先序中序和后序遍历
* */
public class NoneRecursion {

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //先序遍历
    public void preOrderUnRecur(Node head) {
        if(head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while(!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if(head.right != null) {
                    stack.push(head.right);
                }
                if(head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //中序遍历
    public void inOrderUnRecur(Node head) {
        Stack<Node> stack = new Stack<Node>();
        while(!stack.isEmpty() || head != null) {
            if(head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

}
