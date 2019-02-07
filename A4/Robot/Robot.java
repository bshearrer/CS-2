//Brandon Shearrer
//CS 2 - Assignment 4
//Spring 2018

import java.util.Scanner;

public class Robot 
{
    public static final int LAND = 5;
    public static final int ROTATE_LEFT = 7;
    public static final int ROTATE_RIGHT = 9;
    public static final int MOVE_FOREWARD = 8;
    public static final int MOVE_BACKWARD = 2;
    public static final int MOVE_LEFT = 4;
    public static final int MOVE_RIGHT = 6;
    public static final int MOVE_UP = 3;
    public static final int MOVE_DOWN = 1;

    public static void printUsage()
    {
        System.out.println("Please use numpad as a controller.");
    	System.out.println("USAGE: Press number followed by ENTER key:");
        System.out.println("_ _______________________________________________________________");
        System.out.println("[  rotate right (7) ] [ move forward  (8)] [  rotate right  (9)]");
        System.out.println("[   move right  (4) ] [     Land      (5)] [   move right   (6)]");
        System.out.println("[     Move Up   (1) ] [ move backward (2)] [    Move Down   (3)]");
        System.out.println("_________________________________________________________________");
    }

    public static void main(String[] args) throws InterruptedException
    {
        RobotInstructor robotInstructor = new RobotInstructor();
        robotInstructor.commandTakeoff();

        printUsage();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt())
        {
            switch (scanner.nextInt())
            {
                case MOVE_FOREWARD:
                    robotInstructor.commandMoveForeward();
                    break;
                case MOVE_BACKWARD:
                    robotInstructor.commandMoveBackward();
                    break;
                case MOVE_LEFT:
                    robotInstructor.commandMoveLeft();
                    break;
                case MOVE_RIGHT:
                    robotInstructor.commandMoveRight();
                    break;
                case ROTATE_LEFT:
                    robotInstructor.commandRotateLeft();
                    break;
                case ROTATE_RIGHT:
                    robotInstructor.commandRotateRight();
                    break;
                case LAND:
                    robotInstructor.commandLand();
                    break;
               	case MOVE_UP:
               		robotInstructor.commandMoveUp();
               		break;
               	case MOVE_DOWN:
               		robotInstructor.commandMoveDown();
               		break;
                default:
                    System.out.println("Invalid movement!");
                    System.out.println("USAGE: Press number followed by ENTER key:");
                    break;
            }
        }
        System.exit(0);
    }
}
