import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fruit = Integer.parseInt(st.nextToken());
        int classNum = Integer.parseInt(st.nextToken());

        int[] maxClassNum = new int[classNum];
        for (int i = 0; i < fruit; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < classNum; j++) {
                int likeFruit = Integer.parseInt(st.nextToken());
                maxClassNum[j] = Math.max(maxClassNum[j], likeFruit);
            }
        }

        int sum = 0;
        for (int j = 0; j < classNum; j++) {
            sum += maxClassNum[j];
        }

        sb.append(sum);

        bw.write(sb.toString());
        bw.flush();
    }
}
