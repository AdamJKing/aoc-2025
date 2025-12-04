package uk.co.bumblebyte;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class Util {
    public static String readInputFull(String filename) throws IOException {
        return IOUtils.resourceToString("/" + filename, Charset.defaultCharset());
    }
}
