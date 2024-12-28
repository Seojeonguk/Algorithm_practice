import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int LIMIT_NUM = 100000;
    static final int ANNIVERSARY = 2024;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();


            int year = Integer.parseInt(br.readLine());

            sb.append(isMemorialNum(year) ? "Yes" : "No");

            bw.write(sb.toString());
        }
    }

    public static boolean isMemorialNum(int year) {
        return (year <= LIMIT_NUM && (year % ANNIVERSARY == 0));
    }
}
