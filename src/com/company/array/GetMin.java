package com.company.array;

/**
 * 找出旋转数组中的最小元素
 */
public class GetMin {
    public static int getMin(int arr[], int low, int high) {
        if (low > high) return arr[0];
        if(low == high) return arr[low];
        //int mid = (low+high)/2;
        int mid = low+((high-low)>>1);
        if (arr[mid] <arr[mid-1]) {
            return arr[mid];
        }
        else if(arr[mid]>arr[mid+1]) {
            return arr[mid+1];
        }
        else if(arr[mid]>arr[low]) {
            return getMin(arr,mid+1,high);
        }
        else if(arr[mid]<arr[high]) {
            return getMin(arr,low,mid-1);
        }else
            return Math.min(getMin(arr,low,mid-1),getMin(arr,mid+1,high));
    }

    public static void main(String[] args) {
        int arr[] = {5,6,1,2,3,4};
        int min = getMin(arr,0,arr.length-1);
        System.out.println(min);
    }
}
