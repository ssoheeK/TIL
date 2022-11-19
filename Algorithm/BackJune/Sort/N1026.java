package BackJune.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class N1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] b = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        // a의 가장 작은 수 * b의 가장 큰 수
        // a의 가장 큰 수 * b의 가장 작은 수
        // 순서대로 정렬
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(b[i]);
        }

        for (int i = 0; i < n; i++) {
            int max = Collections.max(list);
            sum += max * a[i];
            list.remove(Integer.valueOf(max));
        }

        System.out.println(sum);
    }
}
