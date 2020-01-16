/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.BufferOverflowException;
import java.util.Scanner;

public class App
{

    public static void main(String[] args) throws FileNotFoundException {
        Quotes[] quotes = readQuotes();
        randomQuoteFromJSon(quotes);
        System.out.println(randomQuoteFromJSon(quotes));
        }


    public static Quotes[] readQuotes() throws FileNotFoundException
    {
        Gson gson = new Gson();
        String path = "src/main/resources/recentquotes.json";
            FileReader reader = new FileReader(path);
            Quotes[] quoteArray = gson.fromJson(reader, Quotes[].class);
            return quoteArray;
    }

    public static Quotes randomQuoteFromJSon(Quotes[] quotes)
    {
        int randomQuote = (int)(Math.random() * quotes.length);
        return  quotes[randomQuote];
    }

}
