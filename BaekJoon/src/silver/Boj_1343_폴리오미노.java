package silver;

import java.io.*;

public class Boj_1343_폴리오미노 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        line = line.replace("XXXX", "AAAA");

        line = line.replace("XX", "BB");

        if (line.contains("X")) {
            System.out.println("-1");
        } else {
            System.out.println(line);
        }
    }
}