import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final String[] LEADERS = {"Joffrey", "Robb", "Stannis"};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] units = new int[3];
            for (int i = 0; i < 3; i++) {
                units[i] = Integer.parseInt(st.nextToken());
            }

            int[] members = new int[3];
            for (int i = 0; i < 3; i++) {
                members[i] = Integer.parseInt(st.nextToken());
            }

            int strongestArmy = 0;
            for (int i = 0; i < 3; i++) {
                strongestArmy = Math.max(strongestArmy, units[i] * members[i]);
            }

            for (int i = 0; i < 3; i++) {
                if (units[i] * members[i] == strongestArmy) {
                    sb.append(LEADERS[i]).append(" ");
                }
            }


            bw.write(sb.toString());
        }
    }
}
