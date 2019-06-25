public boolean cigarParty(int cigars, boolean isWeekend) {
//Returns boolean variable if number of cigars is between 40 and 60 or if it is the weekend the number of cigars>40
  if(!isWeekend && cigars >= 40 && cigars <= 60) {
    return true;
  } else if(isWeekend && cigars >= 40) {
    return true;
  } else {
    return false;
  }
}