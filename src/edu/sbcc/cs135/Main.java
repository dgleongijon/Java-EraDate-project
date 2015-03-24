package edu.sbcc.cs135;

public class Main {

	public static void main(String[] args) {

		EraDate era = new EraDate(1912, 8, 1);

		System.out.println(era.getIso8601Date());

		era.printJapaneseEraName();

	}

}
