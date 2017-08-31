package unittests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DoublyLinkedListTests.class, HTableTests.class, JavaQueueTests.class, 
	JavaStackTests.class })
public class AllTests {

}
