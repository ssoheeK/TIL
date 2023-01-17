package BackJune.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long a = 0;
        long b = 1;
        for (int i = 0; i < n - 1; i++) {
            long tmp = a + b;
            b = a;
            a = tmp;
        }

        System.out.println(a + b);
    }
}
