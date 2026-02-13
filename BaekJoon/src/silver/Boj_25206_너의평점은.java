package silver;

import java.io.*;
import java.util.*;

public class Boj_25206_너의평점은 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0.0;
        double total = 0.0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue;

            total += credit;

            switch (grade) {
                case "A+": sum += credit * 4.5; break;
                case "A0": sum += credit * 4.0; break;
                case "B+": sum += credit * 3.5; break;
                case "B0": sum += credit * 3.0; break;
                case "C+": sum += credit * 2.5; break;
                case "C0": sum += credit * 2.0; break;
                case "D+": sum += credit * 1.5; break;
                case "D0": sum += credit * 1.0; break;
                case "F":  sum += credit * 0.0; break;
            }
        }

        System.out.printf("%.6f\n", sum / total);
    }
}