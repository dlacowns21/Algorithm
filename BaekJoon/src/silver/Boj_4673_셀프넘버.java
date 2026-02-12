package silver;

import java.io.*;
import java.util.*;

public class Boj_4673_셀프넘버 {

    public static void main(String[] args) {

        boolean[] isNotSelfNumber = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int n = d(i);

            if (n <= 10000) {
                isNotSelfNumber[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (!isNotSelfNumber[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int d(int number) {
        int sum = number;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}