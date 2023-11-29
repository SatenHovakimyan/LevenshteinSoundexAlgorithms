import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Get Soundex index of a word");
            System.out.println("2. Calculate Levenshtein distance between two words");
            System.out.println("Type 'exit' to quit.");

            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("exit")) {
                break;
            }

            switch (option) {
                case "1":
                    System.out.println("Enter a word to get its Soundex index: ");
                    String soundexWord = scanner.nextLine();
                    System.out.println("Soundex index of " + soundexWord + " is: " + SoundexAlgorithm.soundex(soundexWord));
                    break;

                case "2":
                    System.out.println("Enter two words to calculate Levenshtein distance:");
                    System.out.print("First word: ");
                    String firstWord = scanner.nextLine().toUpperCase();
                    System.out.print("Second word: ");
                    String secondWord = scanner.nextLine().toUpperCase();
                    int levenshteinDistance = LevenshteinAlgorithm.calculateDistanceOfLevenshtein(firstWord, secondWord);
                    System.out.println("Levenshtein distance between " + firstWord + " and " + secondWord + " is: " + levenshteinDistance);
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }

            System.out.println();
        }

        System.out.println("Exiting the program.");
        scanner.close();
    }
}
