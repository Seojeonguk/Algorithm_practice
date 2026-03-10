import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        int totalSecond = Integer.parseInt(br.readLine());
        int minute = totalSecond % 3600 / 60;

        sb.append(60 - minute);

        bw.write(sb.toString());
        bw.flush();
    }
}
