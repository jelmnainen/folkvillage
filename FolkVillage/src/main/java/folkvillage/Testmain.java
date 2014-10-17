package folkvillage;
import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import folkvillage.buildings.Treasury;
import folkvillageui.FolkVillageUI;
import folkvillageui.Testui;
import folkvillageui.FolkVillageTestUI;
import folkvillageui.TabbedUI;
import java.util.HashMap;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author sanho
 */
public class Testmain {
    
    public static void main(String[] args){
        
        Village village = new Village();
        Treasury treasury = village.getTreasury();
        HashMap<Resource, Integer> resources = treasury.getAllResources();
        
        
        for(Map.Entry<Resource, Integer> entry : resources.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
            
    }
    

}
