//package com.company.adt.input;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Represenrs a line that consists of a ist of words.
// */
//public class Line {
//
//    private List<String> words;
//
//    public Line(String line) {
//        words = Arrays.asList(line.split(" "));
//    }
//
//    /**
//     * Returns the word at 0-based position {@code index} in {@code this} line.
//     * @param index 0-based index of the word in the line.
//     * @return String representing the word at position {@code} index.
//     */
//    public String getWord(int index) {
//        return words.get(index);
//    }
//
//    /**
//     * Returns the number of words in {@code this} line.
//     * @return Integer count of the number of words that make up {@code this} line.
//     */
//    public int getNumberOfWords() {
//        return words.size();
//    }
//}


// Above code commented and Builder pattern applied so that  situations where the creation of an object having many configurations can be done easily.
//Inner Builder class can access the private constructor of the Line class.
//The caller can set the different properties of the Line object using a setters and getters methods available in the Builder class. 
package com.company.adt.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Getters and setters for builder class implementation
public class Line {

    private final List<String> words;

    private Line(Builder builder)
    {
        this.words = builder.words;
    }

    public String getWord(int index) 
   {
        return words.get(index);
    }

    public int getNumberOfWords()
    {
        return words.size();
    }

    
    public static class Builder 
    {
        private List<String> words;

        public Builder()
        {
            this.words = new ArrayList<>();
        }

        public Builder withWords(String... words) 
        {
            this.words.addAll(Arrays.asList(words));
            return this;
        }
        

       // Objects of this used to call other mentods
        
        public Line build()
        {
            return new Line(this);
        }
    }
}
