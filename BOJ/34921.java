import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer info = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(info.nextToken());
            int tier = Integer.parseInt(info.nextToken());

            bw.write(String.valueOf(calP(age, tier)));
            bw.flush();
        }
    }

    public static int calP(int age, int tier) {
        return Math.max(0, 10 + 2 * (25 - age + tier));
    }
}
