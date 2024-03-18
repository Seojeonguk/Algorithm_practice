import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        ArrayList<Integer> cubes = new ArrayList<>();
        for (int i = 1; i * i * i <= end; i++) {
            if (i * i * i >= start) {
                cubes.add(i * i * i);
            }
        }

        int coolNumCnt = 0;
        for (int i = 1; i * i <= end; i++) {
            if (i * i >= start) {
                if (cubes.contains(i * i)) {
                    coolNumCnt++;
                }
            }
        }

        sb.append(coolNumCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
