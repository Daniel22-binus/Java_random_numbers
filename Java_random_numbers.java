```Java
/*package whatever //do not write package name here */

import java.io.*;
import java.util.Arrays;

public class GFG {

    public static double[] getRandNumb(int n){

        double [] randArray= new double[n];
        for (int i = 0; i < randArray.length; i++)
        {
            randArray[i] = Math.random();
        }
        return randArray;
    }

    public static double getsum(double []randArray,double sum){
        
        for (int i = 0; i < randArray.length; i++)
        {
           sum+=randArray[i];
        }
        return sum;
    }
    public static double[] getRandDistArray(int n, double m, double min)
    {
        double sum = 0;
        double[] randArray;
       // Generate n random numbers
        randArray= getRandNumb(n);
        sum=getsum(randArray,sum);
        // check number value
        int cnt = 0;
        while (true)
        {
            if ((randArray[cnt] / sum * m) < min)
            {
                sum -= randArray[cnt];    
                randArray[cnt] = Math.random();
                sum += randArray[cnt];
                cnt = -1;
            }
        
            cnt++;
            if (cnt >= randArray.length)
            {
                break;
            }
            
        }

        // Normalize sum to m
        for (int i = 0; i < randArray.length; i++)
        {
            randArray[i] /= sum;
            randArray[i] *= m;
        }
        return randArray;
    }
    
    public static void main (String[] args) {
        double sum[] = getRandDistArray(50, 1, 0.0001);
        Arrays.sort(sum);
        System.out.println(Arrays.toString(sum));
    }
}