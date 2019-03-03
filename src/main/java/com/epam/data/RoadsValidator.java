package main.java.com.epam.data;

import java.util.List;

import static main.java.com.epam.Constants.IOInfo.*;

public class RoadsValidator {

    private final static String VALIDATOR_PATTERN = "^\\d+$";

    private RoadsValidator() {
    }

    public static boolean checkIsRoadsInfoValid(final List<String> linesList) {
        for (String line : linesList) {
            final String[] roadInfo = line.split(SEPARATOR);

            if (!isLineValid(roadInfo)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isLineValid(final String[] roadInfo) {
        return isValuesNumberValid(roadInfo) && isValuesFormatValid(roadInfo);
    }

    private static boolean isValuesNumberValid(final String[] roadInfo) {
        return roadInfo.length >= VALUES_NUMBER;
    }

    private static boolean isValuesFormatValid(final String[] roadInfo) {
        return roadInfo[ROAD_LENGTH_INDEX].matches(VALIDATOR_PATTERN)
                && roadInfo[ROAD_COST_INDEX].matches(VALIDATOR_PATTERN);
    }
}
