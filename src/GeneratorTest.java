import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;
import java.util.concurrent.TimeUnit;


class GeneratorTest {

	@BeforeAll
	public static void before_All(){
		System.out.println("\nTesting has been started..");
	}

	@AfterAll
	public static void after_All(){
		System.out.println("\nTesting has been completed!");
	}

	@BeforeEach
	public void before_Each(){
		System.out.println("\nNew test has been initialized!");
	}

	@AfterEach
	public void after_Each() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Test Finished!");
	}



	@Test
	void CheckAlphabet() {
		//We test the correctness of the password created in accordance with the entered boolean values.

		Alphabet alphabet = new Alphabet(false,true,true,false);
		assertEquals(alphabet.getAlphabet(), Alphabet.LOWERCASE_LETTERS + Alphabet.NUMBERS);
	}

	@Test
	void CheckAlphabetLength() {
		// This test checks if alphabet has correct number of characters

		Generator generator = new Generator(true,false,false,false);
		assertEquals(26,generator.alphabet.getAlphabet().length());
	}

	@Test
	void CheckPassword() {
		// This test checks if password we created is saved correctly

		Password password= new Password("Secret");
		assertEquals("Secret", password.toString());
	}

	@Test
	void CheckCharNumber() {
		// "CharType" function returns values based on their type
		// We test whether values of certain characters are correct in the password to be created.

		Password password= new Password("Secret");
		assertEquals(1, password.CharType('A'));
		assertEquals(2, password.CharType('a'));
		assertEquals(3, password.CharType('3'));
		assertEquals(4, password.CharType('*'));
	}

	@Test
	void CheckPasswordLength() {
		//When we provide a sample password, we test whether the length of the password is correct.

		Password password= new Password("Secret");
		assertEquals(6, password.Length);
	}

	@Test
	void CheckPasswordIsNull() {
		// This test checks if the object is empty after creating password

		Password password= new Password("Secret");
		assertNotNull(password);
	}

	@Test
	void CheckPasswordStrength() {
		// "PasswordStrength" function measures the strength of the password and returns the score
		// We test that the strength of which we have given a sample password is calculated correctly.

		Password password= new Password("Secret");
		assertTrue(password.PasswordStrength()<3);
	}

	@Test
	void MaxIsTrue() {
		// Max value in the "generator" class must be one less than alphabet length
		// This test checks if max value is correct

		Generator generator= new Generator(true, false, false, false);
		int max =25;
		assertEquals(generator.alphabet.getAlphabet().length()-1, max);
	}

	@Test
	void RangeIsTrue() {
		// Thanks to range value, it takes random characters in alphabet
		// So the random value should be equal to the length of alphabet
		// We test whether the length of the alphabet in our method is equal to range

		Generator generator= new Generator(true, false, false, false);
		int range =26;
		assertEquals(generator.alphabet.getAlphabet().length(), range);
	}

	@Test
	void CheckGeneratedPasswordLength() {
		// This test checks if length of randomly generated password is length we want

		Generator generator = new Generator(true,false,false,false);
		Password password = generator.GeneratePassword(15);
		assertEquals(15,password.Length);
	}

	@Test
	void CheckYesNoSituation() {
		// //We test whether the method works when we enter an input with wrong or uppercase letters.

		Generator generator = new Generator(true,false,false,false);
		assertTrue(generator.isInclude("YES"));
		assertFalse(generator.isInclude("no"));
		assertFalse(generator.isInclude("asd"));
	}

	@Test
	void CheckPasswordStrengthMessage() {
		// This test checks if the string value indicating the strength of the password is correct

		Generator generator = new Generator(true,false,false,false);
		Password password = generator.GeneratePassword(10);
		assertEquals("This is a weak password :( definitely find a new one",generator.checkPassword(password.toString()));

		assertNotEquals("This is a medium password :/ try making it better",generator.checkPassword("Ayudua213"));

	}
	@Test
	void CheckPasswordIncludeWantedLetter() {
		// This test checks if the generated password contains the requested characters

		Generator generator = new Generator(true,false,false,false);
		Password password = generator.GeneratePassword(15);
		System.out.println(password);
		assertTrue(password.Value.contains("E") || password.Value.contains("G"));
	}

	@Test
	void CheckQuitMessage() {
		// We test if it prints the quit message correctly

		Generator generator= new Generator(false, false, false, false);
		String message="Closing the program bye bye!";
		assertTrue(generator.printQuitMessage().equals(message));


	}

	@Test
	void PasswordRequestErrorMessage() {
		// We test if it prints the error message correctly

		Generator generator= new Generator(false, false, false, false);
		assertEquals("You have entered something incorrect let's go over it again",generator.PasswordRequestError());
	}

}
