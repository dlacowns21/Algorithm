package BaekJoon.src.gold;

import java.io.*;

public class Boj_1334_다음펠린드롬수 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int len = N.length();

        if (isNine(N)) {
            StringBuilder sb = new StringBuilder();
            sb.append("1");
            for(int i = 0; i < len - 1; i++) sb.append("0");
            sb.append("1");
            System.out.println(sb);
            return;
        }

        String palindrome = makeP(N);

        if (palindrome.compareTo(N) > 0) {
            System.out.println(palindrome);
            return;
        }

        String increased = increase(N);
        System.out.println(makeP(increased));
    }

    static String makeP(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            arr[len - 1 - i] = arr[i];
        }
        return new String(arr);
    }

    static String increase(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int mid = (len - 1) / 2;

        while (mid >= 0 && arr[mid] == '9') {
            arr[mid] = '0';
            mid--;
        }
        arr[mid]++;

        return new String(arr);
    }

    static boolean isNine(String s) {
        for (char c : s.toCharArray()) {
            if (c != '9') return false;
        }
        return true;
    }
}