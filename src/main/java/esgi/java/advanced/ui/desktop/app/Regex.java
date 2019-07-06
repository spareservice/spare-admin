package esgi.java.advanced.ui.desktop.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {


    public static boolean emailRegex( String emails) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emails);
        System.out.println(emails +" : "+matcher.matches() );
        return matcher.matches();
    }


}
