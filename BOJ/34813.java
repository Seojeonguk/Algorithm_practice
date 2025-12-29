import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Main {

    private static final Map<String, String> SUBJECT_NAMES = Map.of(
            "F", "Foundation",
            "C", "Claves",
            "V", "Veritas",
            "E", "Exploration"
    );

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String subjectName = br.readLine();
            for (Map.Entry<String, String> entry : SUBJECT_NAMES.entrySet()) {
                if (subjectName.startsWith(entry.getKey())) {
                    bw.write(entry.getValue());
                }
            }

            bw.flush();
        }
    }
}
