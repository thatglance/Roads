package main.java.com.epam;

public final class Constants {

    private Constants() {

    }

    public static final class IOInfo {
        public static final int FIRST_VERTEX_INDEX = 0;
        public static final int SECOND_VERTEX_INDEX = 1;
        public static final int ROAD_LENGTH_INDEX = 2;
        public static final int ROAD_COST_INDEX = 3;

        public static final int VALUES_NUMBER = 4;

        public static final String SEPARATOR = " ";
    }

    public static final class AlgorithmConstants {
        public static final int INFINITY_DISTANCE = Integer.MAX_VALUE;
    }

}
