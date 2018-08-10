package com.moodmax.LinkedList;


public class RemoveLastKthNode {
    static Node removeLastKthNode(Node head, int k) {

        if(head==null || k<1)
            return head;

        Node fast = new Node(0);
        Node slow = new Node(0);
        head = fast;
        head = slow;
        while(k > 0) {
            k--;
            fast = fast.next;
        }
        while(fast.next != null)
            fast = fast.next;
        slow.next = slow.next.next;
        slow.next.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node cur = new Node(0);
        int i = 0;
        while(i < 6) {
            i++;
            if(i==1)
                cur = head;
            cur.next = new Node(i);
            cur = cur.next;
        }
        head = head.next;
        // head = cur;
        System.out.println("删除前:");
        while(head!=null) {
            System.out.print(head.value+" ");
            head = head.next;
        }

    }
}
