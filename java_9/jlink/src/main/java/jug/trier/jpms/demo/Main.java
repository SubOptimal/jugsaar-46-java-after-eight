package jug.trier.jpms.demo;

import java.util.logging.Logger;

import static java.lang.System.setProperty;
import static java.util.logging.Logger.getLogger;

public class Main {
    public static void main(String[] args) {
        LOG.info("Hello JPMS");
    }

    static {
        setProperty("java.util.logging.SimpleFormatter.format", "%1tH:%<tM:%<tS %4$.4s [%2s] %5$s%n");
    }

    private static final Logger LOG = getLogger(Main.class.getCanonicalName());
}
