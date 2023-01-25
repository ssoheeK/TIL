package BackJune.BruteForce;

import java.io.*;

public class N1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 0;
        while (true) {
            if (String.valueOf(num).contains("666"))
                count++;

            if (count == n)
                break;

            num++;
        }
        System.out.println(num);
    }
}
