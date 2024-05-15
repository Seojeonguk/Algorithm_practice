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
            int behaviorCnt = Integer.parseInt(st.nextToken());
            int cartridgeCnt = Integer.parseInt(st.nextToken());

            int lastSaveCartridge = 0;
            int currentCartridge = 0;
            for (int behaviorNum = 0; behaviorNum < behaviorCnt; behaviorNum++) {
                String behavior = br.readLine();

                if ("save".equals(behavior)) {
                    lastSaveCartridge = currentCartridge;
                } else if ("load".equals(behavior)) {
                    currentCartridge = lastSaveCartridge;
                } else if ("shoot".equals(behavior)) {
                    if (currentCartridge > 0) {
                        currentCartridge--;
                    }
                } else if ("ammo".equals(behavior)) {
                    currentCartridge += cartridgeCnt;
                }

                sb.append(currentCartridge).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
