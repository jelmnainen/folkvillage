/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folkvillage;

/**
 *
 * @author sanho
 */
public enum BuildingStatus {
    
    /**
     * A working building will perform it's assigned functions
     */
    WORKING,
    
    /**
     * A damaged building will only have repair function available
     */
    DAMAGED,
    
    /**
     * A building under repair will recieve an amount of HP each turn. It won't
     * work until the repairs have finished
     */
    UNDER_REPAIR,

    /**
     * If a building is under construction, it won't be able to work
     * but will recieve an amount of HP every turn
     */
    UNDER_CONSTRUCTION
}
