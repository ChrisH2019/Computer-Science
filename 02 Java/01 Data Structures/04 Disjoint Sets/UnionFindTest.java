import org.junit.Test;
import static org.junit.Assert.*;

public class UnionFindTest {

    @Test
    public void testSizeOf() {
        UnionFind uf = new UnionFind(10);

        for (int i = 0; i < 10; i++) {
            assertEquals(1, uf.sizeOf(i));
        }

        uf.union(1, 0);
        assertEquals(0, uf.parent(1));
        assertTrue(uf.connected(0, 1));
        assertEquals(2, uf.sizeOf(0));
        assertEquals(2, uf.sizeOf(1));

        uf.union(0, 2);
        assertEquals(0, uf.parent(2));
        assertEquals(uf.parent(1), uf.parent(2));
        assertTrue(uf.connected(0, 2));
        assertTrue(uf.connected(1, 2));
        assertEquals(3, uf.sizeOf(0));
        assertEquals(3, uf.sizeOf(1));
        assertEquals(3, uf.sizeOf(2));

        uf.union(0, 3);
        assertEquals(0, uf.parent(3));
        assertEquals(uf.parent(2), uf.parent(3));
        assertTrue(uf.connected(0, 3));
        assertTrue(uf.connected(1, 3));
        assertTrue(uf.connected(2, 3));
        assertEquals(4, uf.sizeOf(0));
        assertEquals(4, uf.sizeOf(1));
        assertEquals(4, uf.sizeOf(2));
        assertEquals(4, uf.sizeOf(3));

        uf.union(0, 4);
        assertEquals(0, uf.parent(4));
        assertEquals(uf.parent(3), uf.parent(4));
        assertTrue(uf.connected(0, 4));
        assertTrue(uf.connected(1, 4));
        assertTrue(uf.connected(2, 4));
        assertTrue(uf.connected(3, 4));
        assertEquals(5, uf.sizeOf(0));
        assertEquals(5, uf.sizeOf(1));
        assertEquals(5, uf.sizeOf(2));
        assertEquals(5, uf.sizeOf(3));
        assertEquals(5, uf.sizeOf(4));

        uf.union(0, 5);
        assertEquals(0, uf.parent(5));
        assertEquals(uf.parent(4), uf.parent(5));
        assertTrue(uf.connected(0, 5));
        assertTrue(uf.connected(1, 5));
        assertTrue(uf.connected(2, 5));
        assertTrue(uf.connected(3, 5));
        assertTrue(uf.connected(4, 5));
        assertEquals(6, uf.sizeOf(0));
        assertEquals(6, uf.sizeOf(1));
        assertEquals(6, uf.sizeOf(2));
        assertEquals(6, uf.sizeOf(3));
        assertEquals(6, uf.sizeOf(4));
        assertEquals(6, uf.sizeOf(5));

        uf.union(7, 6);
        assertEquals(6, uf.parent(7));
        assertEquals(-2, uf.parent(6));
        assertTrue(uf.connected(6, 7));
        assertEquals(2, uf.sizeOf(6));
        assertEquals(2, uf.sizeOf(7));

        uf.union(6, 8);
        assertEquals(6, uf.parent(8));
        assertEquals(uf.parent(7), uf.parent(8));
        assertTrue(uf.connected(7, 8));
        assertEquals(3, uf.sizeOf(6));
        assertEquals(3, uf.sizeOf(7));
        assertEquals(3, uf.sizeOf(8));

        uf.union(8, 9);
        assertEquals(6, uf.find(9));
        assertEquals(uf.parent(8), uf.parent(9));
        assertTrue(uf.connected(9, 8));
        assertEquals(4, uf.sizeOf(6));
        assertEquals(4, uf.sizeOf(7));
        assertEquals(4, uf.sizeOf(8));
        assertEquals(4, uf.sizeOf(9));

        uf.union(0, 6);
        assertEquals(0, uf.parent(6));
        assertEquals(uf.parent(5), uf.parent(6));
        assertTrue(uf.connected(5, 7));
        assertTrue(uf.connected(5, 8));
        assertTrue(uf.connected(5, 9));
        assertEquals(10, uf.sizeOf(0));
        assertEquals(10, uf.sizeOf(9));
        assertEquals(10, uf.sizeOf(5));

    }

    @Test
    public void testParent() {
        UnionFind uf = new UnionFind((10));
        for (int i = 0; i < 10; i++) {
            assertEquals(-1, uf.parent(i));
        }
    }

    @Test
    public void testConnected() {
        UnionFind uf = new UnionFind(10);
        for (int i = 0; i < 9; i++) {
            assertFalse(uf.connected(i, i+1));
        }
    }

}
