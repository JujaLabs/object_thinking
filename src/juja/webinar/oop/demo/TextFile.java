package juja.webinar.oop.demo;

/**
 * @author viktor email kuchin.victor@gmail.com
 */
public class TextFile implements Readable {

    private final String fileName;

    public TextFile(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String content() {
        System.out.println("read from file");
        return null;
    }

    @Override
    public String id() {
        return fileName;
    }
}
