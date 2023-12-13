import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int groupCnt = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        int[] groupPeople = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int currentCapacity = 0, group = 0;
        for (int i = 0; i < groupPeople.length; i++) {
            if (currentCapacity + groupPeople[i] > capacity) {
                group++;
                currentCapacity = groupPeople[i];
            } else {
                currentCapacity += groupPeople[i];
            }
            sb.append(group).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
