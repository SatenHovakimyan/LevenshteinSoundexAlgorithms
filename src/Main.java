import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Enter a word for getting its Soundex index(or 'exit' to quit): ");
//            String word = scanner.nextLine();
//            if(word.equalsIgnoreCase("exit")) {
//                break;
//            }
//            System.out.println("Soundex index of " + word + "is: " + SoundexAlgorithm.soundex(word));
//        }
//        scanner.close();

        System.out.println(LevenshteinAlgorithm.calculateDistanceOfLevenshtein("saturday", "sunday"));
        System.out.println(LevenshteinAlgorithm.calculateDistanceOfLevenshtein("rainy", "sunny"));
        System.out.println(LevenshteinAlgorithm.calculateDistanceOfLevenshtein("intention", "execution"));
    }
}