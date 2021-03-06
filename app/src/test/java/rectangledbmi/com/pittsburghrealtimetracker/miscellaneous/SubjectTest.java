package rectangledbmi.com.pittsburghrealtimetracker.miscellaneous;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import rx.observers.TestSubscriber;
import rx.subjects.ReplaySubject;

import static org.junit.Assert.assertEquals;

/**
 * <p>Testing how publish subjects work.</p>
 * <p>Created by epicstar on 10/11/16.</p>
 * @author Jeremy Jao
 */

public class SubjectTest {

    private ReplaySubject<Integer> testSubject;
    private final static int maxEmissions = 1000;

    @Before
    public void setUp() {
        testSubject = ReplaySubject.create();
    }

    /**
     * Test to confirm that subjects can work in a for-loop.
     * @see <a href="https://github.com/rectangle-dbmi/Realtime-Port-Authority/issues/290">Issue #290</a>
     */
    @Test
    public void testToggle() {
        for (int i=0;i<maxEmissions;++i) {
            testSubject.onNext(i);
        }
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        testSubject.subscribe(testSubscriber);
        List<Integer> events = testSubscriber.getOnNextEvents();
        assertEquals(maxEmissions, events.size());
        for (int i=0;i<maxEmissions;++i) {
            Integer event = events.get(i);
            assertEquals(i, event.intValue());
        }
    }
}
