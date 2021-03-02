package com.lbarc.aglo.exercises.algoexpert.calendarmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {

	public static List<StringMeeting> calendarMatching(
			List<StringMeeting> calendar1,
			StringMeeting dailyBounds1,
			List<StringMeeting> calendar2,
			StringMeeting dailyBounds2,
			int meetingDuration) {

		final boolean[] slots1 = new boolean[60 * 24];
		final boolean[] slots2 = new boolean[60 * 24];
		final boolean[] slotsCommon = new boolean[60 * 24];

		for (int i = dailyBounds1.getStartIdx(); i < dailyBounds1.getEndIdx(); i++) {
			slots1[i] = true;
		}

		for (int i = dailyBounds2.getStartIdx(); i < dailyBounds2.getEndIdx(); i++) {
			slots2[i] = true;
		}

		for (int i = 0; i < slotsCommon.length; i++) {
			slotsCommon[i] = slots1[i] && slots2[i];
		}

		Stream.concat(calendar1.stream(), calendar2.stream()).forEach(meeting -> {
			for (int i = meeting.getStartIdx(); i < meeting.getEndIdx(); i++) {
				slotsCommon[i] = false;
			}
		});

		final List<StringMeeting> result = new ArrayList<>();

		int startIdx = -1;
		for (int i = 0; i < slotsCommon.length; i++) {
			if (slotsCommon[i] && startIdx == -1) {
				startIdx = i;
			}
			if (startIdx != -1 && !slotsCommon[i]) {
				int duration = i - startIdx;
				if (duration >= meetingDuration) {
					result.add(new StringMeeting(toHour(startIdx), toHour(i)));
				}
				startIdx = -1;
			}
		}

		return result;
	}

	static String toHour(int idx) {
		int hour = idx / 60;
		int minute = idx % 60;
		return hour + ":" + (minute < 10 ? "0" + minute : minute);
	}

	static class StringMeeting {

		public String start;

		public String end;

		public StringMeeting(String start, String end) {
			this.start = start;
			this.end = end;
		}

		public int getStartIdx() {
			int hour = Integer.parseInt(start.split(":")[0]);
			int minute = Integer.parseInt(start.split(":")[1]);

			return (hour * 60) + minute;
		}

		public int getEndIdx() {
			int hour = Integer.parseInt(end.split(":")[0]);
			int minute = Integer.parseInt(end.split(":")[1]);

			return (hour * 60) + minute;
		}
	}

	public static void main(String[] args) {
		System.out.println(Program.calendarMatching(
				Arrays.asList(
						new StringMeeting("9:00", "10:30"),
						new StringMeeting("12:00", "13:00"),
						new StringMeeting("16:00", "18:00")
				),
				new StringMeeting("9:00", "20:00"),
				Arrays.asList(
						new StringMeeting("10:00", "11:30"),
						new StringMeeting("12:30", "14:30"),
						new StringMeeting("14:30", "15:00"),
						new StringMeeting("16:00", "17:00")),
				new StringMeeting("10:00", "18:30"),
				30
		));
	}

}
