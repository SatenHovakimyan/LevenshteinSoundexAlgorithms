public class SoundexAlgorithm {
    public static String soundex(String word) {
        if(word == null || word.isEmpty() || word.matches(".*[\\s\\p{Punct}].*")) {
            System.out.println("This word is empty or contains punctuation or spaces");
            return "";
        }
        word = word.toUpperCase();
        //word = word.replaceAll("[^A-Z]", "");
        char firstLetter = word.charAt(0);

        word = word.replaceAll("[AEIOUHWY]", "0");
        word = word.replaceAll("[BFPV]", "1");
        word = word.replaceAll("[CGJKQSXZ]", "2");
        word = word.replaceAll("[DT]", "3");
        word = word.replaceAll("L", "4");
        word = word.replaceAll("[MN]", "5");
        word = word.replaceAll("R", "6");

        StringBuilder soundexBuilder = new StringBuilder();
        soundexBuilder.append(firstLetter);
        for (int i = 1; i < word.length(); i++) {
            if((word.charAt(i) != word.charAt(i - 1)) && word.charAt(i) != '0') {
                soundexBuilder.append(word.charAt(i));
            }
        }
        if(soundexBuilder.length() < 4) {
            soundexBuilder.append("0".repeat(Math.max(0, 4 - soundexBuilder.length())));
        } else if(soundexBuilder.length() > 4) {
            soundexBuilder.delete(5, soundexBuilder.length());
        }
        return soundexBuilder.toString();
    }
}
