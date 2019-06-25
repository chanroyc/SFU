public int caughtSpeeding(int speed, boolean isBirthday) {
/*
*Computes the result where int value 0= no ticket, 1= small ticket and 2 = big ticket
*If speed is 60 or less, result is 0. If speed is between 61-80, result is 1.
*If speed is 81 or more, the result is too. Unless it is on your birthday, your
*speed can be 5 higher.
*/
  int bonus = 0;
  if(isBirthday) {
    bonus = 5;
  }
  
  if(speed <= 60 + bonus) {
    return 0;
  } else if(speed > 60 + bonus && speed <= 80 + bonus) {
    return 1;
  } else if(speed > 80 + bonus) {
    return 2;
  } else {
    return -1;
  }
}