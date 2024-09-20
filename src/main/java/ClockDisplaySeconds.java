package src.main.java;


public class ClockDisplaySeconds
{
    //Extend ClockDisplaySeconds to include a seconds field.
    private NumberDisplay seconds;
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String display;
    //Update all methods and parameters to accomodate this change
    public ClockDisplaySeconds(){
        hours = new NumberDisplay(23);
        minutes = new NumberDisplay(59);
        seconds = new NumberDisplay(59);
        updateDisplay();
    }
    
    public ClockDisplaySeconds(int hour, int minute, int second){
        hours = new NumberDisplay(23);
        minutes = new NumberDisplay(59);
        seconds = new NumberDisplay(59);
        setTime(hour, minute, second);
    }
    
    public void timeTick(){
        seconds.increment();
        if (seconds.getValue() == 0){
            minutes.increment();
        if (minutes.getValue() == 0){
            hours.increment();
            }
        }
        updateDisplay();
    }
    //Implement a method setTime that takes in 2 parameters, hour and minute
    //The method should set the hours value and minutes value
    //The updateDisplay method should be called before finishing
    public void setTime(int hour, int minute, int second){
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        updateDisplay();
    }
    
    public String getTime(){
        return display;
    }
    
    public void updateDisplay(){
        String output = "";
        
        output = hours.getDisplayValue();
        output = output + ":";
        output = output + minutes.getDisplayValue();
        output = output + ":";
        output = output + seconds.getDisplayValue();
        
        display = output;
    }
}
