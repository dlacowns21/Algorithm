package class4;

import java.io.*;

public class Boj_11444_피보나치수6 {

    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(fib(n));
    }

    // n번째 피보나치 수를 구한다
    static long fib(long n) {
        if (n == 0) return 0;
        long[][] base = {{1, 1}, {1, 0}};
        long[][] result = matrixPower(base, n - 1);
        return result[0][0]; // F(n)
    }

    // 행렬을 거듭제곱
    static long[][] matrixPower(long[][] matrix, long power) {
        long[][] result = {{1, 0}, {0, 1}}; // 단위 행렬
        while (power > 0) {
            if (power % 2 == 1) {
                result = multiply(result, matrix);
            }
            matrix = multiply(matrix, matrix);
            power /= 2;
        }
        return result;
    }

    // 2x2 행렬 곱
    static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return result;
    }
}
