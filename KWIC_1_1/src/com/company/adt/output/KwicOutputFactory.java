package com.company.adt.output;

import com.company.adt.sorter.Sorter;

public class KwicOutputFactory implements OutputFactory {

	
	//Factory for KWIC output
    @Override
    public Output createOutput(Sorter sorter) {
        return new KwicOutput(sorter);
    }
}
