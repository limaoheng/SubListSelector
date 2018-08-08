package au.project;

import au.project.lib.SubListSelector;
import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "This is a demonstration app for selecting sub list for sum closest to 0." );

        Option optionInputArray = Option.builder("a")
                .required(true)
                .desc("Please input an array of integers")
                .longOpt("array")
                .hasArgs()
                .valueSeparator(',')
                .build();
        Option optionOutputLength = Option.builder("l")
                .required(true)
                .desc("Please input an output length")
                .longOpt("length")
                .hasArg()
                .build();
        Options options = new Options();
        options.addOption(optionInputArray);
        options.addOption(optionOutputLength);

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cli = parser.parse(options, args);
            if (!cli.hasOption(optionInputArray.getOpt())) {
                throw new RuntimeException("No array given.");
            }
            if (!cli.hasOption(optionOutputLength.getOpt())) {
                throw new RuntimeException("No output length given.");
            }
            int[] inputArray = new int[cli.getOptionValues(optionInputArray.getOpt()).length];
            for (int i = 0; i < cli.getOptionValues(optionInputArray.getOpt()).length; i++) {
                inputArray[i] = Integer.parseInt(cli.getOptionValues(optionInputArray.getOpt())[i]);
            }
            int length = Integer.parseInt(cli.getOptionValue(optionOutputLength.getOpt()));
            int result = SubListSelector.calculateSubListSum(inputArray, length);

            System.out.println("The result for given argument: ");
            System.out.println("Given Array: " + Arrays.toString(inputArray));
            System.out.println("Given output length: " + length);
            System.out.println("The result is: " + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
