import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX_YOUTUBER = 100;
    final static int MIN_REAL_VIRTUAL_YOUTUBER_CNT = 5;
    final static int MIN_REAL_VIRTUAL_YOUTUBER_TIME = 60 * 60;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int broadCastCnt = Integer.parseInt(st.nextToken());
        int lastDay = Integer.parseInt(st.nextToken());

        Map<String, Integer> youtubers = new HashMap<>();
        int[][] broadCastingCnt = new int[MAX_YOUTUBER][lastDay / 7];
        int[][] broadCastingTime = new int[MAX_YOUTUBER][lastDay / 7];

        while (broadCastCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int broadCastDay = Integer.parseInt(st.nextToken());
            int startTime = convertToMinutes(st.nextToken());
            int endTime = convertToMinutes(st.nextToken());

            int broadCastTime = endTime - startTime;

            if (!youtubers.containsKey(name)) {
                youtubers.put(name, youtubers.size());
            }

            int youtuberIdx = youtubers.get(name);
            broadCastingCnt[youtuberIdx][(broadCastDay - 1) / 7]++;
            broadCastingTime[youtuberIdx][(broadCastDay - 1) / 7] += broadCastTime;
        }

        PriorityQueue<String> realVirtualYoutubers = new PriorityQueue<>();
        Iterator<String> it = youtubers.keySet().iterator();
        while (it.hasNext()) {
            String name = it.next();
            int youtuberIdx = youtubers.get(name);

            boolean isRealVirtualYoutuber = true;
            for (int i = 0; i < lastDay / 7; i++) {
                if (broadCastingCnt[youtuberIdx][i] < MIN_REAL_VIRTUAL_YOUTUBER_CNT || broadCastingTime[youtuberIdx][i] < MIN_REAL_VIRTUAL_YOUTUBER_TIME) {
                    isRealVirtualYoutuber = false;
                    break;
                }
            }
            if (isRealVirtualYoutuber) {
                realVirtualYoutubers.add(name);
            }
        }

        if (realVirtualYoutubers.isEmpty()) {
            sb.append("-1");
        }
        while (!realVirtualYoutubers.isEmpty()) {
            sb.append(realVirtualYoutubers.poll()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int convertToMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        int totalMinutes = hours * 60 + minutes;
        return totalMinutes;
    }
}
