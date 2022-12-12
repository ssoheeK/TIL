package BackJune.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String num = "";
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') { // - 연산자인 경우
                queue.add(sum += Integer.parseInt(num));
                sum = 0;
                num = "";
            } else if (c == '+') { // + 연산자인 경우
                sum += Integer.parseInt(num);
                num = "";
            } else { // 숫자인 경우
                num += c;
            }
        }

        // 마지막 숫자를 넣어준다.
        queue.add(sum += Integer.parseInt(num));

        int answer = queue.poll();
        while (!queue.isEmpty()) {
            answer -= queue.poll();
        }

        System.out.println(answer);
    }
}
