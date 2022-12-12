package BackJune.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                n -= 5;
            } else {
                n -= 3;
            }
            count++;
        }

        System.out.println(n == 0 ? count : -1);
    }
}
