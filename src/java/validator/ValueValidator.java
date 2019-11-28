package validator;

import java.util.regex.Pattern;

public class ValueValidator {
    private final String DOUBLE_REGEX_EXPRESSION = "[-+]?[\\d]*\\.?[\\d]+([eE][-+]?[\\d]+)?";
    public boolean isDouble(String value){
        return Pattern.matches(DOUBLE_REGEX_EXPRESSION, value);
    }
}
