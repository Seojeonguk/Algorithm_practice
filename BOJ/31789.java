import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int sellingWeaponCnt = Integer.parseInt(br.readLine());

            String[] str = br.readLine().split(" ");
            int money = Integer.parseInt(str[0]);
            int damage = Integer.parseInt(str[1]);

            int maxWeaponDamage = 0;
            for (int weaponNum = 1; weaponNum <= sellingWeaponCnt; weaponNum++) {
                String[] weapons = br.readLine().split(" ");
                int weaponCost = Integer.parseInt(weapons[0]);
                int weaponDamage = Integer.parseInt(weapons[1]);

                if (money >= weaponCost) {
                    maxWeaponDamage = Math.max(maxWeaponDamage, weaponDamage);
                }
            }

            sb.append(maxWeaponDamage > damage ? "YES" : "NO");

            bw.write(sb.toString());
        }
    }
}
