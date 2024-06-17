import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int startBottle = Integer.parseInt(br.readLine());

            for (int bottle = startBottle; bottle >= 0; bottle--) {
                int prev = (bottle > 0 ? bottle - 1 : startBottle);
                sb.append(bottle > 0 ? bottle : "No more").append(" ")
                        .append(bottle == 1 ? "bottle" : "bottles").append(" ")
                        .append("of beer on the wall, ")
                        .append(bottle > 0 ? bottle : "no more").append(" ")
                        .append(bottle == 1 ? "bottle" : "bottles").append(" ")
                        .append("of beer.").append("\n")
                        .append(bottle > 0 ? "Take one down and pass it around," : "Go to the store and buy some more,").append(" ")
                        .append(bottle == 1 ? "no more" : prev).append(" ")
                        .append(prev == 1 ? "bottle" : "bottles").append(" ")
                        .append("of beer on the wall.\n\n");
            }

            bw.write(sb.toString());
        }
    }
}
