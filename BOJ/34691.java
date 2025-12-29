import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Main {

    private final static Map<String, String> SCIENTIFIC_NAMES = Map.of(
            "animal", "Panthera tigris",
            "tree", "Pinus densiflora",
            "flower", "Forsythia koreana"
    );
    private final static String END_STR = "end";

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder sb = new StringBuilder();
            while (true) {
                String type = br.readLine();

                if (type.compareTo(END_STR) == 0) {
                    break;
                }

                sb.append(SCIENTIFIC_NAMES.get(type)).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
