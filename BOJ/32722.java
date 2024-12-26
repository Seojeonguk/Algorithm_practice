import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());

            sb.append(isPossible(a, b, c) ? "JAH" : "EI");

            bw.write(sb.toString());
        }
    }

    public static boolean isPossible(int a, int b, int c) {
        return ((a == 1 || a == 3) && (b == 6 || b == 8) && (c == 2 || c == 5));
    }
}
