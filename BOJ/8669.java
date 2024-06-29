import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int treeCnt = Integer.parseInt(br.readLine());
            HashSet<Integer> treeCategories = new HashSet<>();

            for (int i = 0; i < treeCnt; i++) {
                StringTokenizer tree = new StringTokenizer(br.readLine());
                int thickness = Integer.parseInt(tree.nextToken());
                int category = Integer.parseInt(tree.nextToken());

                treeCategories.add(category);
            }

            sb.append(treeCategories.size());

            bw.write(sb.toString());
        }
    }
}
