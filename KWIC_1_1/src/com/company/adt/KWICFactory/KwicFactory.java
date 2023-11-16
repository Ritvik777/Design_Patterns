package com.company.adt.KWICFactory;
import com.company.adt.input.Input;
import com.company.adt.output.Output;
import com.company.adt.shifter.Shifter;
import com.company.adt.sorter.Sorter;
//KWIC factory
public interface KwicFactory {
    Input createInput();
    Shifter createShifter(Input input);
    Sorter createSorter(Shifter shifter);
    Output createOutput(Sorter sorter);
}