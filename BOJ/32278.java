import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final long[][] DATA_TYPE_RANGES = {
            {Short.MIN_VALUE, Short.MAX_VALUE},
            {Integer.MIN_VALUE, Integer.MAX_VALUE},
            {Long.MIN_VALUE, Long.MAX_VALUE}
    };

    static final String[] DATA_TYPE_NAMES = {
            "short",
            "int",
            "long long"
    };

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            long n = Long.parseLong(br.readLine());

            for (int i = 0; i < DATA_TYPE_RANGES.length; i++) {
                if (DATA_TYPE_RANGES[i][0] <= n && n <= DATA_TYPE_RANGES[i][1]) {
                    sb.append(DATA_TYPE_NAMES[i]);
                    break;
                }
            }

            bw.write(sb.toString());
        }
    }
}
