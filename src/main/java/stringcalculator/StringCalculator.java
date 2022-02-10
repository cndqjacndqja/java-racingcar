package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public StringCalculator() {
	}

	public String[] split(String input) {
		return input.split(",|:");
	}

	public String[] customDelimiter(String input) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (!m.find()) {
			throw new RuntimeException();
		}
		String customDelimiter = m.group(1);
		if (customDelimiter.equals("+") || customDelimiter.equals("*") || customDelimiter.equals("^")) {
			StringBuffer prefix = new StringBuffer("\\");
			StringBuffer buffer = prefix.append(customDelimiter);
			return m.group(2).split(buffer.toString());
		}
		return m.group(2).split(customDelimiter);
	}

	public int splitAndSum(String input) {
		if (validNullOrEmpty(input)) {
			return 0;
		}

		if (input.length() > 2 && input.substring(0, 3).equals("//")) {
			String[] numbers = customDelimiter(input);
			return this.sum(numbers);
		}
		String[] numbers = split(input);
		return this.sum(numbers);
	}

	private boolean validNullOrEmpty(String input) {
		return input == null || input.equals("");
	}

	public int sum(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
	}
}
