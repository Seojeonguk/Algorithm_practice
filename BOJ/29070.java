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
            int plateHeight = Integer.parseInt(st.nextToken());
            int plateWidth = Integer.parseInt(st.nextToken());

            int holeHeight = Integer.parseInt(st.nextToken());
            int holeWidth = Integer.parseInt(st.nextToken());

            int neededHeight = (holeHeight + plateHeight - 1) / plateHeight;
            int neededWidth = (holeWidth + plateWidth - 1) / plateWidth;

            sb.append(neededHeight * neededWidth);

            bw.write(sb.toString());
        }
    }
}
