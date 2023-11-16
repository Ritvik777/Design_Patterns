package com.company.adt.output;

import com.company.adt.sorter.Sorter;

//Factory for Creating output
public interface OutputFactory {
    public Output createOutput(Sorter sorter);
}
