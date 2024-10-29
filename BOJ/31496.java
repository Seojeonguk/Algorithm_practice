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

            int itemCategoryCnt = Integer.parseInt(st.nextToken());
            String word = st.nextToken();

            int deletedItemCnt = 0;
            for (int i = 0; i < itemCategoryCnt; i++) {
                StringTokenizer itemInfo = new StringTokenizer(br.readLine());
                String itemName = itemInfo.nextToken();
                int itemCnt = Integer.parseInt(itemInfo.nextToken());

                String[] nameDividers = itemName.split("_");

                for (String str : nameDividers) {
                    if (str.equals(word)) {
                        deletedItemCnt += itemCnt;
                        break;
                    }
                }
            }

            sb.append(deletedItemCnt);

            bw.write(sb.toString());
        }
    }
}
