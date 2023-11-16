package com.company.adt.shifter;

import java.util.List;

//interface shifter
public interface Shifter {
    void generateCircularShifts();
    List<CircularShift> getCircularShifts();
}
