////package com.company.adt;
//
//import com.company.adt.input.Input;
//import com.company.adt.input.KwicInput;
//import com.company.adt.output.KwicOutput;
//import com.company.adt.output.Output;
//import com.company.adt.shifter.KwicCircularShifter;
//import com.company.adt.shifter.Shifter;
//import com.company.adt.sorter.KwicAlphabetizer;
//import com.company.adt.sorter.Sorter;
//
//import java.util.Arrays;
//
//import static com.company.Main.INDEX_FIRST_ARGUMENT;
//import static com.company.Main.INDEX_SECOND_ARGUMENT;
//
//public class MasterControl {
//
//    private Input input;
//    private Shifter shifter;
//    private Sorter sorter;
//    private Output output;
//
//    /**
//     * Creates an instance of each of the modules.
//     */
//    private void initModules() {
//        input = new KwicInput();
//        shifter = new KwicCircularShifter(input);
//        sorter = new KwicAlphabetizer(shifter);
//        output = new KwicOutput(sorter);
//    }
//
//    public void run(String[] args) throws Exception {
//        if (args.length == 0) {
//            throw new Exception("No input file specified.\n"
//                    + "Usage: java com/company/Main <filename> [word to ignore]...");
//        }
//
//        initModules();
//        String filename = args[INDEX_FIRST_ARGUMENT];
//        String[] keywords = Arrays.copyOfRange(args, INDEX_SECOND_ARGUMENT, args.length);
//
//
//        int[] inputint = Arrays.stream(args)
//                .skip(INDEX_SECOND_ARGUMENT)
//                .filter(s -> s.matches("\\d+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        input.processArgumentspecific(filename, keywords);
//        shifter.generateCircularShifts();
//        sorter.reversegenerateSortedList();
//        output.showOutput();
//    }
//}

//Above code commented and abstract factory patern applied to the following code.

package com.company.adt;

import com.company.adt.KWICFactory.KwicConcreteFactory;
import com.company.adt.KWICFactory.KwicFactory;
import com.company.adt.input.Input;
import com.company.adt.output.Output;
import com.company.adt.shifter.Shifter;
import com.company.adt.sorter.Sorter;
import java.util.Arrays;

import static com.company.Main.INDEX_FIRST_ARGUMENT;
import static com.company.Main.INDEX_SECOND_ARGUMENT;

public class MasterControl {

    private Input input;
    private Shifter shifter;
    private Sorter sorter;
    private Output output;

    //Creates the instance of every of the modules using the factory.
     
    private void initModules(KwicFactory factory) {
        input = factory.createInput();
        shifter = factory.createShifter(input);
        sorter = factory.createSorter(shifter);
        output = factory.createOutput(sorter);
    }

    public void run(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("No input file specified.\n"
                    + "Usage: java com/company/Main <filename> [word to ignore]...");
        }

        KwicFactory factory = new KwicConcreteFactory();
        initModules(factory);
        String filename = args[INDEX_FIRST_ARGUMENT];
        String[] keywords = Arrays.copyOfRange(args, INDEX_SECOND_ARGUMENT, args.length);


        int[] inputint = Arrays.stream(args)
                .skip(INDEX_SECOND_ARGUMENT)
                .filter(s -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        input.processArgumentspecific(filename, keywords);
        shifter.generateCircularShifts();
        sorter.reversegenerateSortedList();
        output.showOutput();
    }
}
