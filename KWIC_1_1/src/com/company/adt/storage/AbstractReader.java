package com.company.adt.storage;

//abstract class for Abstact reader used in Line reader.
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.List;

//For reasding line one by one
import com.company.adt.input.Line;
public abstract class AbstractReader {
    public abstract List<Line> readData(String filename) throws FileNotFoundException, IOException;

}
