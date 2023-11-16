package com.company.adt.shifter;
import com.company.adt.input.Line;
/**
 * Abstract factory for creating instances of CircularShift.
 */
public abstract class CircularShiftFactory {

 ////Create a anew Isntance of circular shift 
    public abstract CircularShift createCircularShift(Line line, int offset);
}
