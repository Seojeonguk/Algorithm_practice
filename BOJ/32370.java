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
        int pawnAX = Integer.parseInt(st.nextToken());
        int pawnAY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int pawnBX = Integer.parseInt(st.nextToken());
        int pawnBY = Integer.parseInt(st.nextToken());

        if (pawnAX == 0) {
            sb.append(pawnBX == 0 && pawnAY > pawnBY ? 3 : 1);
        } else if (pawnAY == 0) {
            sb.append(pawnBY == 0 && pawnAX > pawnBX ? 3 : 1);
        } else {
            sb.append(2);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
