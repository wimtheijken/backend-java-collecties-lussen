import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {

        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber = setToStringConverter(secretnumber);
        System.out.println(stringnumber);
        feedback(stringnumber);
    }

    public static HashSet<Integer> randomnumbergenerator(){
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 4) {
            int int_random = random.nextInt(10);
            set.add(int_random);
            System.out.println(set);
        }
        return set;
    }

    public static String setToStringConverter(HashSet<Integer> secretnumber){
           String numberToString = "";
        for (int number : secretnumber){
            numberToString += number;
                    System.out.println(numberToString);
        }
        return numberToString;
    }

    public static void feedback(String stringnumber) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder feedback = new StringBuilder();
        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        System.out.println("Doe een gok, Let op vul 4 getallen in.");
        while (true) {
            String guess = scanner.nextLine();
            feedback.delete(0,9);
            if (Objects.equals(guess, stringnumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
                break;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
                feedback.append(" -> bijna! Kijk naar de feedback en probeer het nog eens...");
            }
            System.out.println(feedback.toString());
        }
    }
}

// De setHash is geen goed keuze in dit geval omdat de setHash de cijfer in oplopende waarde sorteert!!!