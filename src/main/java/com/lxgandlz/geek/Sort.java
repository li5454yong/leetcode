package com.lxgandlz.geek;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author li xin guang
 * @date 2020-09-02 22:28
 **/
public class Sort {
    /**
     * 插入排序 100万数据量用时 114561ms
     * @param arr
     */
    public void insertSort(int[] arr){
        long start = System.currentTimeMillis();
        for(int i=1; i<arr.length; ++i){
            int value = arr[i];
            int j = i-1;
            for(; j>=0; j--){
                if(arr[j] > value){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = value;
        }
        System.out.println(System.currentTimeMillis() - start);
        //System.out.println(JSON.toJSONString(arr));
    }

    /**
     * 选择排序 100万数据量用时 116633ms
     * @param arr
     */
    public void selectSort(int[] arr){
        long start = System.currentTimeMillis();
        for(int i=0; i<arr.length-1; i++){
            int value = arr[i];
            int min = arr[i];
            int n = i;
            for(int j=i+1;j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    n = j;
                }
            }
            arr[i] = arr[n];
            arr[n] = value;

        }
        System.out.println(System.currentTimeMillis() - start);
        //System.out.println(JSON.toJSONString(arr));
    }

    /**
     * 归并排序
     * @param arr
     * @return
     */
    public int[] mergeSort(int[] arr){

        if(arr.length < 2){
            return arr;
        }

        int q = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,q));
        int[] right = mergeSort(Arrays.copyOfRange(arr,q,arr.length));

        int[] temp = new int[left.length + right.length];
        int k = 0,j = 0, i=0;
        while (k < left.length && j < right.length){
            if(left[k] < right[j]){
                temp[i] = left[k];
                k++;
            }else {
                temp[i] = right[j];
                j++;
            }
            i++;
        }
        if(k < left.length){
            for(;k<left.length;k++,i++){
                temp[i] = left[k];
            }
        }
        if(j < right.length){
            for(;j<right.length;j++,i++){
                temp[i] = right[j];
            }
        }
        return temp;
    }

    /**
     * 快速排序
     * @param arr
     * @param p
     * @param r
     * @return
     */
    public int[] quickSort(int[] arr, int p, int r){

        if(p > r){
            return new int[]{};
        }

        int q = partition(arr, p, r);
        quickSort(arr, p,q-1);
        quickSort(arr, q+1,r);

        return arr;
    }

    private int partition(int[] arr, int p, int r){

        int pivot = arr[r];
        int i = p;
        for(int j=p; j<r; j++){
            if(arr[j] < pivot){
               int temp = arr[j];
               arr[j] = arr[i];
               arr[i] = temp;
               i++;
            }
        }
        int temp = arr[r];
        arr[r] = arr[i];
        arr[i] = temp;
        return i;
    }

    /**
     * 计数排序
     * @param arr
     * @param n
     */
    public void countingSort(int[] arr, int n){
        // 查找数组中的最大值
        int max = arr[0];
        for(int i=1; i<n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }

        // 创建一个计数数组
        int[] countArr = new int[max+1];
        for(int j=0; j<n; j++){
            countArr[arr[j]]++;
        }

        for(int l=1; l<=max; l++){
            countArr[l] = countArr[l-1] + countArr[l];
        }
        // 对结果进行排序
        int[] result = new int[n];
        for(int k=0; k<n; k++){
            result[countArr[arr[k]]-1] = arr[k];
            countArr[arr[k]]--;
        }
        //System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void test(){
        int length = 1000000;
        int[] arr = new int[length];
        Random random = new Random();
        for(int i=0; i<length; i++){
            arr[i] = random.nextInt(length*10);
        }
        //System.out.println(JSON.toJSONString(arr));
        //selectSort(arr);

        //insertSort(arr);
        /*long start = System.currentTimeMillis();
        System.out.println(JSON.toJSONString(mergeSort(arr)));
        System.out.println(System.currentTimeMillis() - start);*/

        long start = System.currentTimeMillis();
        quickSort(arr,0,length-1);
        countingSort(arr,length);
        System.out.println(System.currentTimeMillis() - start);
    }
}
