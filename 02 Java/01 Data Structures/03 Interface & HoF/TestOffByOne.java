import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertTrue(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('1', '1'));
        assertTrue(offByOne.equalChars('@', '@'));
        assertFalse(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('1', '2'));
        assertFalse(offByOne.equalChars('@', '#'));
    }
}
