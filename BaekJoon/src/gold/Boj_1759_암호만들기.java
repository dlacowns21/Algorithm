package gold;

import java.io.*;
import java.util.*;

public class Boj_1759_암호만들기 {

    static int L, C;
    static char[] chars;
    static char[] selected;
    static StringBuilder sb = new StringBuilder();
    static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        selected = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);

        dfs(0, 0);
        System.out.print(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == L) {
            int vowelCnt = 0, consonantCnt = 0;
            for (char c : selected) {
                if (vowels.contains(c)) vowelCnt++;
                else consonantCnt++;
            }
            if (vowelCnt >= 1 && consonantCnt >= 2) {
                sb.append(new String(selected)).append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            selected[depth] = chars[i];
            dfs(i + 1, depth + 1);
        }
    }
}