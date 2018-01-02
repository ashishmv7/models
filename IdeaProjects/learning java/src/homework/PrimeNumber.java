package homework;

public class PrimeNumber {
    public int[] primeNumberTillN(int n)
    {
        if(n>Integer.MAX_VALUE){
            throw new RuntimeException("number to large");
        }
        if(n<0){
            throw new RuntimeException("wrong input");
        }int temp[]={0};
        if(n==0 || n==1){
          temp[0]=0;
          return temp;
        }
        int primenumber[]=new int[n];
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {

            if(prime[p] == true)
            {

                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        int j=0;
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true){


                primenumber[j]=i;
                j++;
            }

        }
        return primenumber;
    }
}
