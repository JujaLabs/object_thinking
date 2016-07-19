package juja.webinar.oop.demo;

import java.io.IOException;

/**
 * @author viktor email kuchin.victor@gmail.com
 */
public final class FileCacheContent implements Readable {

    private final Readable readable;
    private final String cache;

    public FileCacheContent(Readable readable) {
        this.readable = readable;
        cache = readFromFile(readable.id());
    }

    private String readFromFile(String id) {
        return new TextFile(id).content();
    }

    @Override
    public String content() throws IOException {
        if (cache == null) {
            String content = readable.content();
            saveToFile(readable.id(), content);
            return content;
        } else {
            return cache;
        }
    }

    private void saveToFile(String id, String content) {
        System.out.println("Saving content to " + id);
    }

    @Override
    public String id() {
        return readable.id();
    }
}
