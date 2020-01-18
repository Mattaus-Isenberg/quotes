/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;
import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class App
{
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException
    {
            String apiEndPoint = "http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote";
            String backup_Local = "src/main/resources/recentquotes.json";
            goGetItOnline(apiEndPoint, backup_Local);
    }

    public static BufferedReader dialUP(URL url) throws IOException
    {
        HttpURLConnection the_Connection = (HttpURLConnection) url.openConnection();
        the_Connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(the_Connection.getInputStream()));
        return reader;
    }

    public static void goGetItOnline(String urlString, String backup_Local) throws FileNotFoundException, MalformedURLException {
        URL url = new URL(urlString);
        try
        {
            BufferedReader buf_Reader = dialUP(url);

            Gson gson = new Gson();
            StarWars star_Quote = gson.fromJson(buf_Reader, StarWars.class);

            jsonWriter(star_Quote);

            buf_Reader.close();
            System.out.println(star_Quote);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Quotes[] quotes = readQuotes(backup_Local);
            System.out.println(randomQuoteFromJSon(quotes));
        }
    }

    public static void jsonWriter(StarWars quote)
    {
        BufferedWriter b_Writer;
        try
        {
            Gson gson = new Gson();
            String build_New_Json = gson.toJson(quote);

            b_Writer = new BufferedWriter(new FileWriter("src/main/resources/starryquotes.json", true));
            b_Writer.newLine();
            b_Writer.append(build_New_Json);
            b_Writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Quotes[] readQuotes(String path) throws FileNotFoundException
    {
        Gson gson = new Gson();
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
