package BackJune.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1759 {
    static int L, C;
    static boolean[] visited;
    static char[] arr;
    static char[] chArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chArr = new char[L];
        visited = new boolean[C];

        arr = new char[C];
        String input = br.readLine().replace(" ", "");
        for (int i = 0; i < C; i++) {
            arr[i] = input.charAt(i);
        }
        br.close();

        // 사전순서대로 정렬
        Arrays.sort(arr);

        dfs(0,0);
        System.out.println(sb);
    }

    private static void dfs(int level, int depth) {
        if (depth == L) {
            int ja = 0;
            int mo = 0;
            // 모음이 1개 이상, 자음이 2개 이상인지 확인
            for (char val : chArr) {
                if (isValid(val)) {
                    mo++;
                } else {
                    ja++;
                }
            }

            if (mo >= 1 && ja >= 2) {
                for (char val : chArr) {
                    sb.append(val);
                }
                sb.append("\n");
            }

            return;
        }

        for (int i = level; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                chArr[depth] = arr[i];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isValid(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }
}
