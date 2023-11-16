package com.company.adt.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.company.adt.input.KwicInput;
import com.company.adt.input.Line;

// for reading the ibpour from file 
public class LineReader extends AbstractReader {

    private List<Line> lines ;

    @Override
    public List<Line> readData(String filePath) throws FileNotFoundException, IOException{

        File inputFile = new File(filePath);


        if (!isFileExists(inputFile)) {
            throw new FileNotFoundException();
        }

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);


        } catch (IOException ioe) {
            System.out.println("IOException while reading file." + ioe.getStackTrace());
            throw ioe;
        }
        return lines;

    }

    private boolean isFileExists(File file) {
        return file.exists() && file.isFile();
    }




}
