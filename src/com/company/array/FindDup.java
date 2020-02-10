package com.company.array;

/**
 * 找出数组中唯一重复的元素
 * 描述：数字1~1000放在含有1001个元素的数组中，其中之有唯一个元素值重复，其他数字均只出现一次
 */
public class FindDup {
    //累加求和法
    public int findDup1(int arr[]) {
        int sum = 0;
        int num = 0;
        for (int i=0;i<arr.length;i++) {
            sum += arr[i];
        }
        for (int i=1;i<=1000;i++) {
            num += i;
        }
        return sum - num;
    }
    //异或法
    public int findDup2(int arr[]) {
        int num = 0;
        for (int i=0;i<arr.length;i++) {
            num ^= arr[i];
        }
        for (int i=1;i<=1000;i++) {
            num ^= arr[i];
        }
        return num;
    }
    //数据隐射法
    public int findDup3(int arr[]) {
        if (arr==null) return -1;
        int len = arr.length;
        int index = 0;
        int i = 0;
        while(true) {
            if(arr[i]>=len)
                return -1;
            if(arr[index]<0) break;
            arr[index] *= -1;
            index = -1*arr[index];
            if (index >=len) {
                System.out.println("数组中有非法数字");
                return -1;
            }
            i++;
        }
        return index;
    }
    //环形相遇法
    public int findDup4(int arr[]) {
        int fast = 0,slow = 0;
        do {
            fast = arr[arr[fast]];
            slow = arr[slow];
        }while (slow!=fast);
        do {
            fast = arr[fast];
            slow = arr[slow];
        }while (slow != fast);
        return fast;
    }
}
