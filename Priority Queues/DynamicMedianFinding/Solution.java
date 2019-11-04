import java.lang.*;
import java.util.*;
class Solution{
	public static double[] dynamicMedian(double[] arr){
		int len = arr.length;
		MinPQ<Double> minpq = new MinPQ<Double>(len);
        MaxPQ<Double> maxpq = new MaxPQ<Double>(len);
        double median = 0;
        double med = new double[len];
        for(int i=0;i <med.length;i++){
        	med[i] = 0;
        }

        int size = 0;
        for (int i = 0; i < count; i++) {
            	double input = arr[i];

            if (input > median) {
                minpq.insert(input);
            } else {
                maxpq.insert(input);
            }

            if (maxpq.size() - minpq.size() > 1) {
                float input1 = maxpq.delMax();
                minpq.insert(input1);
            }

            if (minpq.size() - maxpq.size() > 1) {
                float input2 = minpq.delMin();
                maxpq.insert(input2);
            }
            if (minpq.size() == maxpq.size()) {
                median = (minpq.min() + maxpq.max()) / 2;
                med[size++]=median;
            }
            
            if (maxpq.size() > minpq.size()) {
                median = maxpq.max();
                System.out.println(median);
            }
            if (minpq.size() > maxpq.size()) {
                median = minpq.min();
                System.out.println(median);
            }
        }

		return arr;
	}
}