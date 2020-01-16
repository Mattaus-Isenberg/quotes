package quotes;

import java.security.PublicKey;

public class Quotes {

    String[] tags;
    String author;
    String likes;
    String text;

    public Quotes(String[] tags, String author, String likes, String text)
    {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    public String toString()
    {
        return String.format("Quote: " + this.text + "\n" + "Author: " + this.author + "\n");
    }
}
