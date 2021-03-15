package me.bingbingpa.ch02;

import java.util.ArrayList;
import java.util.List;

public class ArrayConvert {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3},
                {4, 5, 6, 7, 8},
                {7, 8, 9}};
        // 1. 2dArray => list
        List<List<Integer>> list = convert2dArrayToList(array);
        System.out.println(list);

        // 2. list => 2dArray
        int[][] array2 = converterListTo2dArray(list);
        print(array2);
    }

    public static List<List<Integer>> convert2dArrayToList(int[][] array) {
        List<List<Integer>> result = new ArrayList<>();

        for (int[] ints : array) {
            List<Integer> list = new ArrayList<>();
            for (int anInt : ints) {
                list.add(anInt);
            }
            result.add(list);
        }

        return result;
    }

    public static int[][] converterListTo2dArray(List<List<Integer>> list) {
        int[][] result = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            result[i] = new int[list.get(i).size()];
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                result[i][j] = list.get(i).get(j);
            }
        }

        return result;
    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" a[" + i + "][" + j + "] " + array[i][j]);
            }
            System.out.println(" ");
        }
    }
}
