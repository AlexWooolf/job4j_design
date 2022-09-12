package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        int l = 3;
        long lo = 4;
        boolean boo = true;
        char c = 'a';
        float f = 5F;
        double d = 6D;

        LOG.debug("info byte : {}, short : {}, int : {}, long : {}, boolean : {}, char : {}, float : {}, double : {},", b, s, l, lo, boo, c, f, d);
    }
}