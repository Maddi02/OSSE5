import de.hfu.Queue;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {



    @Test
    public void testQueue()
    {
       Queue queue = new Queue(3);
       queue.enqueue(187);
       queue.enqueue(361);
       queue.enqueue(11);
       queue.enqueue(12);
       assertEquals(187, queue.dequeue());
       assertEquals(361, queue.dequeue());
       assertEquals(12, queue.dequeue());

       try {
           queue.dequeue();
       }
       catch (IllegalStateException e) {
           System.out.println("Got exception");
       }


    }
}
