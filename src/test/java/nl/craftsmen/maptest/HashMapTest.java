package nl.craftsmen.maptest;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    private static final int NUMBER_OF_ELEMENTS = 30000;

    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    private Map<MyKey, MyElement> mapUnderTest = new HashMap<>();

    @Test
    @PerfTest(invocations = 5)
    @Required(max = 1200, average = 250)
    public void testMapPerformance() {
        fillMap();
        findRandomElement();
    }

    private void findRandomElement() {
        MyKey myKeySearch = new MyKey();
        myKeySearch.setSleuteltje("4545");
        mapUnderTest.get(myKeySearch);
    }

    private void fillMap() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            MyKey myKey = new MyKey();
            myKey.setSleuteltje(String.valueOf(i));
            MyElement myElement = new MyElement();
            myElement.setWaarde(String.valueOf(i));
            mapUnderTest.put(myKey, myElement);
        }
    }
}
