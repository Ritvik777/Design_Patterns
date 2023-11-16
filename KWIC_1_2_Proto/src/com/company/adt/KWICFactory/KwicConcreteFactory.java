package com.company.adt.KWICFactory;
import com.company.adt.input.Input;
import com.company.adt.input.KwicInput;
import com.company.adt.output.KwicOutput;
import com.company.adt.output.Output;
import com.company.adt.shifter.KwicCircularShifter;
import com.company.adt.shifter.Shifter;
import com.company.adt.sorter.KwicAlphabetizer;
import com.company.adt.sorter.Sorter;
//Kwic concrete factory used in master control.
public class KwicConcreteFactory implements KwicFactory {
    @Override
    public Input createInput() {
        return new KwicInput();
    }

    @Override
    public Shifter createShifter(Input input) {
        return new KwicCircularShifter(input);
    }

    @Override
    public Sorter createSorter(Shifter shifter) {
        return new KwicAlphabetizer(shifter);
    }

    @Override
    public Output createOutput(Sorter sorter) {
        return new KwicOutput(sorter);
    }
}
