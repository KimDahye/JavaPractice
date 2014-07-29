package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class RowTest {
	
	@Test
	public void testDrawLineAndMove() {
		Row row = new Row(3);
		row.DrawLine(1);
		row.DrawLine(2);
		row.DrawLine(0);
		
		assertEquals(2, row.Move(1));
		assertEquals(0, row.Move(0));
		assertEquals(1, row.Move(2));
		row.Move(-1);
	}
	
	
}
