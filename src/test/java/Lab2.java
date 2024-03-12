import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lab2 {
    //input range a: 1 - 5 ; b: 4 - 8
    public int addition(int a, int b){
        return  a+b;
    }
    public int multiplication(int a, int b){
        return a*b;
    }
    public int factorial(int a){
        int giaiThua = 1;
        for (int i = 2; i <= a; i++) {
            giaiThua = giaiThua*i;
        }
        return giaiThua;
    }

    //bai 1  a 2 - 5 và b 7 - 10
    //BVA
    @Test
    public void testAdditionBVA() {
        // Test case 1: Cận dưới của a và cận dưới của b
        assertEquals(9, addition(2, 7));

        // Test case 2: Giá trị biên dưới của a và cận dưới của b
        assertEquals(10, addition(5, 5));

        // Test case 3: Giá trị biên trên của a và cận dưới của b
        assertEquals(15, addition(5, 10));

        // Test case 4: Cận trên của a và cận dưới của b
        assertEquals(14, addition(5, 9));

        // Test case 5: Giá trị biên trên của a và cận dưới của b
        assertEquals(16, addition(5, 11));

        // Test case 6: Cận dưới của a và giá trị biên dưới của b
        assertEquals(10, addition(2, 8));

        // Test case 7: Giá trị biên dưới của a và giá trị biên dưới của b
        assertEquals(9, addition(3, 6));

        // Test case 8: Giá trị biên trên của a và giá trị biên dưới của b
        assertEquals(14, addition(5, 9));

        // Test case 9: Cận trên của a và giá trị biên dưới của b
        assertEquals(13, addition(4, 9));

        // Test case 10: Giá trị biên trên của a và giá trị biên dưới của b
        assertEquals(15, addition(5, 10));
    }
    //EP
    @Test
    public void testAdditionEp() {
        // Test case 1: Số dương và số dương
        assertEquals(4, addition(2, 2));

        // Test case 2: Số âm và số âm
        assertEquals(-5, addition(-2, -3));

        // Test case 3: Số dương và số âm
        assertEquals(3, addition(5, -2));

        // Test case 4: Số âm và số dương
        assertEquals(-3, addition(-5, 2));

        // Test case 5: Số dương và số dương, giá trị biên dưới
        assertEquals(1, addition(0, 1));

        // Test case 6: Số âm và số âm, giá trị biên trên
        assertEquals(-100, addition(-50, -50));

        // Test case 7: Số dương và số âm, giá trị biên dưới
        assertEquals(-2147483647, addition(-2147483648, 1));

        // Test case 8: Số âm và số dương, giá trị biên trên
        assertEquals(2147483646, addition(2147483647, -1));

        // Test case 9: Số dương và số âm, giá trị biên tương đương
        assertEquals(0, addition(2147483647, -2147483647));

        // Test case 10: Số âm và số dương, giá trị biên tương đương
        assertEquals(0, addition(-2147483647, 2147483647));
    }
    //Bai 2
    //BVA
    @Test
    public void testMultiplication() {
        // Test case 1: Số dương và số dương
        assertEquals(6, multiplication(2, 3));

        // Test case 2: Số âm và số âm
        assertEquals(15, multiplication(-3, -5));

        // Test case 3: Số dương và số âm
        assertEquals(-10, multiplication(2, -5));

        // Test case 4: Số âm và số dương
        assertEquals(-8, multiplication(-2, 4));

        // Test case 5: Số dương và số dương, giá trị biên dưới
        assertEquals(0, multiplication(0, 1));

        // Test case 6: Số âm và số âm, giá trị biên trên
        assertEquals(2147483647, multiplication(-2147483647, -1));

        // Test case 7: Số dương và số âm, giá trị biên dưới
        assertEquals(-2147483647, multiplication(-2147483647, 1));

        // Test case 8: Số âm và số dương, giá trị biên trên
        assertEquals(-2147483647, multiplication(2147483647, -1));

        // Test case 9: Số dương và số âm, giá trị biên tương đương
        assertEquals(0, multiplication(2147483647, 0));

        // Test case 10: Số âm và số dương, giá trị biên tương đương
        assertEquals(-2147483647, multiplication(-2147483647, 1));
    }
    //bai 3
    //BVA
    @Test
    public void testFactorial1() {
        // Test case 1: Giai thừa của a 2  => 7
        assertEquals(2, factorial(2));

        // Test case 2: Giai thừa của a = 3 và b = 8
        assertEquals(6, factorial(3));

        // Test case 3: Giai thừa của a = 4 và b = 9
        assertEquals(24, factorial(4));

        // Test case 4: Giai thừa của a = 5 và b = 10
        assertEquals(120, factorial(5));

        // Test case 5: Giai thừa của a = 2 và b = 10, giá trị biên dưới
        assertEquals(2, factorial(2));

        // Test case 6: Giai thừa của a = 5 và b = 7, giá trị biên trên
        assertEquals(120, factorial(5));

        // Test case 7: Giai thừa của a = 3 và b = 7, giá trị biên tương đương
        assertEquals(6, factorial(3));

        // Test case 8: Giai thừa của a = 4 và b = 10, giá trị biên tương đương
        assertEquals(24, factorial(4));

        // Test case 9: Giai thừa của a = 2 và b = 8, giá trị biên tương đương
        assertEquals(2, factorial(2));

        // Test case 10: Giai thừa của a = 5 và b = 9, giá trị biên tương đương
        assertEquals(120, factorial(5));
    }
    //EP
    @Test
    public void testFactorial2() {
        // Test case 1: Giai thừa của số dương (a = 5)
        assertEquals(120, factorial(5));

        // Test case 2: Giai thừa của số dương (a = 10)
        assertEquals(3628800, factorial(10));

        // Test case 3: Giai thừa của số dương, giá trị biên dưới (a = 1)
        assertEquals(1, factorial(1));

        // Test case 4: Giai thừa của số dương, giá trị biên trên (a = 20)
        assertEquals(2432902008176640000L, factorial(20));

        // Test case 5: Giai thừa của số âm (a = -5)
        assertEquals(-1, factorial(-5));

        // Test case 6: Giai thừa của số âm (a = -10)
        assertEquals(-1, factorial(-10));

        // Test case 7: Giai thừa của số âm, giá trị biên dưới (a = -1)
        assertEquals(-1, factorial(-1));

        // Test case 8: Giai thừa của số âm, giá trị biên trên (a = -20)
        assertEquals(-1, factorial(-20));

        // Test case 9: Giai thừa của số dương, giá trị biên tương đương (a = 2)
        assertEquals(2, factorial(2));

        // Test case 10: Giai thừa của số dương, giá trị biên tương đương (a = 15)
        assertEquals(1307674368000L, factorial(15));
    }

}
