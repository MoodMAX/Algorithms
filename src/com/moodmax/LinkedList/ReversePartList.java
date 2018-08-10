package com.moodmax.LinkedList;

public class ReversePartList {
    // don't use this function
    static Node reverseList(Node head) {
        Node p = null;
        Node q = null;
        Node r = null;
        p = head;
        q = head.next;
        head.next = null;
        while(q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head = p;
        return head;
    }

    static Node reversePartList(Node head, int from, int to) {
        int len = 0;
        Node pre = null;
        Node behide = null;
        Node node1 = head;
        Node node2 = null;
        while(node1 != null) {
            len++;
            pre = len==from+1?node1:pre;
            behide = len==to+1?node1:pre;
            node1 = node1.next;
        }
        if(from > to || from <0 || to <1 || to > len)
            return head;
        node2 = pre.next;
        // reverse List
        Node p = null;
        Node q = null;
        Node r = null;
        p = node2;
        q = node2.next;
        node2.next = null;
        while(q != behide) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        pre.next = p;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node cur = new Node(0);
        int i = 0;
        while(i < 10) {
            i++;
            if(i==1)
                head = cur;
            cur.next = new Node(i);
            cur = cur.next;
        }
        head = head.next;
        head = reversePartList(head, 4, 8);
        while(head!=null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
