import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String a = br.readLine();
            String b = br.readLine();

            if ("null".equals(a)) {
                sb.append("NullPointerException")
                        .append("\n")
                        .append("NullPointerException");
            } else {
                if("null".equals(b) || !a.equals(b)) {
                    sb.append("false");
                } else {
                    sb.append("true");
                }
                sb.append("\n");
                if("null".equals(b) || !a.equalsIgnoreCase(b)) {
                    sb.append("false");
                } else {
                    sb.append("true");
                }
            }

            bw.write(sb.toString());
        }
    }
}
