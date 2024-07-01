import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int treeCnt = Integer.parseInt(br.readLine());
            int[] treeCategories = new int[treeCnt];

            StringTokenizer categories = new StringTokenizer(br.readLine());
            ArrayList<Integer> apples = new ArrayList<>();
            ArrayList<Integer> pears = new ArrayList<>();
            for (int i = 0; i < treeCnt; i++) {
                treeCategories[i] = Integer.parseInt(categories.nextToken());
                if (treeCategories[i] == 0) {
                    pears.add(i);
                } else {
                    apples.add(i);
                }
            }

            sb.append(getMaxDiff(apples, pears));

            bw.write(sb.toString());
        }
    }

    public static int getMaxDiff(ArrayList<Integer> apples, ArrayList<Integer> pears) {
        int firstDiff = Math.abs(apples.get(0) - pears.get(pears.size() - 1));
        int secondDiff = Math.abs(apples.get(apples.size() - 1) - pears.get(0));

        return Math.max(firstDiff, secondDiff);
    }
}
