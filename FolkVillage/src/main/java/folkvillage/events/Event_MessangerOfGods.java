/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folkvillage.events;

import folkvillage.Village;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johannes
 */
public class Event_MessangerOfGods extends EventBase implements Event {

    public Event_MessangerOfGods(Village village) {
        super(village);
        this.eventName = "Messanger of Gods";
    }
    
    public String getOption1Text(){
        return "The Gods have no rule here. Throw the man out in the woods.";
    }
    
    public String getOption2Text(){
        return "Give the man a few days worth of supplies and send him away";
    }
    
    public String getOption3Text(){
        return "Throw a feast in honor of the arriving Messanger";
    }
    
    public String getOption4Text(){
        return "Invite the man to stay at your village. Surely having a Messanger of Gods will bring good fortune to your village";
    }
    
    public String getEventText(){
        return "A man claiming to be a messenger from the Gods appears at your gates. He demands to be fed and promises to get you in the good fortunes of gods, depending on how you answer.";
    }
    
    public void executeOption1(){
        try {
            this.village.getPopulation().dividePopulation(0.05F);
        } catch (Exception ex) {
            Logger.getLogger(Event_MessangerOfGods.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.eventResultText = "The gods become angry at you for sending their Messenger away! Soon your people start getting mysteriously ill and dying.";
    }
    
    public void executeOption2(){
        this.eventResultText = "Few moons have passed since the visit of the Messenger. Nothing has happened, so you shrug the worries off your shoulders.";
    }
    
    public void executeOption3(){
        this.village.getPopulation().addPopulation(50);
        this.eventResultText = "After having a few too many gallons of fire wine, the messanger declares: 'The Gods shall look upon this village, and joice of it's pious folk!'. During the following moon cycle you get the feeling that your village experienced a lot less stillbirths.";
    }
    
    public void executeOption4(){
        this.village.getPopulation().addGrowthrate(0.05F);
        this.eventResultText = "The Messenger settles in. The next harvest is bountiful, making feeding the children easy.";
    }

    @Override
    public String getEventResultText() {
        return this.eventResultText;
    }
    
    
}
