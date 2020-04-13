import java.util.*;

import jdk.jfr.StackTrace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;


@RunWith(value=Parameterized.class)
public class PriorityQueueTest{

    private Integer [] input;
    private Integer [] answer;
    public PriorityQueueTest(Integer []i, Integer []a){
        input = i;
        answer = a;
    }
    @Parameterized.Parameters
    public static Collection getTestParameters() {
        return Arrays.asList(new Integer[][][] {
                {{20, 15, 14,100,150}, {14, 15, 20, 100, 150}},
                {{1,5,9,8,7},{9,8,7,5,1}},
                {{33,66,55,88,99},{33,55,66,88,99}},
                {{45,56,98,58,22},{22,45,56,58,98}},
                {{78,23,12,45,65},{12,23,45,65,78}}
        });
    }

    @Test
    public void test(){
        PriorityQueue pq = new PriorityQueue();
        for(int i = 0; i < 5; i++){
            pq.offer(input[i]);
        }
        for(int i = 0; i < 5; i++){
            assertEquals(answer[i], pq.poll());
            //System.out.println(answer[i]);
        }
    }

    @Test(expected = NullPointerException.class)
    public void OtherNullPointer() {
        Set<Integer> ss = new HashSet<Integer>();
        ss.add(null);
        PriorityQueue pq = new PriorityQueue(ss);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
        PriorityQueue pq = new PriorityQueue(-1,null);
    }

    @Test(expected = NullPointerException.class)
    public void NullPointer() {
        PriorityQueue pq = new PriorityQueue();
        pq.offer(null);
    }

}