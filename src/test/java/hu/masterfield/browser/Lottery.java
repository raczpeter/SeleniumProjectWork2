package hu.masterfield.browser;

import java.util.*;
import java.util.stream.Collectors;

public class Lottery {

    public static void main(String[] args) {

        Random r = new Random();
        int low = 1;
        int high = 91;

        Map<String, Integer> lotteryNumbers = new TreeMap<>();
        for (int i=1; i<=90; i++) {
            lotteryNumbers.put(String.valueOf(i),0);
        }
        for (int i=0; i<=100_000_000; i++) {
            int result = r.nextInt(high-low) + low;
            for ( Map.Entry<String, Integer> entry : lotteryNumbers.entrySet()) {
                if (entry.getKey().equals(String.valueOf(result))) {
                    entry.setValue(entry.getValue()+1);
                }
            }
        }
        for (int i=0; i<5;i++) {
            int max = Integer.MIN_VALUE;
            String temp = "";
            for (Map.Entry<String, Integer> entry : lotteryNumbers.entrySet()) {
                if (entry.getValue() > max) {
                    temp = entry.getKey();
                }
            }
            System.out.println(temp + "\t\t");
            lotteryNumbers.remove(temp);
        }
    }
}
