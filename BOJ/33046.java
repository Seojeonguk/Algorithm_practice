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

            StringTokenizer firstDice = new StringTokenizer(br.readLine());
            int firstDice1 = Integer.parseInt(firstDice.nextToken());
            int firstDice2 = Integer.parseInt(firstDice.nextToken());

            StringTokenizer secondDice = new StringTokenizer(br.readLine());
            int secondDice1 = Integer.parseInt(secondDice.nextToken());
            int secondDice2 = Integer.parseInt(secondDice.nextToken());

            sb.append(((firstDice1 + firstDice2 + secondDice1 + secondDice2 - 2) % 4) + 1);

            bw.write(sb.toString());
        }
    }
}
