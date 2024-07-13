import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int checkPersonCnt = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<String>> sameRings = new HashMap<>();
            for (int i = 0; i < checkPersonCnt; i++) {
                StringTokenizer checkPersons = new StringTokenizer(br.readLine());
                String name = checkPersons.nextToken();
                String ring = checkPersons.nextToken();

                if ("-".equals(ring)) {
                    continue;
                }

                if (!sameRings.containsKey(ring)) {
                    sameRings.put(ring, new ArrayList<>());
                }

                ArrayList<String> names = sameRings.get(ring);
                names.add(name);
            }

            ArrayList<String> couples = calCouples(sameRings);
            sb.append(couples.size()).append("\n");
            for (String names : couples) {
                String[] namesSplit = names.split("-");
                sb.append(namesSplit[0]).append(" ").append(namesSplit[1]).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static ArrayList<String> calCouples(HashMap<String, ArrayList<String>> sameRings) {
        ArrayList<String> couples = new ArrayList<>();
        for (String ring : sameRings.keySet()) {
            ArrayList<String> names = sameRings.get(ring);
            if (names.size() == 2) {
                String firstName = names.get(0);
                String secondName = names.get(1);

                couples.add(firstName + "-" + secondName);
            }
        }

        return couples;
    }
}
