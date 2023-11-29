public class LevenshteinAlgorithm {

    private static void printMatrix(int[][] matrix, String firstWord, String secondWord) {
        System.out.println("Matrix:");
        System.out.print("      ");
        for (char c : firstWord.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.print("    ");
        for (int j = 0; j <= firstWord.length(); j++) {
            System.out.print(matrix[0][j] + " ");
        }
        System.out.println();
        for (int i = 1; i <= secondWord.length(); i++) {
            System.out.print(secondWord.charAt(i - 1) + "   " + matrix[i][0] + " ");
            for (int j = 1; j <= firstWord.length(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int calculateDistanceOfLevenshtein(String firstWord, String secondWord) {
        int columns = firstWord.length();
        int rows = secondWord.length();
        int[][] matrixLevenshtein = new int[rows + 1][columns + 1];

        for (int i = 0; i <= rows; i++) {
            matrixLevenshtein[i][0] = i;
        }
        for (int j = 0; j <= columns; j++) {
            matrixLevenshtein[0][j] = j;
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                int diffCost = (firstWord.charAt(j - 1) == secondWord.charAt(i - 1)) ? 0 : 1;
                matrixLevenshtein[i][j] = Math.min(Math.min(matrixLevenshtein[i][j - 1] + 1, matrixLevenshtein[i - 1][j] + 1), matrixLevenshtein[i - 1][j - 1] + diffCost);
            }
        }
        printMatrix(matrixLevenshtein, firstWord, secondWord);
        return matrixLevenshtein[rows][columns];
    }
}
