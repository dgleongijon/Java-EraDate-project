package unittest.cs135;

import static java.lang.System.*;
import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

import edu.sbcc.cs135.*;

public class EraDateTester {
	private static final int maximumScore = 8;
	private static final int maximumAssignmentScore = 16;
	private static int totalScore;

	private PrintStream oldOut;
	private PrintStream stringStream;
	private ByteArrayOutputStream baos;

	@BeforeClass
	public static void beforeTesting() {
		totalScore = 0;
	}

	@AfterClass
	public static void afterTesting() {
		out.printf("Your program's functionality scores %d out of %d.\n\n", totalScore, maximumScore);

		int difference = maximumAssignmentScore - maximumScore;
		String correctedPoint = (difference == 1) ? "point" : "points";

		out.printf("The assignment is worth a total of %d where the remainder of %d %s\n", maximumAssignmentScore,
				difference, correctedPoint);
		out.println("comes from grading related to documentation, algorithms, and other");
		out.println("criteria.");
	}

	@Before
	public void setUp() {
		this.baos = new ByteArrayOutputStream();
		this.stringStream = new PrintStream(baos);
		this.oldOut = System.out;
		setOut(this.stringStream);

	}

	@After
	public void tearDown() {
		setOut(this.oldOut);
	}

	@Test
	public void testIso8601() {
		EraDate graceHopperBirthday = new EraDate(1906, 12, 9);
		assertEquals("Birthdays should match exactly", "1906-12-09", graceHopperBirthday.getIso8601Date());
		totalScore += 1;

		EraDate bigBirdBirthday = new EraDate(1991, 3, 15);
		assertEquals("Birthdays should match exactly", "1991-03-15", bigBirdBirthday.getIso8601Date());
		totalScore += 1;

		EraDate newBeginning = new EraDate(1905, 1, 1);
		assertEquals("Birthdays should match exactly", "1905-01-01", newBeginning.getIso8601Date());
	}

	@Test
	public void testJapaneseMeijiEra() {
		EraDate date = new EraDate(1868, 9, 8);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Era should be Meiji", "Meiji\n", this.baos.toString());

		this.baos.reset();
		date = new EraDate(1912, 7, 30);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Check your months to make sure you are subtracting 1 in the constructor.", "Meiji\n",
				this.baos.toString());

		this.baos.reset();
		date = new EraDate(1900, 1, 1);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Check your months to make sure you are subtracting 1 in the constructor.", "Meiji\n",
				this.baos.toString());
		totalScore += 1;
	}

	@Test
	public void testJapaneseTaishoEra() {
		EraDate date = new EraDate(1912, 8, 1);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Check the month in the constructor", "Taisho\n", this.baos.toString());

		this.baos.reset();
		date = new EraDate(1926, 12, 25);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Check the month in the constructor", "Taisho\n", this.baos.toString());

		this.baos.reset();
		date = new EraDate(1922, 1, 1);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Check the month in the constructor", "Taisho\n", this.baos.toString());
		totalScore += 2;
	}

	@Test
	public void testJapaneseShowaEra() {
		EraDate date = new EraDate(1926, 12, 26);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Check the month in the constructor", "Showa\n", this.baos.toString());

		this.baos.reset();
		date = new EraDate(1989, 1, 7);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Check the month in the constructor", "Showa\n", this.baos.toString());

		this.baos.reset();
		date = new EraDate(1950, 1, 1);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Check the month in the constructor", "Showa\n", this.baos.toString());
		totalScore += 2;
	}

	/**
	 * Returns the Japanese era for the internal date structure. We use the
	 * following dates: Meiji - 9/8/1868 - 7/30/1912 Taisho - 8/1/1912 -
	 * 12/25/1926 Showa - 12/26/1926 - 1/7/1989 Heisei - 1/8/1989 - present Note
	 * that these dates are not the actual dates since those dates overlap by a
	 * day
	 *
	 */
	@Test
	public void testJapaneseHeiseiEra() {
		EraDate date = new EraDate(1989, 1, 8);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Check the month in the constructor", "Heisei\n", this.baos.toString());

		this.baos.reset();
		date = new EraDate(2014, 1, 1);
		date.printJapaneseEraName();
		System.out.flush();

		assertEquals("Check the month in the constructor", "Heisei\n", this.baos.toString());
		totalScore += 1;
	}
}
