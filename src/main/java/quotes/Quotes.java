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

    public void randomQuote()
    {

    }

    public String toString()
    {
        return String.format(this.text + "\n" + this.author + "\n");
    }
}
