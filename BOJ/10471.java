import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int partitionCnt = Integer.parseInt(st.nextToken());

            ArrayList<Integer> partitions = new ArrayList<>();
            partitions.add(0);
            StringTokenizer partitionPlace = new StringTokenizer(br.readLine());
            for (int i = 0; i < partitionCnt; i++) {
                int partition = Integer.parseInt(partitionPlace.nextToken());
                partitions.add(partition);
            }
            partitions.add(width);

            TreeSet<Integer> possibleRoomSizes = new TreeSet<>();
            for (int i = 0; i < partitionCnt + 2; i++) {
                for (int j = i + 1; j < partitionCnt + 2; j++) {
                    possibleRoomSizes.add(Math.abs(partitions.get(i) - partitions.get(j)));
                }
            }

            for (int possibleRoomSize : possibleRoomSizes) {
                sb.append(possibleRoomSize).append(" ");
            }

            bw.write(sb.toString());
        }
    }
}
