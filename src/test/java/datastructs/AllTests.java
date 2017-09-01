package datastructs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DoublyLinkedListTest.class, HTableTest.class, JavaQueueTest.class, 
	JavaStackTest.class, LRUCacheTest.class})
public class AllTests {

}
