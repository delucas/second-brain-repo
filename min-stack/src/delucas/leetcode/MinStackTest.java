package delucas.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinStackTest {
    
    @Test
    void testMinStack() {
    	MinStack minStack = new MinStack();
    	
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        // Verificar que el mínimo es -3
        assertEquals(-3, minStack.getMin(), "El mínimo debe ser -3");

        minStack.pop();

        // Verificar que el elemento superior es 0
        assertEquals(0, minStack.peek(), "El elemento superior debe ser 0");

        // Verificar que el mínimo es -2
        assertEquals(-2, minStack.getMin(), "El mínimo debe ser -2");
    }
}
