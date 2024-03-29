import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericHashTableTest {

    @Test
    @DisplayName("Test add")
    void testAdd() {
        GenericHashTable<String, Integer> table = new GenericHashTable<>();
        table.add("Five", 5);
        assertEquals(1, table.size());
    }

    @Test
    @DisplayName("Test remove")
    void testRemove() {
        GenericHashTable<String, Integer> table = new GenericHashTable<>();
        table.add("Five", 5);
        table.add("Six", 6);
        int size = table.size();
        table.remove("Five");
        assertEquals(size - 1, table.size());
    }

    @Test
    @DisplayName("Test get with String-Integer pair")
    void testGet() {
        GenericHashTable<String, Integer> table = new GenericHashTable<>();
        table.add("Five", 5);
        table.add("Six", 6);
        table.add("Seven", 7);
        assertEquals((Integer) 6, table.get("Six"));
    }

    @Test
    @DisplayName("Test clear")
    void testClear() {
        GenericHashTable<String, Integer> table = new GenericHashTable<>();
        table.add("One", 1);
        table.add("Two", 2);
        table.add("Three", 3);
        table.clear();
        assertEquals(0, table.size());
    }

    @Test
    @DisplayName("Test get with String-String pair")
    void testGet_TypeString() {
        GenericHashTable<String, String> table = new GenericHashTable<>();
        table.add("Ala", "ma Asa");
        table.add("Sierotka", "ma Rysia");
        assertEquals("ma Rysia", table.get("Sierotka"));
    }

    @Test
    @DisplayName("Test add with repeated keys")
    void testAdd_repeatedKeys() {
        GenericHashTable<String, Integer> table = createOverridingTable();
        assertEquals(1, table.size());
    }

    @Test
    @DisplayName("Test overwriting keys")
    void testAdd_overwriteKeys() {
        GenericHashTable<String, Integer> table = createOverridingTable();
        assertEquals((Integer) 3, table.get("One"));
    }

    private GenericHashTable<String, Integer> createOverridingTable() {
        GenericHashTable<String, Integer> table = new GenericHashTable<>();
        table.add("One", 1);
        table.add("One", 2);
        table.add("One", 3);
        return table;
    }

}