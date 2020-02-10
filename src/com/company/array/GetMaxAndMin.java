package com.company.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到数组中的最大数和最小数
 */
public class GetMaxAndMin {
    private int max;
    private int min;
    public int getMax() {
        return max;
    }
    public int getMin() {
        return min;
    }

    //蛮力法，比较次数2n-2次
    public  void GetMaxAndMin1(int arr[]) {
        min = arr[0];
        max = arr[0];
        for (int i=1;i<arr.length;i++) {
            if (arr[i]<min) {
                min = arr[i];
            }
            if (arr[i]>max) {
                max = arr[i];
            }
        }
    }
    //分治法
    public void GetMaxAndMin2(int arr[]) {
        for (int i = 0;i<arr.length-1;i+=2) {
            if(arr[i]>arr[i+1]) {
                int tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
            }
        }
        min = arr[0];
        for (int i = 2;i<arr.length;i+=2) {
            if(arr[i]<min)
                min = arr[i];
        }
        max = arr[1];
        for (int i = 3;i<arr.length;i+=2) {
            if (arr[i]>max)
                max = arr[i];
        }
        if(arr.length%2==1) {
            if(max<arr[arr.length-1]) {
                max = arr[arr.length-1];
            }
            if (min>arr[arr.length-1]) {
                min = arr[arr.length-1];
            }
        }
    }
    //变形的分治法
    public List<Integer> GetMaxAndMin3(int arr[], int l, int r) {
        if(arr == null) {
            System.out.println("参数有误");
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int m = (l+r)/2;
        int max = 0;
        int min = 0;
        if(l == r) {
            list.add(arr[l]);
            list.add(arr[1]);
            return list;
        }
        if(l+1 == r) {
            if(arr[l]>=arr[r]) {
                min = arr[r];
                max = arr[l];
            }else {
                min = arr[l];
                max = arr[r];
            }
            list.add(min);
            list.add(max);
            return list;
        }
        List<Integer> lList = GetMaxAndMin3(arr,l,m);
        List<Integer> rList = GetMaxAndMin3(arr,m+1,r);
        max = Math.max(lList.get(1),rList.get(1));
        min = Math.min(lList.get(0),rList.get(0));
        list.add(min);
        list.add(max);
        return list;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,7,9,2,5,4,7,2,1,6};
        GetMaxAndMin gm = new GetMaxAndMin();
        //gm.GetMaxAndMin1(arr);
        //gm.GetMaxAndMin2(arr);
        List<Integer> list = gm.GetMaxAndMin3(arr,0,arr.length-1);
        System.out.println("max:"+gm.max+",min:"+gm.min);
        System.out.println("max:"+list.get(1)+",min:"+list.get(0));
    }
}
