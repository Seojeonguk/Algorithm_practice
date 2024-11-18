import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int cookingIngredientCnt = Integer.parseInt(br.readLine());

            String[] requiredIngredients = br.readLine().split(" ");
            HashSet<String> preparedIngredients = new HashSet<>(Arrays.asList(br.readLine().split(" ")));
            
            for (String ingredient : requiredIngredients) {
                if (!preparedIngredients.contains(ingredient)) {
                    sb.append(ingredient);
                    break;
                }
            }

            bw.write(sb.toString());
        }
    }
}
