package helpers;

public class Environment {
    public static final String
            bsUserName = System.getProperty("bs_user_name", null),
            bsAccessKey = System.getProperty("bs_access_key", null);
}

