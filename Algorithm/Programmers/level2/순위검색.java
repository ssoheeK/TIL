package Programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 순위검색 {
    static HashMap<String, ArrayList<Integer>> scoreMap;
    static int score;
    static String[] strings;
    static String[] sInfoArr;

    static void dfs(int v) {
        if (v == 4) {
            String str = String.join("", strings);
            if (!scoreMap.containsKey(str)) scoreMap.put(str, new ArrayList<>());
            scoreMap.get(str).add(score);
        } else {
            strings[v] = sInfoArr[v];
            dfs(v + 1);
            strings[v] = "-";
            dfs(v + 1);
        }
    }

    static int lowerBound(ArrayList<Integer> list, int key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.get(mid) < key) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

    public static int[] solution(String[] info, String[] query) {
        scoreMap = new HashMap<>();

        for (String str: info) {
            strings = new String[4];
            sInfoArr = str.split(" ");
            score = Integer.parseInt(sInfoArr[4]);
            dfs(0);
        }

        for (String key: scoreMap.keySet()) Collections.sort(scoreMap.get(key));

        int idx = 0;
        int[] answer = new int[query.length];
        for (String q: query) {
            String[] arr = q.split(" and | ");
            String str = arr[0] + arr[1] + arr[2] + arr[3];

            if (!scoreMap.containsKey(str)) answer[idx++] = 0;
            else answer[idx++] = scoreMap.get(str).size() - lowerBound(scoreMap.get(str), Integer.parseInt(arr[4]));
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(solution(info, query));
    }
}
