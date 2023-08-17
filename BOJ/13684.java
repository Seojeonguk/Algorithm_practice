import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            int queryCnt = Integer.parseInt(br.readLine());
            if (queryCnt == 0) {
                break;
            }
            st = new StringTokenizer(br.readLine());
            int standardX = Integer.parseInt(st.nextToken());
            int standardY = Integer.parseInt(st.nextToken());

            Position standardPosition = new Position(standardX, standardY);

            for (int i = 0; i < queryCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int residenceX = Integer.parseInt(st.nextToken());
                int residenceY = Integer.parseInt(st.nextToken());

                Position residence = new Position(residenceX, residenceY);

                sb.append(standardPosition.compareQuadrant(residence)).append("\n");
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Position {
        private int x;
        private int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String compareQuadrant(Position o) {
            String quadrant = "";
            if (this.x == o.x || this.y == o.y) {
                quadrant = "divisa";
            } else {
                if (this.x < o.x) {
                    if (this.y < o.y) {
                        quadrant = "NE";
                    } else {
                        quadrant = "SE";
                    }
                } else if (this.x > o.x) {
                    if (this.y < o.y) {
                        quadrant = "NO";
                    } else {
                        quadrant = "SO";
                    }
                }
            }

            return quadrant;
        }
    }
}
