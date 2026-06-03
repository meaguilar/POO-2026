package util;

import java.util.Random;

public class GeneradorRandom {

    private static final Random RANDOM = new Random();

    private GeneradorRandom() {
    }

    public static int generarNumero(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
