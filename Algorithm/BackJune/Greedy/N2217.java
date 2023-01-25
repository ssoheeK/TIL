package BackJune.Greedy;

import java.io.*;
import java.util.Arrays;

public class N2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(weights);

        int maxWeight = 0;
        int rope = 1;
        for (int i = n - 1; i >= 0; i--) {
            int calWeight = weights[i] * rope++;

            if (calWeight > maxWeight)
                maxWeight = calWeight;
        }

        System.out.println(maxWeight);
    }
}
