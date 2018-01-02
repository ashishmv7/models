package homework;

public class Gcd {
    public int gcdOfTwoNumbers(int a,int b){
       if(a>Integer.MAX_VALUE || b>Integer.MAX_VALUE){
           throw new RuntimeException("number to large");
       }
        if(a<Integer.MIN_VALUE|| b<Integer.MIN_VALUE){
            throw new RuntimeException("number to large");
        }

        if (a == 0 || b == 0)
        {
            return 0;

        }


        if (a == b){
            return a;
        }


        if (a > b){
            return gcdOfTwoNumbers(a-b, b);
        }
        return gcdOfTwoNumbers(a, b-a);
    }
}
