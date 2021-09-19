package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 120;
        char c = 'A';
        short s = 125;
        int i = 1400;
        long l = 120L;
        float f = 120f;
        double d = 120.12;
        boolean bl = true;

        LOG.debug("Use 8 primitive var: byte: {}, char {}, short: {}, int: {}, long: {}, float: {}, double: {}, boolean: {}", b, c, s, i, l, f, d, bl);
    }
}