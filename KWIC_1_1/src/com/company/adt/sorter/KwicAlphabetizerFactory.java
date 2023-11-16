package com.company.adt.sorter;

import com.company.adt.shifter.Shifter;

public class KwicAlphabetizerFactory implements SorterFactory {

	//factory for alphabetizer
    @Override
    public Sorter createSorter(Shifter shifter) {
        return new KwicAlphabetizer(shifter);
    }
}
