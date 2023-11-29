public class LevenshteinAlgorithm {
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
//            for (int j = 1; j <= columns; j++) {
//                if(firstWord.charAt(j - 1) == secondWord.charAt(i - 1)) {
//                    matrixLevenshtein[i][j] = matrixLevenshtein[i - 1][j - 1];
//                } else {
//                    matrixLevenshtein[i][j] = Math.min(Math.min(matrixLevenshtein[i][j - 1], matrixLevenshtein[i - 1][j]), matrixLevenshtein[i - 1][j - 1]) + 1;
//                }
//            }

            for (int j = 1; j <= columns; j++) {
                int diffCost = (firstWord.charAt(j - 1) == secondWord.charAt(i - 1)) ? 0 : 1;
                matrixLevenshtein[i][j] = Math.min(Math.min(matrixLevenshtein[i][j - 1] + 1, matrixLevenshtein[i - 1][j] + 1), matrixLevenshtein[i - 1][j - 1] + diffCost);
            }
        }

        return matrixLevenshtein[rows][columns];
    }


}
