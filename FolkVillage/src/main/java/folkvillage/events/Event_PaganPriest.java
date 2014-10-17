/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folkvillage.events;

import folkvillage.Village;

/**
 *
 * @author johannes
 */
public class Event_PaganPriest extends EventBase implements Event {

    public Event_PaganPriest(Village village) {
        super(village);
    }

    @Override
    public String getOption1Text() {
        return "Throw the priest out for his blasphemy";
    }

    @Override
    public String getOption2Text() {
        return "Let the priest stay";
    }

    @Override
    public String getOption3Text() {
        return "Burn the priest as an example";
    }

    @Override
    public String getOption4Text() {
        return "Let the priest stay for overnight, but insist he leave on the next day";
    }

    @Override
    public String getEventText() {
        return "A foreign priest and his followers have come to the village, preaching for abstinence and later marriage of girls.";
    }

    @Override
    public void executeOption1() {
        this.eventResultText = "The priest is thrown out. His teachings are quickly forgotten";
    }

    @Override
    public void executeOption2() {
        this.village.getPopulation().substractGrowthrate(0.05F);
        this.eventResultText = "The priest's preachings affect a small amount of your people, decreasing their fertility"; 
    }

    @Override
    public void executeOption3() {
        this.village.getPopulation().addPopulation(20);
        this.eventResultText = "As the shrieks of the pagan priest echo in your ears, 20 of his followers stay in your village";
    }

    @Override
    public void executeOption4() {
        this.village.getPopulation().subtractPopulation(5);
        this.eventResultText = "The priest agrees, leaving the next morning. 5 of your villagers, however, have been convinced by him and join his followers";
    }

    @Override
    public String getEventResultText() {
        return this.eventResultText;
    }
    
}
