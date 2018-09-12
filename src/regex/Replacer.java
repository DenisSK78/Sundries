package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacer {
    public static void main(String[] args) {

        String text = "jgjhghj 4324 32424 kjh 34 jljk";
        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()){
            matcher.appendReplacement(stringBuffer, "#");
            //adds all before match and replace mach, do all steps if we have matches in string
        }
        matcher.appendTail(stringBuffer);
        //add all what don't match with pattern: " jljk"
        System.out.println(stringBuffer);
    }
}
