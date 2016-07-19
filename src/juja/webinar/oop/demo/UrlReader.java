package juja.webinar.oop.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * @author viktor email kuchin.victor@gmail.com
 */
public class UrlReader {

    private final URL url;

    public UrlReader(URL url) {
        this.url = url;
    }

    public UrlReader(String path) throws MalformedURLException {
        this(new URL(path));
    }

    public String content() throws IOException {
        InputStream is = url.openStream();
        StringBuilder sb = new StringBuilder();
        String cache = readFromFile(url);
        if (cache == null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String content = reader.lines().collect(Collectors.joining("\n"));
                saveToCache(content);
                return content;
            }
        } else {
            return cache;
        }
    }

    private void saveToCache(String content) {
        System.out.println("Saving to cache");
    }

    private String readFromFile(URL url) {
        System.out.println("Reading from file");
        return null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new UrlReader("http://example.com/").content());
    }
}
