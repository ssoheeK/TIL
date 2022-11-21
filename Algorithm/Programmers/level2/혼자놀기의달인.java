package Programmers.level2;

public class 혼자놀기의달인 {
    static class Solution {
        public int solution(int[] cards) {
            // 상자를 저장할 배열
            int[] arr = {-1, -1};
            for (int i = 0; i < cards.length; i++) {
                // 방문했으면 다음 인덱스로 넘어감
                if (cards[i] == -1) continue;

                int count = recursive(cards, i);
                if (arr[0] < count) {
                    arr[1] = arr[0];
                    arr[0] = count;
                } else if (arr[1] < count) {
                    arr[1] = count;
                }
            }

            return arr[0] == cards.length ? 0 : arr[0] * arr[1];
        }

        private int recursive(int[] cards, int index) {
            // 방문 체크
            if (cards[index] == -1) {
                return 0;
            }
            int nextIndex = cards[index] - 1;
            cards[index] = -1;

            return recursive(cards, nextIndex) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
    }
}
