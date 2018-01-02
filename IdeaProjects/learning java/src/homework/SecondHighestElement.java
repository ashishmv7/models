package homework;
import java.util.Arrays;
import java.util.Collections;

public class SecondHighestElement {
    public int secondHighestElement(int[]a){
      if(a.length>Integer.MAX_VALUE)  {
          throw new RuntimeException("size to large");
      }
      if(a.length==0){
          throw new RuntimeException("array does not exist");
      }
        if(a.length==1){
            throw new RuntimeException("array to small");
        }
      Arrays.sort(a);
      int result=a[a.length-2];
      return result;
    }
}
