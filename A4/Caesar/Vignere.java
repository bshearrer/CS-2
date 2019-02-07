//Brandon Shearrer
//CS 2 - Assignment 4
//Spring 2018

import java.io.*;
import java.util.Scanner;

public class Vignere 
{
    public File inputFile;
    public File outputFile;
    public String coder;
    public int coderCharIndex = 0;
    public String outLine = "";

    public Vignere(File inputFile, File outputFile, String coder)
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
            System.out.println("file not found");
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
            System.out.println("File cannot be found!");
            System.exit(0);
        }
    }
    public String encryptLine(String inLine, String coder)
    {



        for(int i = 0; i < inLine.length(); i++)
        {
            char lineChar = inLine.charAt(i);
            char coderChar = coder.charAt(coderCharIndex);

            if (lineChar > 32 || lineChar < 126) 
            {
                lineChar = (char)lineChar;
            }

            lineChar = (char)(lineChar + coderChar);

            if (lineChar > 126) 
            {
                lineChar = (char)(lineChar - 95);
            }

            if (lineChar < 32)
            { 
                lineChar = (char)(lineChar  + 95);
            }

            coderCharIndex++;
            if (coderCharIndex == coder.length()) 
            {
                coderCharIndex = 0;
            }

            outLine += lineChar;
        }
        return outLine;
    }

    public String decryptLine(String inLine, String coder){

        for(int i = 0; i < inLine.length(); i++){
            char tempChar = inLine.charAt(i);
            char coderChar = coder.charAt(coderCharIndex);

            if (tempChar > 32 || tempChar < 126) 
            {
               tempChar = (char)tempChar;
            }

            if (tempChar - coderChar < 0)
            {
                tempChar = (char)(tempChar - coderChar + 95);
            } 
            else 
            {
                tempChar = (char)(tempChar - coderChar);
            }

            if (tempChar > 126) 
            {
               tempChar = (char)(tempChar - 95);
            }
            if (tempChar < 32)
            { 
                tempChar = (char)(tempChar  + 95);
            }
            coderCharIndex++;
            if (coderCharIndex == coder.length())
            { 
                coderCharIndex = 0;
            }
            outLine += tempChar;
        }
        return outLine;
    }

    public static void printError()
    {
        System.out.println("Propper Usage is: java Vignere -option coder inputFile outputFile");
        System.out.println("Usage option: enc to encrypt, dec to decrypt");
        System.exit(0);
    }

    public static void main(String[] args) {
        File inputFile;
        File outputFile;
        String coder;
        boolean isEncrypt = true;

        if (args.length != 4){
            printError();
        }

        outputFile = new File(args[3]);
        coder = args[1];

        if(args[0].equals("enc"))
        {
            isEncrypt = true;
        } 
        else if (args[0].equals("dec"))
        {
            isEncrypt = false;
        } 
        else 
        {
            printError();
        }

        try 
        {
            inputFile = new File(args[2]);

            if(!inputFile.exists() && !inputFile.isDirectory())
            {
                throw new FileNotFoundException();
            }
            Vignere Vignere = new Vignere(inputFile, outputFile, coder);
            if(isEncrypt)
            {
                Vignere.encryptCode();
            } else 
            {
                Vignere.decryptCode();
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Input File Cannot Be Found!");
        }
    }
}
