public class Test
{
    public static void main(String args[])
    {
        int num1 = 160;
        System.out.println("Num1: "+Integer.toBinaryString(num1));
        int num2 = 240;
        System.out.println("Num2: "+Integer.toBinaryString(num2));
        num2 = num2 >> 4;
        System.out.println("Shifted Num2: "+Integer.toBinaryString(num2));
        int newNum = num1 | num2;
        System.out.println("New combined num: "+Integer.toBinaryString(newNum));
        
        int reShiftedNum2 = (newNum & (newNum >> 4));
        System.out.println("Combined num shifted back to num2: "+Integer.toBinaryString(reShiftedNum2));
        int reShiftedNum1 = (newNum & (newNum << 4)); 
        System.out.println("Combined num shifted back to num1: "+Integer.toBinaryString(reShiftedNum1));
    }
}