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

            int drawnPictureCnt = Integer.parseInt(br.readLine());
            int[] drawnPictures = new int[drawnPictureCnt];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < drawnPictureCnt; i++) {
                drawnPictures[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(existAllShape(drawnPictures) ? "TAK" : "NIE");

            bw.write(sb.toString());
        }
    }

    public static boolean existAllShape(int[] drawnPictures) {
        for (int i = 0; i < drawnPictures.length - 2; i++) {
            if (drawnPictures[i] != drawnPictures[i + 1] && drawnPictures[i] != drawnPictures[i + 2] && drawnPictures[i + 1] != drawnPictures[i + 2]) {
                return true;
            }
        }

        return false;
    }
}
