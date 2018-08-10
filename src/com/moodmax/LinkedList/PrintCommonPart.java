package com.moodmax.LinkedList;


class Node {
    public int value;
    public Node next = null;
    public Node(int data) {
        this.value = data;
    }
}

public class PrintCommonPart {

    public void printCommonPart(Node head1, Node head2) {
        while(head1!=null && head2!=null) {
            if(head1.value < head2.value) {
                head1 = head1.next;
            } else if(head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
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
        while(head!=null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

    }
}
