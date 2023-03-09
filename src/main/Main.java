package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length <= 0) {

            System.out.println("Usage: <command>");
            System.exit(0);

        }

        System.out.println("\nStarting...\n");

        Date starttime = new Date();

        Main.runCommand(args[0]);

        Date endtime = new Date();

        System.out.println("\nEnding...\n");

        long time = endtime.getTime() - starttime.getTime();

        System.out.println(String.format("Commmand ran in %s ms!", time));
        System.out.println(String.format("Start time: %s", starttime.getTime()));
        System.out.println(String.format("End time: %s", endtime.getTime()));

    }

    private static void runCommand(String command) throws IOException, InterruptedException {

        Process proc = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
        }

        proc.waitFor();

    }

}
