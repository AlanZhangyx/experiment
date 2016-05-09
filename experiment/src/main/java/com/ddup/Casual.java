package com.ddup;

import org.apache.commons.lang.StringUtils;

public class Casual {

    /**
     * @Title
     * @Description
     * @param args
     * @TestUrl
     */
    public static void main(String[] args) {
        /*int a = (int)1.9;
        System.out.println(a);
        
        int b = Math.round(2.5f);
        System.out.println(b);*/
    	
        System.out.println("{\"code\":\"" + 1234 + "\",\"product\":\"雷鸣教育\",\"item\":\"阿里大鱼\"}");
        
        int[] arr = new int[]{1, 2 , -1, 0, 10, 100, 2500, -100, 1200, 1, 2};
        quickSort(arr, 0, arr.length - 1);
        
        for (int i = 0; i < arr.length; i++) {
        	System.out.println(arr[i]);
		}
        
        
    }
    
    public static void quickSort(int[] arr, int left, int right){
    	if (left < right) {
			int l = left, r = right;
			int pivot = arr[l];
			
			while (l < r) {
				while (l < r && arr[r] >= pivot) {
					r--;
				}
				arr[l] = arr[r];
				
				while (l < r && arr[l] <= pivot) {
					l++;
				}
				arr[r] = arr[l];
			}
			arr[l] = pivot;
			
			quickSort(arr, left, l - 1);
			quickSort(arr, r + 1, right);
		}
    }

}
