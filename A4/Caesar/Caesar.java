//Brandon Shearrer
//CS 2 - Assignment 4
//Spring 2018

import java.io.*;
import java.util.Scanner;

public class Caesar 
{
    public File inputFile;
    public File outputFile;
    public int coder;

    public Caesar(File inputFile, File outputFile, int coder)
    {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.coder = coder;
    }

    //Creates a scanner to find the input file, and a PrintWriter to write to the output file.
    //Catches any FileNotFoundException's
    public void decryptCode()
    {
        try
        {
            Scanner scanner = new Scanner(inputFile);
            PrintWriter printWriter = new PrintWriter(outputFile);

            while (scanner.hasNextLine())
            {
                String tempIn = scanner.nextLine();
                String tempDecrypt = decryptLine(tempIn, coder);
                printWriter.write(tempDecrypt + "\n");
            }
            printWriter.flush();
            printWriter.close();
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("File was not found.");
            System.out.println("(Make sure source code directory is correct for input file!)");
            System.exit(0);
        }
    }

    //Creates a scanner to find the input file, and a PrintWriter to write to the output file.
    //Catches any FileNotFoundException's
    public void encryptCode()
    {
        try
        {
            Scanner scanner = new Scanner(inputFile);
            PrintWriter printWriter = new PrintWriter(outputFile);

            while (scanner.hasNextLine())
            {
                String tempIn = scanner.nextLine();
                String tempEncrypt = encryptLine(tempIn, coder);
                printWriter.write(tempEncrypt + "\n");
            }
            printWriter.flush();
            printWriter.close();

        } 
        catch (FileNotFoundException e)
        {
            System.out.println("File was not found.");
            System.exit(0);
        }
    }

    public String encryptLine(String inLine, int coder)
    {
        String outputLine = "";

        for(int i = 0; i < inLine.length(); i++)
        {
            char statChara = inLine.charAt(i);
            if (statChara > 32 || statChara < 126) 
            {
                statChara = (char)statChara;
            }
            statChara = (char)(statChara + coder);

            if (statChara > 126) 
            {
                statChara = (char)(statChara - 95);
            }
            if (statChara < 32) 
            {
                statChara = (char)(statChara  + 95);
            }
            outputLine += statChara;
        }
        return outputLine;
    }

    public String decryptLine(String inLine, int coder)
    {
        String outputLine = "";

        for(int i = 0; i < inLine.length(); i++)
        {
            char statChara = inLine.charAt(i);
            if (statChara > 32 || statChara < 126) 
            {
                statChara = (char)statChara;
            }
            statChara = (char)(statChara - coder);

            if (statChara > 126) 
            {
                statChara = (char)(statChara - 95);
            }

            if (statChara < 32) 
            {
                statChara = (char)(statChara  + 95);
            }

            outputLine += statChara;
        }
        return outputLine;
    }

    public static void printError()
    {
        System.out.println("Usage: java Caesar [usage option] [coder] [input.txt] [output.txt]");
        System.out.println("Usage options: enc for Encrypt, dec for decrypt");
        System.out.println("Coder options: enter a number please.");
        System.exit(0);
    }

    public static void main(String[] args) 
    {
        File inputFile;
        File outputFile;
        int coder;
        boolean encrypted = true;

        if(args.length != 4)
        {
            printError();
        }

        outputFile = new File(args[3]);
        coder = Integer.parseInt(args[1]);

        if(args[0].equals("enc"))
        {
            encrypted = true;
        } 
        else if (args[0].equals("dec"))
        {
            encrypted = false;
        } 
        else 
        {
            printError();
        }

        try {
            inputFile = new File(args[2]);
            if(!inputFile.exists() && !inputFile.isDirectory())
            {
                throw new FileNotFoundException();
            }
            Caesar caesar = new Caesar(inputFile, outputFile, coder);
            if(encrypted)
            {
                caesar.encryptCode();
            } 
            else 
            {
                caesar.decryptCode();
            }
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("input file doesn't exist");
        }
    }
}
