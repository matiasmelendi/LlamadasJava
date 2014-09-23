package exceptions;

public class InvalidRangeException extends Exception {

	public InvalidRangeException() {
		super("Invalid range, please insert valid values");
	}
}
