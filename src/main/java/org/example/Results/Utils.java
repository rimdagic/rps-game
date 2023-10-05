package org.example.Results;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<RoundResult> cloneList(List<RoundResult> inputList){
        List<RoundResult> clonedList = new ArrayList<>();

        for (RoundResult instance : inputList){
            RoundResult clonedInstance = instance;
            clonedList.add(clonedInstance);
        }

        return clonedList;
    }

}
