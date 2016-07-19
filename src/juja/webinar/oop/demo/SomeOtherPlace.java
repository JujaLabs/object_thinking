package juja.webinar.oop.demo;

import java.io.IOException;

/**
 * @author viktor email kuchin.victor@gmail.com
 */
public class SomeOtherPlace {

    public static void main(String[] args) throws IOException {
        System.out.println(
            new FileCacheContent(
                new HtmlPage("http://example.com/")
            ).content()
        );
    }
}
