import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int totalCommand = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<String>> hm = new HashMap<>();

            for (int commandNum = 0; commandNum < totalCommand; commandNum++) {
                String[] objects = br.readLine().split(" is ");
                if (!hm.containsKey(objects[0])) {
                    ArrayList<String> arr = new ArrayList<>();
                    hm.put(objects[0], arr);
                }

                hm.get(objects[0]).add(objects[1]);
            }

            ArrayList<String> arr = new ArrayList<>();
            HashSet<String> visited = new HashSet<>();
            solve("Baba", arr, hm, visited);

            Collections.sort(arr);

            for (String str : arr) {
                sb.append(str).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static void solve(String str, ArrayList<String> arr, HashMap<String, ArrayList<String>> hm, HashSet<String> visited) {
        if (!hm.containsKey(str)) {
            return;
        }

        for (String next : hm.get(str)) {
            if (visited.contains(next)) {
                continue;
            }

            visited.add(next);
            arr.add(next);
            solve(next, arr, hm, visited);
        }
    }
}
