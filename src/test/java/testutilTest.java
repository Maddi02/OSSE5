import de.hfu.util;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertTrue;

public class testutilTest {

    @Test
    public void istErstesHalbjahr()
    {
        boolean test = util.istErstesHalbjahr(5);
        assertTrue("This will succeed.", test);


        try {
            boolean testFalse = util.istErstesHalbjahr(13);
            assertTrue("This will succeed.", testFalse);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getStackTrace());
        }
    }

}
