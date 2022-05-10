package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUtils {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";

    public String[] splitByDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_PATTERN).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return split(matcher.group(2), customDelimiter);
        }
        return splitByDefaultDelimiter(input);
    }

    public String[] splitByDefaultDelimiter(String input) {
        return split(input, DEFAULT_DELIMITER);
    }

    private String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

}
