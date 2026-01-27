package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_3107_ipv6 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String address = br.readLine().trim();

        List<String> groups = new ArrayList<>(8);

        if (address.contains("::")) {
            String[] parts = address.split("::", -1);
            String left = parts[0];
            String right = (parts.length > 1) ? parts[1] : "";

            List<String> leftGroups = new ArrayList<>();
            List<String> rightGroups = new ArrayList<>();

            if (!left.isEmpty()) leftGroups.addAll(Arrays.asList(left.split(":", -1)));
            if (!right.isEmpty()) rightGroups.addAll(Arrays.asList(right.split(":", -1)));

            int zerosToFill = 8 - (leftGroups.size() + rightGroups.size());

            groups.addAll(leftGroups);
            for (int i = 0; i < zerosToFill; i++) groups.add("0");
            groups.addAll(rightGroups);
        } else {
            groups.addAll(Arrays.asList(address.split(":", -1)));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            String g = groups.get(i);
            if (g == null || g.isEmpty()) g = "0";
            sb.append(String.format("%4s", g).replace(' ', '0'));
            if (i < 7) sb.append(":");
        }

        System.out.println(sb.toString());
    }
}