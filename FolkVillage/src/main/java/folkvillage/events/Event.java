/*
 * Event interface; lists all functions necessary for a Event to work.
 */
package folkvillage.events;

/**
 *
 * @author johannes
 */
public interface Event {
    
    public String getOption1Text();
    
    public String getOption2Text();
    
    public String getOption3Text();
    
    public String getOption4Text();
    
    public String getEventText();
    
    public void executeOption1();
    
    public void executeOption2();
        
    public void executeOption3();
    
    public void executeOption4();
    
    public String getEventResultText();

}
