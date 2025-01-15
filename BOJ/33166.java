import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int initDistance = Integer.parseInt(st.nextToken());
            int moveDistance = Integer.parseInt(st.nextToken());

            StringTokenizer costs = new StringTokenizer(br.readLine());

            int initCost = Integer.parseInt(costs.nextToken());
            int moveCost = Integer.parseInt(costs.nextToken());

            int realMovedInitDistance = Math.min(initDistance, moveDistance);

            sb.append(realMovedInitDistance * initCost + (moveDistance - realMovedInitDistance) * moveCost);

            bw.write(sb.toString());
        }
    }
}
