import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int pinkCost = Integer.parseInt(br.readLine());
        int greenCost = Integer.parseInt(br.readLine());
        int redCost = Integer.parseInt(br.readLine());
        int orangeCost = Integer.parseInt(br.readLine());
        int sellingTickets = Integer.parseInt(br.readLine());

        ArrayList<int[]> combinations = new ArrayList<>();
        int smallestTickets = Integer.MAX_VALUE;
        for (int pink = 0; pink * pinkCost <= sellingTickets; pink++) {
            int pinkSum = pink * pinkCost;
            for (int green = 0; green * greenCost <= sellingTickets; green++) {
                int greenSum = green * greenCost;
                if (pinkSum + greenSum > sellingTickets) {
                    break;
                }
                for (int red = 0; red * redCost <= sellingTickets; red++) {
                    int redSum = red * redCost;
                    if (pinkSum + greenSum + redSum > sellingTickets) {
                        break;
                    }
                    for (int orange = 0; orange * orangeCost <= sellingTickets; orange++) {
                        int orangeSum = orange * orangeCost;
                        int totalSum = pinkSum + greenSum + redSum + orangeSum;
                        if (totalSum > sellingTickets) {
                            break;
                        }
                        if (totalSum == sellingTickets) {
                            combinations.add(new int[]{pink, green, red, orange});
                            smallestTickets = Math.min(smallestTickets, pink + green + red + orange);
                        }
                    }
                }
            }
        }

        for (int[] combination : combinations) {
            sb.append(String.format("# of PINK is %d # of GREEN is %d # of RED is %d # of ORANGE is %d\n", combination[0], combination[1], combination[2], combination[3]));
        }
        sb.append(String.format("Total combinations is %d.\n", combinations.size()));
        sb.append(String.format("Minimum number of tickets to print is %d.\n", smallestTickets));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
