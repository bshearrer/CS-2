//Assignment 5 Webserver
//By: Brandon Shearrer
//CS 2 Spring 2018

import java.io.*;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebserverConnection implements Runnable 
{
    private final String HTTP_WORKING = "HTTP/1.1 200 OK\r\n";
    private final String HTTP_NOT_FOUND = "HTTP/1.1 404 Not Found\r\n\r\n";
    private final String HTTP_INTERNAL_ERROR = "HTTP/1.1 500 Internal Server Error\r\n\r\n";

    private final String CONTENT_HTML = "Content-type: text/html\r\n\r\n";
    private static final String INDEX_HTML = "index.html";
    private final String CONTENT_JPG = "Content-type: image/jpg\r\n\r\n";
    private static final String TEST_JPG = "database.jpg";

    private Socket socket;
    private BufferedWriter bufferedWriter;
    private File inputFile;

    public String input = "";
    public String fileName = fileNameRegex(input);
    public String header = "";

    WebserverConnection(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run() 
    {

        try 
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while ((input = bufferedReader.readLine()) != null)
            {
                if(input.startsWith("GET"))
                {
                    break;
                }
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if(fileName != null)
        {
            header = HTTP_WORKING;
        } 
        else 
        {
            header = HTTP_NOT_FOUND;
        }

        try 
        {
            inputFile = new File(fileName);

            if(!inputFile.exists())
            {
                header = HTTP_NOT_FOUND;
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                if(new File("404.html").exists())
                {
                    serveNotFound();
                } 
                else 
                {
                    bufferedWriter.write(header);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
                return;
            } 
            else 
            {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write(HTTP_INTERNAL_ERROR);
            }
        } 
        catch (IOException e)
        {
            System.out.println("IOException in the run() method!");
        }
        try 
        {
            if(header.equals(HTTP_WORKING))
            {
                if(fileName.endsWith(".jpg"))
                {
                    bufferedWriter.write(CONTENT_JPG);
                    inputFile = new File(fileName);
                    FileInputStream imageReader = new FileInputStream(inputFile);

                    byte[] byteArray = new byte[(int)inputFile.length()];
                    imageReader.read(byteArray);
                    String output = new String(byteArray, "UTF-8");

                    bufferedWriter.write(output);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } 
                else 
                {
                    inputFile = new File(fileName);
                    FileInputStream fileReader = new FileInputStream(inputFile);

                    byte[] byteArray = new byte[(int)inputFile.length()];
                    fileReader.read(byteArray);
                    String output = new String(byteArray, "UTF-8");

                    bufferedWriter.write(output);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            }
            else 
            {

            }
        } 
        catch (IOException e)
        {
            System.out.println("Exception in the run() method!");
        }
    }

    public void serveNotFound()
    {
        try 
        {
            BufferedReader notFoundReader = new BufferedReader(new FileReader(new File("404.html")));
            String output = "";
            String line = "";

            while ((line = notFoundReader.readLine()) != null)
            {
                output += line;
            }

            if(bufferedWriter != null)
            {
                bufferedWriter.write(HTTP_WORKING);
                bufferedWriter.write(CONTENT_HTML);
                bufferedWriter.write(output);
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("Erorr 404 page was not found!");
        } 
        catch (IOException e)
        {
            System.out.println("IOException in serveNotFound() method!");
        }
    }

    public String fileNameRegex(String input) 
    {
        String file = "";

        if(input == null)
        {
            return INDEX_HTML;
        }
        Matcher matcher = Pattern.compile("GET\\s\\/(.*?)\\sHTTP\\/1\\.1", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(input);
        try 
        {
            while (matcher.find())
            {
                file = matcher.group(1);
            }
        } 
        catch (Exception e)
        {
            System.out.println("File not found in fileNameRegex()");
            return null;
        }

        if(file.equals("/") || file.equals("") || file == null) 
        {
            return INDEX_HTML;
        } 
        else 
        {
            return file;
        }
    }
}
