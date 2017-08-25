package utils;

import java.util.concurrent.TimeUnit;

public final class TimeUtil {

	private TimeUtil() {
	}

	static long startTime;
	static long stopTime;

	public static void start() {
		startTime = System.nanoTime();
	}

	public static void stop() {
		stopTime = System.nanoTime();
	}

	public static String elaspedTime() {
		long elapsedTime = stopTime - startTime;
		String str = "Milli's: " + TimeUnit.NANOSECONDS.toMillis(elapsedTime) + "ms" + " Sec's: "
				+ (double) TimeUnit.NANOSECONDS.toMillis(elapsedTime) / 1000 + "s" + " Min's: "
				+ (float) ((double) TimeUnit.NANOSECONDS.toMillis(elapsedTime) / 1000) / 60 + "min";
		return str;
	}
}
