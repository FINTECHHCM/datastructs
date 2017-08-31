package doublylinkedlisttests;
import doublylinkedlist.DoublyLinkedList;
import org.junit.Test;
import org.junit.Assert;

public class DoublyLinkedListTests {
	
	@Test
	public void ConstructorInitSize() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		
		int size = ll.size();
		
		Assert.assertEquals(0, size);
	}
	
}