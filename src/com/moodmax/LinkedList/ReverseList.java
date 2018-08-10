package com.moodmax.LinkedList;

public class ReverseList {

    static Node reverseList(Node head) {
        if(head==null || head.next==null)
            return head;
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

    public static void main(String[] args) {
        Node head = new Node(0);
        Node cur = new Node(0);
        int i = 0;
        while(i < 6) {
            i++;
            if (i==1)
                cur = head;
            cur.next = new Node(i);
            cur = cur.next;
        }
        head = head.next;
        head = reverseList(head);
        while(head!= null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
