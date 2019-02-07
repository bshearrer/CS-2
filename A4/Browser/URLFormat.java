//Brandon Shearrer
//CS 2 - Assignment 4
//Spring 2018

import java.net.URL;
import java.net.MalformedURLException;

public class URLFormat 
{
    public String enteredString = "";
    public URL confirmedURL;
    private String fReq = "";
    private String hReq = "";
    private final String STANDARD = "HTTP/1.1/r/n";

    URLFormat(String url)
    {
        this.enteredString = url;
        parseURL();
    }

    public String gethReq() 
    {
        return hReq;
    }

    public void parseURL()
    {
        try
        {
            //Corrects user error if htpp:// input is not given
            if(!(enteredString.startsWith("http://")))
            {
                enteredString = "http://" + enteredString;
            }

            confirmedURL = new URL(enteredString);
            fReq = ( (fReq = confirmedURL.getFile().trim()).equals("")) ? "/" : fReq;
            System.out.println("File Requested: '"+fReq+"'");
            hReq = confirmedURL.getHost();
        }
        catch(MalformedURLException e)
        {
            System.out.println("There was a Malformed URL Exception error!");
        }
    }

    public String createRequest()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GET "+fReq+" "+STANDARD+"\n");
        stringBuilder.append("host: "+hReq+" \n\n");

        return stringBuilder.toString();
    }

    public void setEnteredString(String enteredString) 
    {
        this.enteredString = enteredString;
        System.out.println(enteredString);
    }
}
