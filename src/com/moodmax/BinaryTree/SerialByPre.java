package com.moodmax.BinaryTree;

/*
*  通过二叉树的先序遍历进行二叉树的序列化和反序列化
* */

import java.util.LinkedList;
import java.util.Queue;

public class SerialByPre {

    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }

    // 序列化
    public String serialByPre(Node head) {
        if (head == null)
            return "#!";

        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    // 利用先序遍历结果进行反序列化
    public Node reconByPreString(String preStr) {

        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<String>();
        for(int i=0; i<values.length; i++)
            queue.offer(values[i]);
        return reconPreOrder(queue);
    }

    public Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if(value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

}
