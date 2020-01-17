package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

class GetQuotes {

    public static void randomQuote(String pathname) throws FileNotFoundException {
        Gson gson = new Gson();

        String path = pathname;

        File recentQuotesFile = new File(pathname);
        String inputString = "";

        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNext()) {
                inputString += scanner.nextLine();
            }
            scanner.close();


        } catch (FileNotFoundException e) {
            throw e;
        }


        RecentQuotes[] quoteArray = gson.fromJson(inputString, RecentQuotes[].class);
        Random randomQuotes = new Random();
        int n = (int) Math.ceil(Math.random() * quoteArray.length);
        System.out.println(quoteArray[n]);
    }




        public static String randomJokes() throws IOException {
            URL url = new URL("https://icanhazdadjoke.com/slack");
            HttpURLConnection jokeConnection = null;
            try {
                jokeConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            jokeConnection.setRequestMethod("GET");
            BufferedReader input = new BufferedReader(new InputStreamReader(jokeConnection.getInputStream()));

            StringBuilder buildString = new StringBuilder();
            String firstLine = input.readLine();
            while (firstLine != null) {
                buildString.append(firstLine);
                firstLine = input.readLine();
            }
            Gson gson = new Gson();
            DadJokes dadJokes = gson.fromJson(buildString.toString(), DadJokes.class);
            System.out.println("dadJokes = " + dadJokes.toString());
            return buildString.toString();
        }


}