package com.moodmax.Sorting;

public class Selection {

    public static void exec(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    public static void selection(int[] a) {
        int N = a.length;
        for(int i=0; i<N; i++) {
            int min = i;
            for(int j=i+1; j<N; j++) {
                if(a[min] > a[j])
                    min = j;
            }
            if(i != min)
                exec(a, i, min);
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 4, 2, 5, 1, 8, 2};
        selection(a);
        for(int i:a)
            System.out.print(i + " ");
    }

}
