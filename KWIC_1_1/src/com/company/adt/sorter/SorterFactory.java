package com.company.adt.sorter;
import com.company.adt.shifter.Shifter;


//Factory for sorter

public interface SorterFactory {
    Sorter createSorter(Shifter shifter);
}
