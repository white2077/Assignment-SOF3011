import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lab2 {
    //input range a: 1 - 5 ; b: 4 - 8
    public int tong(int a, int b){
        return  a+b;
    }
    public int tich(int a, int b){
        return a*b;
    }
    public int giaiThua(int a){
        int giaiThua = 1;
        for (int i = 2; i <= a; i++) {
            giaiThua = giaiThua*i;
        }
        return giaiThua;
    }
    //Bai 1
    //BVA
    @Test
    void assertAEqual0BEqual3(){
        assertEquals(tong(0,3),3);
    }
    @Test
    void assertAEqual2BEqual5(){
        assertEquals(tong(2,5),2+5);
    }
    @Test
    void assertAEqual1BEqual4(){
        assertEquals(tong(1,4),1+4);
    }
    @Test
    void assertAEqual5BEqual8(){
        assertEquals(tong(5,8),5+8);
    }
    @Test
     void assertAEqual4BEqual7(){
        assertEquals(tong(4,7),4+7);
    }
    //EP int range >0 int range<0
    @Test
    void assertAEqualABIsPositiveNumber1(){
        assertEquals(tong(2,3),2+3);
    }
    @Test
    void assertAEqualABIsPositiveNumber2(){
        assertEquals(tong(5,1),5+1);
    }
    @Test
    void assertAEqualABIsPositiveNumber3(){
        assertEquals(tong(10,2),10+2);
    }
    @Test
    void assertAEqualABIsPositiveNumber4(){
        assertEquals(tong(3,2),3+2);
    }
    @Test
    void assertAEqualABIsPositiveNumber5(){
        assertEquals(tong(4,2),4+2);
    }

    //Bai 2
    //BVA
    @Test
    public void testTichWithZero() {
        int result = tich(0, 5);
        assertEquals(0, result);
    }

    @Test
    public void testTichWithNegativeNumbers() {
        int result = tich(4, -3);
        assertEquals(-12, result);
    }

    @Test
    public void testTichWithBothNegativeNumbers() {
        int result = tich(-2, -7);
        assertEquals(14, result);
    }

    @Test
    public void testTichWithPositiveNumbers() {
        int result = tich(10, 2);
        assertEquals(20, result);
    }

    @Test
    public void testTichWithNegativeZero() {
        int result = tich(-5, 0);
        assertEquals(0, result);
    }

    @Test
    public void testTichWithLargePositiveNumbers() {
        int result = tich(100000, 1);
        assertEquals(100000, result);
    }

    @Test
    public void testTichWithLargeNumbers() {
        int result = tich(9999, 9999);
        assertEquals(99980001, result);
    }

    @Test
    public void testTichWithPositiveAndNegativeNumbers() {
        int result = tich(123456, -789);
        assertEquals(-97484984, result);
    }

    @Test
    public void testTichWithNegativeNumbers2() {
        int result = tich(-98765, -4321);
        assertEquals(426764165, result);
    }

    @Test
    public void testTichWithZeroNumbers() {
        int result = tich(0, 0);
        assertEquals(0, result);
    }
}
