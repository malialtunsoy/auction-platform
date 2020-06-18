import java.util.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.awt.*; 
import java.awt.event.*;


public class Timer
{
   LocalDateTime d1;
   LocalDateTime d2;
   long days, hours, minutes, seconds;

   public Timer( LocalDateTime d1, LocalDateTime d2 )
   {
      this.d1 = d1;
      this.d2 = d2;
      days = ChronoUnit.DAYS.between(d1, d2);
      hours = ChronoUnit.HOURS.between(d1, d2) - 24*days;
      minutes = ChronoUnit.MINUTES.between(d1, d2) - 24*60*days - 60*hours;
      seconds = ChronoUnit.SECONDS.between(d1, d2) - 24*60*60*days - 60*60*hours - 60*minutes;
      isTimeOver();
   }

   public String toString()
   {
      return "Days: "+days+"\nHours: "+hours+"\nMinutes: "+minutes+"\nSeconds: "
         +seconds;
   }

   public boolean isTimeOver()
   {
      if( seconds <= 0 && minutes <= 0 && hours <= 0 && days <= 0 )
      {
         System.out.println( "Time over" );
         //other end time events
         return true;
      }
      else 
         return false;
   }

}