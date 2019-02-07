//Assignment 5 Webserver
//By: Brandon Shearrer
//CS 2 Spring 2018

import java.io.IOException;
import java.net.ServerSocket;

public class Webserver 
{
    public static int PORT = 8080;

    public static void main (String args[])
    {
        //Create a ServerSocket object
        ServerSocket socket = null;
		System.out.println("Creating Server . . . ");
        try 
        {
            socket = new ServerSocket(PORT);
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Success! Server located on localhost port 8080");

        //Enter the serversocket object into an infinite loop 
        for(int i = 1; i>0; i++)
        {
            try 
            {
                Thread connectionThread = new Thread(new WebserverConnection(socket.accept()));
                connectionThread.start();
            } 
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
