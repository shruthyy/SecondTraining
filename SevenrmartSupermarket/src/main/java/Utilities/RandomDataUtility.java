package Utilities;

import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;

public class RandomDataUtility {
	WebDriver driver;

	public static String titleName() {
		Faker faker = new Faker();
		String titleName = faker.name().firstName();
		return titleName;
	}
	public static String descriptionName() {
		Faker faker = new Faker();
		String descriptionName = faker.name().firstName();
		return descriptionName;
	}
	public static String fakerName() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName().toString();
		System.out.println("The first name is " + firstName);
		return firstName;
	}
	public static String fakerLastName() {
		Faker faker = new Faker();
		String lastName = faker.name().lastName().toString();
		System.out.println("The first name is " + lastName);
		return lastName;
	}
	public static String fakerCityName() {
		Faker faker = new Faker();
		String cityname = faker.address().cityName().toString();
		System.out.println("The city name is " + cityname);
		return cityname;
	}
	public static String fakerState() {
		Faker faker = new Faker();
		String state = faker.address().state();
		System.out.println("The city name is " + state);
		return state;
	}
	public static String fakerCountry() {
		Faker faker = new Faker();
		String country = faker.address().country();
		System.out.println("The city name is " + country);
		return country;
	}
	public static String fakerPhoneNumber() {
		Faker faker = new Faker();
		String phoneNo = faker.phoneNumber().cellPhone();
		System.out.println("The city name is " + phoneNo);
		return phoneNo;
	}
	public static String fakerAnimalName() {
		Faker faker = new Faker();
		String animalName = faker.animal().name();
		System.out.println("The city name is " + animalName);
		return animalName;
	}
	public static String fakerEmail() {
		Faker faker = new Faker();
		String emailAdrress = faker.internet().emailAddress();
		System.out.println("The city name is " + emailAdrress);
		return emailAdrress;
	}
	public static String fakerUsername() {
		Faker faker = new Faker();
		String userName = faker.internet().userAgentAny();
		System.out.println("The username is" + userName);
		return userName;
	}
}