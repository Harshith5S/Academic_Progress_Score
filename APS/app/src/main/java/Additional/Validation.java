package Additional;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean passwordValidation(EditText password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(  password.getText ().toString ());
        return matcher.matches();
    }}
