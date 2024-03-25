import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        TreeSet<String> ts = new TreeSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() - 1; j++) {
                StringBuilder a = new StringBuilder(str.substring(0, i + 1));
                StringBuilder b = new StringBuilder(str.substring(i + 1, j + 1));
                StringBuilder c = new StringBuilder(str.substring(j + 1));

                ts.add(a.reverse().append(b.reverse()).append(c.reverse()).toString());
            }
        }

        sb.append(ts.pollFirst());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
