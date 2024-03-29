import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GenericStackTest {

    @Test
    @DisplayName("Test initializing with wrong argument: 0")
    void testInitialization_wrongArgument_0() {
        assertThrows(IllegalArgumentException.class, () -> new GenericStack<Integer>(0));
    }

    @Test
    @DisplayName("Test initializing with wrong arument: -5")
    void testInitialization_wrongArgument_minus5() {
        assertThrows(IllegalArgumentException.class, () -> new GenericStack<Integer>(-5));
    }

    @Test
    @DisplayName("Test pushing elements")
    @SuppressWarnings("unchecked")
    void testPush() throws StackOverflowException {
        GenericStack stack = new GenericStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int expectedSize = 3;
        int actualSize = stack.spaceTaken();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    @DisplayName("Test pushing too much items")
    @SuppressWarnings("unchecked")
    void testStackOverflow() throws StackOverflowException {
        GenericStack stack = new GenericStack(1);
        stack.push(1);
        assertThrows(StackOverflowException.class, () -> stack.push(2));
    }

    @Test
    @DisplayName("Test popping too much items")
    @SuppressWarnings("unchecked")
    void testStackUnderflow() throws StackUnderflowException, StackOverflowException {
        GenericStack stack = new GenericStack(1);
        stack.push(1);
        stack.pop();
        assertThrows(StackUnderflowException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("Test peeking")
    @SuppressWarnings("unchecked")
    void testStackPeek() throws StackOverflowException {
        GenericStack stack = new GenericStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(79);

        int expected = 79;
        assertEquals(expected, stack.peek());
    }

    @Test
    @DisplayName("Test popping elements from stack")
    @SuppressWarnings("unchecked")
    void testPop() throws StackOverflowException, StackUnderflowException {
        GenericStack stack = new GenericStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(15);

        int expected = 15;
        assertEquals(expected, stack.pop());
    }


    @Test
    @DisplayName("Test calculating space left")
    @SuppressWarnings("unchecked")
    void testSpaceLeft() throws StackOverflowException {
        GenericStack stack = new GenericStack(10);
        stack.push(5);
        stack.push(6);
        stack.push(98);

        int expected = 7;
        assertEquals(expected, stack.spaceLeft());
    }

}