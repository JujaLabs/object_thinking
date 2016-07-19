package juja.webinar.oop.demo;

import java.io.IOException;

/**
 * @author viktor email kuchin.victor@gmail.com
 */
public interface Readable {
    String content() throws IOException;

    String id();
}
