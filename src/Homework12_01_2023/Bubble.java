package Homework12_01_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bubble {
    static boolean isSorted;
    static List<Integer> arrList;

    public static void main(String[] args) {
        arrList = new ArrayList<>();
        arrList.add(5);
        arrList.add(40);
        arrList.add(-89);
        arrList.add(1);
        arrList.add(45);
        arrList.add(13);
        arrList.add(4);
        arrList.add(88);
        arrList.add(11);
        arrList.add(-30);

        print(arrList);
        sort(arrList);
        System.out.println("\nОтсортированные числа:");
        print(arrList);
        sort(arrList);
        print(arrList);
    }

    public static void sort(List<Integer> arrayList) {
        Integer [] numbers = new Integer[arrayList.size()];
        numbers = arrayList.toArray(numbers);

        if (!isSorted){
            isSorted = true;
            for (int j = 0; j < numbers.length; j++) {
                for (int i = 0; i < numbers.length - 1; i++) {
                    if (numbers[i] > numbers[i + 1]){
                        int temp = numbers[i];
                        numbers[i] = numbers[i + 1];
                        numbers[i + 1] = temp;
                    }
                }
            }
            arrList = Arrays.asList(numbers);
        } else if (isSorted) {
            System.out.println("\nУже отсортирован");
        }
    }

    public static void print(List<Integer> arrList) {
        for (Integer number : arrList) {
            System.out.print(number + "\t");
        }
    }

}
