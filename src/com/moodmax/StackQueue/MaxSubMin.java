package com.moodmax.StackQueue;

/*
*  最大值减去最小值小于等于num的子数组的数量
* */

import java.util.LinkedList;

public class MaxSubMin {
    public int getNum(int[] arr, int num) {
        if(arr==null || arr.length==0)
            return 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while(i < arr.length) {
            while(j < arr.length) {
                while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while(!qmax.isEmpty() && arr[qmin.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if( arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if(qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == i) {
                qmin.pollFirst();
            }
            res += j-i;
            i++;
        }
        return res;
    }

}
