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

    public static boolean telephone( String emails) {
        String regex = "\\d{10}|\\+33\\d{9}|\\+33\\s\\d{1}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}|\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emails);
        System.out.println(emails +" : "+matcher.matches() );
        return matcher.matches();
    }


}
