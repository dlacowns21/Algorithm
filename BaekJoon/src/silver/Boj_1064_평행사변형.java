package BaekJoon.src.silver;

import java.io.*;
import java.util.*;

public class Boj_1064_평행사변형 {

    static int xa, ya, xb, yb, xc, yc;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        xa = Integer.parseInt(st.nextToken());
        ya = Integer.parseInt(st.nextToken());
        xb = Integer.parseInt(st.nextToken());
        yb = Integer.parseInt(st.nextToken());
        xc = Integer.parseInt(st.nextToken());
        yc = Integer.parseInt(st.nextToken());

        int crossProduct = (xb - xa) * (yc - ya) - (yb - ya) * (xc - xa);

        if (crossProduct == 0) {
            System.out.println(-1.0);
            return;
        }

        double ab = distance(xa, ya, xb, yb);
        double bc = distance(xb, yb, xc, yc);
        double ca = distance(xc, yc, xa, ya);

        double perimeter1 = 2 * (ab + ca);

        double perimeter2 = 2 * (ab + bc);

        double perimeter3 = 2 * (bc + ca);

        double max = Math.max(perimeter1, Math.max(perimeter2, perimeter3));
        double min = Math.min(perimeter1, Math.min(perimeter2, perimeter3));

        System.out.println(max - min);
    }

    static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}