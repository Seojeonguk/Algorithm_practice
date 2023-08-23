import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int lienCnt = Integer.parseInt(br.readLine());

        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < lienCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Line line = new Line(x, y);
            lines.add(line);
        }

        Collections.sort(lines, (o1, o2) -> {
            if (o1.x == o2.x) return Integer.compare(o1.y, o2.y);
            return Integer.compare(o1.x, o2.x);
        });

        int start = -1000000001;
        int end = start;
        int totalLength = 0;
        HashSet<Integer> calculatedStart = new HashSet<>();
        for (int i = 0; i < lienCnt; i++) {
            int x = lines.get(i).x;
            int y = lines.get(i).y;

            if (end < x) {
                totalLength += end - start;
                calculatedStart.add(start);
                start = x;
                end = y;

            } else {
                end = Math.max(end, y);
            }
        }
        if (!calculatedStart.contains(start)) {
            totalLength += end - start;
        }
        sb.append(totalLength);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Line {
        int x;
        int y;

        Line(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
