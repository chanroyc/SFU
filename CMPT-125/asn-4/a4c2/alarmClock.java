public String alarmClock(int day, boolean vacation) {
/*
*Given a day of the week encoded as 0=Sun....6 = Sat, and boolean
*indicating if we are on cavation, returns a string indicating when the alarm
*clock should ring. Weekdays, alarm si "7:00" and weekend should be "10:00".
*Unless we are on vacation, then weekday is "10:00" and weekend is "off"
*/

  if(vacation) {
    if(day == 6 || day == 0) {
      return"off";
    } else {
      return "10:00";
    }
  } else {
    if(day == 6 || day == 0) {
      return "10:00";
    } else {
      return "7:00";
    }
  }
}