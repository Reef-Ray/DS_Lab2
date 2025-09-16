import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calendar.Meeting;
import calendar.MeetingCalendar;

class CalanderEventTest {
	
	CalendarEvent test;
	CalendarEvent test2;

    @BeforeEach
    void setup() {
    }

    @Test
    void OneTimeTest() {
    	var sTime = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 13, 30);
		var eTime = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 14, 30);
    	test = new OneTimeEvent("Lunch Time","Cowan", sTime, eTime);
		assertEquals("Lunch Time", test.getDescription());
		assertEquals("Cowan", test.getLocation());
		assertEquals(sTime, test.getStartTime());
		assertEquals(eTime, test.getEndTime());
		var cal = new MeetingCalendar();
		
		test.scheduleEvent(cal);
		Meeting a = cal.findMeeting(sTime);
		Meeting b = new Meeting("Lunch Time","Cowan", sTime, eTime);
		assertEquals(b, a);
    }
    
	@Test
	void PriorityTest() {
		var sTime = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 13, 30);
		var eTime = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 14, 30);
    	test = new PriorityEvent("Lunch Time","Cowan", sTime, eTime);
		var sTime2 = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 13, 30);
		var eTime2 = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 14, 30);
		test2 = new PriorityEvent("tourney", "EVO", sTime2, eTime2);
		assertEquals("Lunch Time", test.getDescription());
		assertEquals("Cowan", test.getLocation());
		assertEquals(sTime, test.getStartTime());
		assertEquals(eTime, test.getEndTime());
		var cal = new MeetingCalendar();
		
		test.scheduleEvent(cal);
		test2.scheduleEvent(cal);
		Meeting a = cal.findMeeting(sTime);
		Meeting b = new Meeting("tourney", "EVO", sTime2, eTime2);
		assertEquals(b,a);
	}
	
	@Test
	void WeeklyTest() {
		var sTime = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 13, 30);
		var eTime = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 14, 30);
		var rTime = new GregorianCalendar(2026, Calendar.FEBRUARY, 7);
    	test = new WeeklyEvent("Lunch Time","Cowan", sTime, eTime, rTime);
		assertEquals("Lunch Time", test.getDescription());
		assertEquals("Cowan", test.getLocation());
		assertEquals(sTime, test.getStartTime());
		assertEquals(eTime, test.getEndTime());
		var cal = new MeetingCalendar();
		
		GregorianCalendar cStart = (GregorianCalendar) sTime.clone();
		GregorianCalendar cEnd = (GregorianCalendar) eTime.clone();

		while (!cStart.after(rTime)) {
			Meeting m = cal.findMeeting(cStart);
			assertEquals("Lunch Time", m.getDescription());
			assertEquals("Cowan", m.getLocation());
			assertEquals(cStart, m.getStartTime());
			assertEquals(cEnd, m.getEndTime());

			cStart.add(Calendar.WEEK_OF_YEAR, 1);
			cEnd.add(Calendar.WEEK_OF_YEAR, 1);
		}
	}
	@Test
	void MultiDayPerWeekTest() {
		var sTime = new GregorianCalendar(2025, Calendar.SEPTEMBER, 15, 10, 0);
		var eTime = new GregorianCalendar(2025, Calendar.SEPTEMBER, 15, 11, 0);
		var rTime = new GregorianCalendar(2025, Calendar.OCTOBER, 6);
		int[] days = { Calendar.MONDAY, Calendar.WEDNESDAY };
		test = new MultiDayPerWeekEvent("CS Lecture", "Room 101", sTime, eTime, rTime, days);
		assertEquals("CS Lecture", test.getDescription());
		assertEquals("Room 101", test.getLocation());
		assertEquals(sTime, test.getStartTime());
		assertEquals(eTime, test.getEndTime());

		var cal = new MeetingCalendar();
		test.scheduleEvent(cal);

		var week = (GregorianCalendar) sTime.clone();
		while (!week.after(rTime)) {
			for (int d : days) {
				var start = (GregorianCalendar) week.clone();
				start.set(Calendar.DAY_OF_WEEK, d);
				start.set(Calendar.HOUR_OF_DAY, sTime.get(Calendar.HOUR_OF_DAY));
				start.set(Calendar.MINUTE, sTime.get(Calendar.MINUTE));

				var end = (GregorianCalendar) start.clone();
				end.set(Calendar.HOUR_OF_DAY, eTime.get(Calendar.HOUR_OF_DAY));
				end.set(Calendar.MINUTE, eTime.get(Calendar.MINUTE));

				Meeting m = cal.findMeeting(start);
				assertEquals("CS Lecture", m.getDescription());
				assertEquals("Room 101", m.getLocation());
				assertEquals(start, m.getStartTime());
				assertEquals(end, m.getEndTime());
			}
			week.add(Calendar.WEEK_OF_YEAR, 1);
		}
	}
}
