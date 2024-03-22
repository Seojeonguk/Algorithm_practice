import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        sb.append(str.contains("ooo") ? "Yes" : "No");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
