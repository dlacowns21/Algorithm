package silver;

import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int day;
    int month;
    int year;

    public Student(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public int compareTo(Student other) {

        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }

        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }

        return Integer.compare(this.day, other.day);
    }
}

public class Boj_5635_생일 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            students.add(new Student(name, d, m, y));
        }

        Collections.sort(students);
        System.out.println(students.get(N - 1).name);
        System.out.println(students.get(0).name);
    }
}