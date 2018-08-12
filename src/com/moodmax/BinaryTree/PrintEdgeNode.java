package com.moodmax.BinaryTree;

public class PrintEdgeNode {

    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }

    // 计算二叉树的高度
    public int getHeight(Node h, int l) {
        if(h == null)
            return l;
        return Math.max(getHeight(h.left, l+1), getHeight(h.right, l+1));
    }

    // 在二维数组中存储最左和最右节点
    public void setEdgeMap(Node head, int l, Node[][] edgeMap) {
        if(head==null)
            return;
        edgeMap[l][0] = edgeMap[l][0]==null?head:edgeMap[l][0];
        edgeMap[l][1] = head;
        setEdgeMap(head.left, l+1, edgeMap);
        setEdgeMap(head.right, l+1, edgeMap);
    }

    // 打印既不是左边界又不是右边界的叶子节点
    public void printLeafNotInMap(Node head, int l, Node[][] m) {
        if(head==null)
            return;
        if(head.left == null && head.right == null && head!=m[l][0] && head!=m[l][1]) {
            System.out.print(head.value + " ");
        }
        printLeafNotInMap(head.left, l+1, m);
        printLeafNotInMap(head.right, l+1, m);
    }


    public void printEdgeNode1(Node head) {
        if(head==null)
            return;
        int height = getHeight(head, 0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head, 0, edgeMap);
        // 打印左边界
        for(int i=0; i!=edgeMap.length; i++) {
            System.out.print(edgeMap[i][0].value + " ");
        }
        // 打印既不是左边界又不是右边界的叶子节点
        printLeafNotInMap(head, 0, edgeMap);

        // 打印右边界，但不是左边界的节点
        for(int i=edgeMap.length-1; i!=-1; i--) {
            if(edgeMap[i][1] != edgeMap[i][0])
                System.out.print(edgeMap[i][1].value + " ");
        }
    }
}
