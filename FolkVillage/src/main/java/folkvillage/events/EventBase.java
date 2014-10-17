package folkvillage.events;

import folkvillage.Village;
import java.util.ArrayList;

/**
 * Dumb abstraction of Village, holds the necessary class variables
 * 
 * 
 * @author sanho
 */
public abstract class EventBase {
    
    protected Village village;
    protected String eventResultText;
    protected String eventName;
    
    public EventBase(Village village){
        this.village = village;
    }
        
}
