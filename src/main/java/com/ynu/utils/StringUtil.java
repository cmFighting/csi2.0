package com.ynu.utils;

public class StringUtil {

    public static int[] stringToInt(String listString){
//        String listString = "1,2,3,4,5,6,7";
        String[] strArr = listString.split(",");
        int[] intList = new int[strArr.length];
        for(int i=0;i<intList.length;i++){
            intList[i] = Integer.parseInt(strArr[i]);
        }
        return intList;
    }
}
