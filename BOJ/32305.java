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

            int applePerBag = Integer.parseInt(st.nextToken());
            int chooseBag = Integer.parseInt(st.nextToken());
            int pricePer12Apple = Integer.parseInt(br.readLine());

            sb.append(((applePerBag * chooseBag + 11) / 12) * pricePer12Apple);

            bw.write(sb.toString());
        }
    }
}
