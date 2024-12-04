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
            int startPage = Integer.parseInt(st.nextToken());
            int endPage = Integer.parseInt(st.nextToken());

            int takePictureCnt = 0;
            if (startPage % 2 == 0) {
                takePictureCnt++;
                startPage++;
            }

            if (endPage % 2 == 1) {
                takePictureCnt++;
                endPage--;
            }

            takePictureCnt += (endPage - startPage + 1) / 2;

            sb.append(takePictureCnt);

            bw.write(sb.toString());
        }
    }
}
