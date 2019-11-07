package java8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import org.junit.BeforeClass;
import org.junit.Test;

public class DateTimeAPITest {
	private static LocalDateTime currentTime = null;

	@BeforeClass
	public static void getCurrentLocalDateTime() {
		currentTime = LocalDateTime.now();
	}

	@Test
	public void testLocalDateTime() {
		System.out.println("Current local date time : " + currentTime);
	}

	@Test
	public void testLocalDate() {
		System.out.println("Current local date : " + currentTime.toLocalDate());
	}

	@Test
	public void testDatePlusTimeUnit() {
		System.out.println("Current time with next day : " + currentTime.plus(1, ChronoUnit.DAYS));
		System.out.println("Current time with next year : " + currentTime.plus(1, ChronoUnit.YEARS));
	}

	@Test
	public void testPeriodBetweenDates() {
		LocalDateTime twoDaysLater = currentTime.plus(1, ChronoUnit.DAYS);
		Period p = Period.between(twoDaysLater.toLocalDate(), currentTime.toLocalDate());
		System.out.println("Period between tomorrow and today : " + p);
	}

	@Test
	public void testDurationBetweenHours() {
		// LocalDateTime twoHoursLater = currentTime.plus(2,ChronoUnit.HOURS);
		LocalDateTime twoHoursLater = currentTime.plus(Duration.ofHours(2));
		Duration d = Duration.between(twoHoursLater, currentTime);
		System.out.println("Duration between the times : " + d);
	}

	@Test
	public void testParseDate() {
		LocalDate parsedDate;
		try {
			parsedDate = LocalDate.parse("1994/02/17", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("parsed Date : "+parsedDate.toString());
		} catch (Exception e) {
			System.out.println("Caught exception : " + e.getMessage());
		}
	}

	// Temporal Adjusters
	@Test
	void testTemporalAdjuster() {
		LocalDate today = currentTime.toLocalDate();
		System.out.println("Next Satuday : " + today.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));
		System.out.println("Next Friday : " + today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		System.out.println("Next or Same Friday : " + today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)));
		LocalDate startOfCurrentMonth = LocalDate.of(today.getYear(), today.getMonth(), 1);
		LocalDate secondSaturday = startOfCurrentMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
				.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday of this month : " + secondSaturday);
	}
}
