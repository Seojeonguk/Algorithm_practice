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

            StringTokenizer fruit = new StringTokenizer(br.readLine());
            int apple = Integer.parseInt(fruit.nextToken());
            int banana = Integer.parseInt(fruit.nextToken());

            int minFruit = Math.min(apple, banana);
            for (int friend = 1; friend <= minFruit; friend++) {
                if (apple % friend > 0 || banana % friend > 0) {
                    continue;
                }

                sb.append(friend).append(" ")
                        .append(apple / friend).append(" ")
                        .append(banana / friend).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
