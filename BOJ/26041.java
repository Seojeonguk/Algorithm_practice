import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String[] splittedStrings = br.readLine().split(" ");
            String phoneNumber = br.readLine();

            int cnt = 0;
            for (String str : splittedStrings) {
                if (!phoneNumber.equals(str) && str.startsWith(phoneNumber)) {
                    cnt++;
                }
            }

            sb.append(cnt);

            bw.write(sb.toString());
        }
    }
}
