package com.company.adt.shifter;
import com.company.adt.input.Line;
/**
 * Default implementation of CircularShiftFactory.
 */
public class DefaultCircularShiftFactory extends CircularShiftFactory {

//Create a anew Isntance of circular shift 
    @Override
    public CircularShift createCircularShift(Line line, int offset) {
        return new CircularShift(line, offset);
    }
}
