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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int clothColorCnt = Integer.parseInt(st.nextToken());
            int clothGroupCnt = Integer.parseInt(st.nextToken());
            int washingMachineCapacity = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] groups = new ArrayList[clothGroupCnt];
            for (int i = 0; i < clothGroupCnt; i++) {
                groups[i] = new ArrayList<>();

                StringTokenizer cloths = new StringTokenizer(br.readLine());
                int groupClothColorCnt = Integer.parseInt(cloths.nextToken());

                for (int j = 0; j < groupClothColorCnt; j++) {
                    int clothColor = Integer.parseInt(cloths.nextToken());
                    groups[i].add(clothColor);
                }
            }

            StringTokenizer clothCnt = new StringTokenizer(br.readLine());
            int[] cloths = new int[clothColorCnt + 1];
            for (int i = 1; i <= clothColorCnt; i++) {
                cloths[i] = Integer.parseInt(clothCnt.nextToken());
            }

            int washingCnt = 0;
            for (ArrayList<Integer> group : groups) {
                int sum = 0;
                for (int clothColor : group) {
                    sum += cloths[clothColor];
                }

                washingCnt += (sum / washingMachineCapacity + (sum % washingMachineCapacity > 0 ? 1 : 0));
            }

            sb.append(washingCnt);

            bw.write(sb.toString());
        }
    }
}
