package src.main.java;


public class ClockDisplay12Hour
{
    //Extend ClockDisplay for a 12 hour clock. This means you need to track AM/PM
    //Update all methods and parameters to accomodate this change
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private boolean isPM;
    private String display;
    
    public ClockDisplay12Hour(){
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(59);
        isPM = false;
        updateDisplay();
    }
    
    public ClockDisplay12Hour(int hour, int minute, boolean isPM) {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(59);
        setTime(hour, minute, isPM);
    }
    
    public void timeTick(){
        minutes.increment();
        if (minutes.getValue() == 0){
            hours.increment();
            if (hours.getValue() == 0)
                hours.setValue(1);
            else if (hours.getValue() == 12)
                isPM = !isPM;
        }
        updateDisplay();
    }
    
    public void setTime(int hour, int minute, boolean isPM){
        if (hour == 0){
            hours.setValue(12);
        } else{
            hours.setValue(hour);
        }
        minutes.setValue(minute);
        this.isPM = isPM;
        updateDisplay();
    }
    
    public String getTime(){
        return display;
    }
    
    private void updateDisplay(){
        String period = isPM ? " PM" : " AM";
        String output = "";
        
        output = hours.getDisplayValue();
        output = output + ":";
        output = output + minutes.getDisplayValue();
        output = output + period;
        
        display = output;
    }
}
