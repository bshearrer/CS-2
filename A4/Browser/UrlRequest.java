//Brandon Shearrer
//CS 2 - Assignment 4
//Spring 2018

import java.io.*;
import java.net.Socket;

public class UrlRequest 
{
    //Setting variables up for the Browser's default port, and formatting.
    public static final int DEFAULT_PORT = 80;
    public String rawHTML = "";
    URLFormat URLFormat;

    public String getRawHTML()
    {
        return rawHTML;
    }

    public String downloadRawHtml(String url)
    {
        return downloadRawHtml(url, DEFAULT_PORT);
    }

    public String downloadRawHtml(String host, int port)
    {
        Socket socket = null;

        //need to rename these, not very descriptive names
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;

        //probably just a temp variable, can use the entered url later
        String formattedRequest = "";

        URLFormat = new URLFormat(host);
        formattedRequest = URLFormat.createRequest();
        host = URLFormat.getHostRequest();

        try 
        {
            socket = new Socket(host, port);
        } 
        catch (IOException e)
        {
            System.out.println("IOException error!");
        }

        if (socket != null && socket.isConnected()) 
        {
            try 
            {
                printWriter = new PrintWriter(socket.getOutputStream());
            } 
            catch (IOException e)
            {
                System.out.println("Printwriter failed to create!");
            }

            try 
            {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } 
            catch (IOException e)
            {
                System.out.println("Buffered reader failed to create!");
            }

            System.out.println(formattedRequest + "\n\n");
            printWriter.print(formattedRequest);
            printWriter.flush();

            String pageLine = "";
            try 
            {
                while ((pageLine = bufferedReader.readLine()) != null)
                {
                    rawHTML += pageLine;
                }
            } 
            catch (IOException e)
            {
                System.out.println("cannot get the next line from the buffered reader");
            }
        }
        return rawHTML;
    }
}
