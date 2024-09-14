package Resistores;

import java.util.HashMap;
import java.util.Map;

public class ResistorColeCode {
	private static final Map<Integer, String> colorMap = new HashMap<>();

	static {
		colorMap.put(0, "preto");
		colorMap.put(1, "marrom");
		colorMap.put(2, "vermelho");
		colorMap.put(3, "laranja");
		colorMap.put(4, "amarelo");
		colorMap.put(5, "verde");
		colorMap.put(6, "azul");
		colorMap.put(7, "violeta");
		colorMap.put(8, "cinza");
		colorMap.put(9, "branco");
	}

	public static String getResistorColors(String input) {
		String valueStr = input.split(" ")[0];
		double value = parseResistorValue(valueStr);
		int firstDigit = (int) (value / 10);
		int secondDigit = (int) (value % 10);

		int multiplier = 0;
		if (valueStr.contains("k")) {
			multiplier = 2;
		} else if (valueStr.contains("M")) {
			multiplier = 5;
		} else if (value >= 100) {
			multiplier = (int) Math.log10(value / (firstDigit * 10 + secondDigit));
		}

		StringBuilder colorSequence = new StringBuilder();
		colorSequence.append(colorMap.get(firstDigit)).append(" ");
		colorSequence.append(colorMap.get(secondDigit)).append(" ");
		colorSequence.append(colorMap.get(multiplier)).append(" ");
		colorSequence.append("dourado");

		return colorSequence.toString();
	}

	private static double parseResistorValue(String valueStr) {
		if (valueStr.contains("k")) {
			return Double.parseDouble(valueStr.replace("k", "")) * 1000;
		} else if (valueStr.contains("M")) {
			return Double.parseDouble(valueStr.replace("M", "")) * 1_000_000;
		} else {
			return Double.parseDouble(valueStr);
		}
	}

	public static void main(String[] args) {
		
		System.out.println(getResistorColors("47 ohms"));
		System.out.println(getResistorColors("4.7k ohms"));
		System.out.println(getResistorColors("1M ohms"));
		System.out.println(getResistorColors("10 ohms"));
		System.out.println(getResistorColors("220 ohms"));
	}

}