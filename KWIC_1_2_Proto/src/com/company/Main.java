package com.company;
//
//import com.company.adt.MasterControl;
//
//import java.util.*;
//
///**
// * Master control class that creates all the objects and invokes all the methods needed to get the KWIC output.
// */
//public class Main {
//
//    public static final int INDEX_FIRST_ARGUMENT = 0;
//    public static final int INDEX_SECOND_ARGUMENT = 1;
//    private static final String FIRST_OPTION = "1";
//    private static final String SECOND_OPTION = "2";
//    public static final String INVALID_KWIC_ARGS = "No input file specified.\n"
//            + "Usage: java com/company/Main <KWIC implementation type> <filename> [word to ignore]...";
//    private static final String INVALID_KWIC_OPTION = "Invalid KWIC implementation. Usage:\n" +
//            "Use 1 for Shared Storage Implementation.\n" +
//            "Use 2 for ADT Implementation\n";
//
//    public static void main(String[] args) throws Exception {
//        String[] inputArgs = Arrays.copyOfRange(args, INDEX_SECOND_ARGUMENT, args.length);
//        if (args[INDEX_FIRST_ARGUMENT].equals(SECOND_OPTION)) {
//            MasterControl masterControl = new MasterControl();
//            masterControl.run(inputArgs);
//        } else {
//            System.out.println(INVALID_KWIC_OPTION);
//        }
//    }
//
//}


import com.company.adt.MasterControl;
import java.util.*;

/**
 * Master control class that creates all the objects and invokes all the methods needed to get the KWIC output.
 */
public class Main {

    public static final int INDEX_FIRST_ARGUMENT = 0;
    public static final int INDEX_SECOND_ARGUMENT = 1;
    private static final String FIRST_OPTION = "1";
    private static final String SECOND_OPTION = "2";
    public static final String INVALID_KWIC_ARGS = "No input file specified.\n"
            + "Usage: java com/company/Main <KWIC implementation type> <filename> [word to ignore]...";
    private static final String INVALID_KWIC_OPTION = "Invalid KWIC implementation. Usage:\n" +
            "Use 1 for Shared Storage Implementation.\n" +
            "Use 2 for ADT Implementation\n";

    public static void main(String[] args) throws Exception {
        String kwicType;
        String inputFilename;
        String ignoreWords;
        
        
//For manual inputs through console
        Scanner scanner = new Scanner(System.in);

        if (args.length == 0) {
            System.out.print("Please enter the KWIC implementation type (press2): ");
            kwicType = scanner.nextLine();

            System.out.print("Please enter the filename: ");
            inputFilename = scanner.nextLine();

            System.out.print("Please enter the words to ignore");
            ignoreWords = scanner.nextLine();
        } else {
            String inputString = String.join(" ", args);
            String[] inputArray = inputString.split(" ");
            kwicType = inputArray[INDEX_FIRST_ARGUMENT];
            inputFilename = inputArray[INDEX_SECOND_ARGUMENT];
            ignoreWords = inputArray.length > 2 ? inputArray[2] : "";
        }
        
        
//Abstract Factory Pattern Applied after calling master control and the functionality of shared storage removed.
        String[] inputArgs = {inputFilename, ignoreWords};

        if (kwicType.equals(SECOND_OPTION)) {
            MasterControl masterControl = new MasterControl();
            masterControl.run(inputArgs);
        } else {
            System.out.println(INVALID_KWIC_OPTION);
        }
    }

}
