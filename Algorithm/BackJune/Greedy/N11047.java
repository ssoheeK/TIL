package BackJune.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11047 {
    public static void main(String[] args) throws IOException {
        // 동전 개수의 최솟값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int coinCnt = Integer.parseInt(st.nextToken()); // 동전 종류 개수
        int totalCoin = Integer.parseInt(st.nextToken());   // 동전 가치의 합

        int[] coins = new int[coinCnt];
        for (int i = 0; i < coinCnt; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        // 큰 숫자부터 차례대로 나눈다.
        for (int i = coinCnt - 1; i >= 0 ; i--) {
            // totalCoin 보다 작거나 같으면서 가장 가치가 큰 코인을 찾는다.
            if (totalCoin >= coins[i]) {
                // totalCoin / coins[i]를 통해 coins[i]가 몇개가 쓰였는지 확인한다.
                count += (totalCoin / coins[i]);
                // totalCoin의 값을 갱신한다.
                totalCoin %= coins[i];

                // 0이 되면 빠져나옴
                if (totalCoin == 0) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
