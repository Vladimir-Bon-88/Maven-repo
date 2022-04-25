package utils;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.Properties;

public final class Utils {

    public static Properties getProp() {
        Properties prop = new Properties();
        try {
            prop.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

