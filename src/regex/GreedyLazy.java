package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreedyLazy {
    public static void main(String[] args) {

        String text = "The (witch) and her (broom) are the one!";
        Pattern patternGreedy = Pattern.compile("\\(.+\\)");
        Matcher matcherGreedy = patternGreedy.matcher(text);
        while (matcherGreedy.find()){
            System.out.println("Greedy: " + matcherGreedy.group());
        }

        Pattern patternLazy = Pattern.compile("\\(.+?\\)");
        Matcher matcherLazy = patternLazy.matcher(text);
        while (matcherLazy.find()){
            System.out.println("Lazy: " + matcherLazy.group());
        }
    }
}
