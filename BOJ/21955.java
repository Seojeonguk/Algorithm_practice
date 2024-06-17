import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] toldMother = br.readLine().toCharArray();
            int halfLength = toldMother.length / 2;
            sb.append(toldMother, 0, halfLength)
                    .append(" ")
                    .append(toldMother, halfLength, halfLength);

            bw.write(sb.toString());
        }
    }
}
