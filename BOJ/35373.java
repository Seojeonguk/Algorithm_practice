import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static final int SMALL_SIZE_PIZZA_COUNT = 6;
    static final int MEDIUM_SIZE_PIZZA_COUNT = 8;
    static final int LARGE_SIZE_PIZZA_COUNT = 12;


    public static void main(String[] args) throws Exception {
        int orderedPizzaCnt = Integer.parseInt(br.readLine());
        int remainedSmallPizza = 0;
        int remainedMediumPizza = 0;
        int remainedLargePizza = 0;

        for (int i = 0; i < orderedPizzaCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char size = st.nextToken().charAt(0);
            int pizza = Integer.parseInt(st.nextToken());

            if (size == 'S') {
                remainedSmallPizza += pizza;
            } else if (size == 'M') {
                remainedMediumPizza += pizza;
            } else if (size == 'L') {
                remainedLargePizza += pizza;
            }
        }

        int requiredBox = calculateRequiredBox(remainedSmallPizza, SMALL_SIZE_PIZZA_COUNT)
                          + calculateRequiredBox(remainedMediumPizza, MEDIUM_SIZE_PIZZA_COUNT)
                          + calculateRequiredBox(remainedLargePizza, LARGE_SIZE_PIZZA_COUNT);

        sb.append(requiredBox);

        bw.write(sb.toString());
        bw.flush();
    }

    public static int calculateRequiredBox(int totalRemainedPizza, int pizzaPerSize) {
        return (totalRemainedPizza + pizzaPerSize - 1) / pizzaPerSize;

    }
}
