package juja.webinar.oop.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * @author viktor email kuchin.victor@gmail.com
 */
public class HtmlPage implements Readable {

    private final URL url;

    public HtmlPage(URL url) {
        this.url = url;
    }

    public HtmlPage(String path) throws MalformedURLException {
        this(new URL(path));
    }

    @Override
    public String content() throws IOException {
        InputStream is = url.openStream();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String content = reader.lines().collect(Collectors.joining("\n"));
            return content;
        }
    }

    @Override
    public String id() {
        return url.getPath();
    }
}
