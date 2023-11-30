import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        PriorityQueue<Obb> o = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.a, o2.a);
        });
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                o.add(new Obb(a, (char) ('A' + i)));
            }
        }

        while (!o.isEmpty()) {
            sb.append(o.poll().c);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Obb {
        int a;
        char c;

        public Obb(int a, char c) {
            this.a = a;
            this.c = c;
        }
    }
}
