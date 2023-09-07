import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String NO_ANSWER = "Tie";
    final static Map<String, Integer> COW_INFORMATION = Map.of(
            "Bessie", 0,
            "Elsie", 1,
            "Daisy", 2,
            "Gertie", 3,
            "Annabelle", 4,
            "Maggie", 5,
            "Henrietta", 6
    );

    public static void main(String[] args) throws Exception {
        int logCnt = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[COW_INFORMATION.size()];
        Iterator<String> it = COW_INFORMATION.keySet().iterator();
        while (it.hasNext()) {
            String name = it.next();
            int idx = COW_INFORMATION.get(name);
            cows[idx] = new Cow(name, 0);
        }
        for (int log = 0; log < logCnt; log++) {
            st = new StringTokenizer(br.readLine());
            String cowName = st.nextToken();
            int milk = Integer.parseInt(st.nextToken());

            cows[COW_INFORMATION.get(cowName)].addMilk(milk);
        }

        Arrays.sort(cows, (o1, o2) -> {
            return Integer.compare(o1.milk, o2.milk);
        });

        String secondCow = getSecondCow(cows);
        sb.append(secondCow);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String getSecondCow(Cow[] cows) {
        int secondMilk = -1;
        for (int idx = 0; idx < cows.length; idx++) {
            if (cows[idx].getMilk() != cows[0].getMilk()) {
                secondMilk = cows[idx].getMilk();
                break;
            }
        }

        ArrayList<String> candidateSecondCows = new ArrayList<>();
        for (int idx = 0; idx < cows.length; idx++) {
            if (cows[idx].getMilk() == secondMilk) {
                candidateSecondCows.add(cows[idx].getName());
            }
        }

        if (candidateSecondCows.size() != 1) {
            return NO_ANSWER;
        }
        return candidateSecondCows.get(0);
    }

    static class Cow {
        String name;
        int milk;

        Cow(String name, int milk) {
            this.name = name;
            this.milk = milk;
        }

        public void addMilk(int milk) {
            this.milk += milk;
        }

        public int getMilk() {
            return this.milk;
        }

        public String getName() {
            return this.name;
        }
    }
}
