package pl.iogreen.jboss.common;

import java.util.Random;

public class Common {

    private static final String versionString = String.valueOf(new Random().nextInt(1000));

    public String version = versionString;
}
