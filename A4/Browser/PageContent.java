//Brandon Shearrer
//CS 2 - Assignment 4
//Spring 2018

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageContent 
{
    public String rawHTML = "";
    public String pageTitle = "";
    public String pageBody = "";

    public PageContent(String rawHTML)
    {
        this.rawHTML = rawHTML;
        renderContent(this.rawHTML);
    }

    public void renderContent(String rawHTML)
    {
        stripTitle();
        stripPage();
    }

    private void stripTitle()
    {
        String title = "Untitled";
        Matcher matcher;

        matcher = Pattern.compile("<title[^>]*>(.*?)</title>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(rawHTML);

        try
        {
            while(matcher.find()){title = matcher.group(1);}
        }
        catch(IllegalStateException e)
        {
            e.printStackTrace();
        }

        this.pageTitle = title;
    }

    private void stripPage()
    {
        //body is just the content of the body tag
        String body = "";

        //page will strip javascript, extra tags, spaces, etc
        String page = "";

        Matcher matcher = Pattern.compile("<body[^>]*>(.*?)</body>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(rawHTML);

        try
        {
            while(matcher.find()){ body = matcher.group(1); }
        }
        catch(IllegalStateException e)
        {
            e.printStackTrace();
        }

        page = body.replaceAll("<script[^>]*>(.*?)</script>", "")
                   .replaceAll("<select[^>]*>(.*?)</select>", "")
                   .replaceAll("<input[^>]*>(.*?)</input>", "")
                   .replaceAll("<[^>]*>", "")
                   .replaceAll("&nbsp;", " ")
                   .replaceAll("-[^>]*>", "")
                   .replaceAll("  +", "\n")
                   .trim();
                   
        this.pageBody = page;
    }
}
