package insuranceComp.utility;

import java.util.Random;

public class IdGenerator {
    private static Random rand = new Random();


    public static String generateClientId() {
        String numberAsString = "";
        for (int i = 0; i < 8; i++) {
            int n = rand.nextInt(10);
            numberAsString = numberAsString + n;
        }

        return numberAsString;
    }

    public static String generateEmployeeId() {
        String numberAsString = "E";
        for (int i = 0; i < 5; i++) {
            int n = rand.nextInt(10);
            numberAsString = numberAsString + n;
        }

        return numberAsString;
    }

}
