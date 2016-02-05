public class Test
{
    public static void main(String args[])
    {
        int R = 24;
        int G = 1;
        int B = 100;
        int RGB = (R)|(G<<8)|(B<<16);
        System.out.println("RGB vals as one 16-bit int in binary: "+Integer.toBinaryString(RGB));
        
        int newR =  RGB & 0xFF;
        int newG = (RGB & 0xFF00) >> 8;
        int newB =  RGB >> 16;
        System.out.println("Unpacked 16-bit RGB\nR: "+newR+"\nG: "+newG+"\nB: "+newB);
    }
}