package com.moodmax.BinaryTree;

/*
*  按层打印二叉树
*  按层遍历属于图的宽度优先遍历，需要使用队列来辅助完成
* */

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintLevelOrder {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printLevelOrder(Node head) {

        // 创建一个队列，使用链表LinkedList来实现队列
        LinkedList<Node> queue = new LinkedList<Node>();

        Node cur = head;    // 当前正在访问的节点
        Node last = head;   // 当前行最右节点
        Node nlast = null;  // 下一行最右节点

        queue.add(head);
        // poll弹出队首节点并返回
        // add将节点从队尾加入
        while(queue.size() != 0) {
            cur = queue.poll();
            System.out.print(cur.value + " ");
            if(cur.left != null) {
                queue.add(cur.left);
                nlast = cur.left;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                nlast = cur.right;
            }
            // 判断是否走到一层的边上，如果到边，则换行，更新
            if(cur==last) {
                System.out.println();
                last = nlast;
            }
        }

    }
}
