package BackJune.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1931 {

    static List<time> list = new ArrayList<>();

    static class time {
        int start;
        int end;

        public time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int conferenceCnt = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < conferenceCnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            list.add(new time(startTime, endTime));
        }

        // 끝나는 시간으로 정렬한다.
        // 끝나는 시간이 같다면 시작 시간으로 정렬
        list.sort(new Comparator<time>() {
            public int compare(time o1, time o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        System.out.println(greedy());
    }

    private static int greedy() {
        int cnt = 0;
        int prevTime = 0;
        for (time t : list) {
            if (prevTime <= t.start) {
                prevTime = t.end;
                cnt++;
            }
        }
        return cnt;
    }
}
