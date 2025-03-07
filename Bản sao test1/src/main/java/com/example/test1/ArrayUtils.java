package com.example.test1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayUtils {
    public int findMax(int[] arrNumber){
        if (arrNumber == null || arrNumber.length == 0){
            throw new IllegalArgumentException("mang khong duoc rong");

        }
        //c1: gan gia tri dua tien la max -> so sanh tung phan tu voi max -> max moi
        //c2: su dung thuat toan sap xep, sap xep theo chieu tang/giam dan(bubble sort, quick sort, ...)
        Arrays.sort(arrNumber); //sap xep theo chieu tang dan
        int max = arrNumber[arrNumber.length-1];
        int index = arrNumber.length-1;
        System.out.println("gia tri lon nhat la: " + max +" va tai vi tri thu: "+ index);
        return  max;
    }
}
