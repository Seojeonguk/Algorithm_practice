import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static final Map<Character, Integer> NOTE = new HashMap<>() {
        {
            put('W', 64);
            put('H', 32);
            put('Q', 16);
            put('E', 8);
            put('S', 4);
            put('T', 2);
            put('X', 1);
        }
    };

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if ("*".equals(str)) {
                break;
            }

            int rightCnt = 0;
            String[] notes = str.split("/");
            for (String note : notes) {
                int noteSum = 0;
                for (int i = 0; i < note.length(); i++) {
                    noteSum += NOTE.get(note.charAt(i));
                }
                if (noteSum == 64) {
                    rightCnt++;
                }
            }

            sb.append(rightCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
