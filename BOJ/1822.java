import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer arrayInfo = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(arrayInfo.nextToken());
        int bSize = Integer.parseInt(arrayInfo.nextToken());

        TreeSet<Integer> relativeComplements = new TreeSet<>();
        StringTokenizer aInfo = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            int aValue = Integer.parseInt(aInfo.nextToken());
            relativeComplements.add(aValue);
        }

        StringTokenizer bInfo = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            int bValue = Integer.parseInt(bInfo.nextToken());
            if (relativeComplements.contains(bValue)) {
                relativeComplements.remove(bValue);
            }
        }

        sb.append(relativeComplements.size()).append("\n");
        for (int relativeComplement : relativeComplements) {
            sb.append(relativeComplement).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
