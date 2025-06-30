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
            int xRepunitLength = Integer.parseInt(st.nextToken());
            int yRepunitLength = Integer.parseInt(st.nextToken());

            int xRepunit = makeRepunit(xRepunitLength);
            int yRepunit = makeRepunit(yRepunitLength);

            sb.append(xRepunit + yRepunit);

            bw.write(sb.toString());
        }
    }

    public static int makeRepunit(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append('1');
        }

        return Integer.parseInt(sb.toString());
    }
}
