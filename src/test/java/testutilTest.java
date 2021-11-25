import de.hfu.util;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testutilTest {

    @Test
    public void istErstesHalbjahr()
    {
        boolean test = util.istErstesHalbjahr(5);
        boolean test1 = util.istErstesHalbjahr(6);
        boolean test2 = util.istErstesHalbjahr(1);
        boolean test3 = util.istErstesHalbjahr(7);
        boolean test4 = util.istErstesHalbjahr(12);

        assertTrue(test);
        assertTrue(test1);
        assertTrue(test2);
        assertFalse(test3); // sollte false sein
        assertFalse(test4);


        try{
            boolean test5 = util.istErstesHalbjahr(13);
            boolean test6 = util.istErstesHalbjahr(0);
            assertFalse(test6);
        }catch( IllegalArgumentException e)
        {
            System.out.println(e.getStackTrace());
            System.out.println("Invalid date ");
        }



    }

}
