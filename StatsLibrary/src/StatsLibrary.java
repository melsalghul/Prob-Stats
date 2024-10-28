import java.util.ArrayList;
import java.util.Collections;
	
public class StatsLibrary {
	public double findMean(ArrayList<Integer> numsList) {
		int sum = 0;
		for(int singleNumber : numsList) {
			sum = sum + singleNumber;
		}
		
		return sum/numsList.size();
	}
	
	public double findMedian(ArrayList<Integer> numsList) {
		Collections.sort(numsList);
		
		if(numsList.size()%2 == 0)
		{
			System.out.println(numsList.size()%2);
			double num1 = numsList.get(numsList.size()/2-1);
			System.out.println(num1);
			double num2 = numsList.get(numsList.size()/2);
			System.out.println(num2);
			return (num1+num2)/2;
		}
		else 
			return numsList.get(numsList.size()/2);
		//if odd, pick middle number
		//if even, take middle 2 and divide, return quotient/ middle num, middle num + 1
	}
	
	public double findMode(ArrayList<Integer> numsList) {
		double mode = -1;
		double count = 0;
		
		for(int x = 0; x < numsList.size(); x++) {
			int tempCount = 0;
			for(int y = x + 1; y < numsList.size(); y++) {
				if(numsList.get(x) == numsList.get(y))
					tempCount++;
			}
			
			if(tempCount > count) {
				count = tempCount;
				mode = numsList.get(x);
			}
		
		}
		
		return mode; //if mode is none there is no mode.
	}
	
	public double standardDev(ArrayList<Integer> numsList) {
		double standardDev = 0;
		
		for(int x = 0; x < numsList.size(); x++)
			standardDev += Math.pow(numsList.get(x) - findMean(numsList), 2);
			
		return standardDev;
	}
}

/*
* write a class named StatsLibrary
* methods: find mean, find median, find mode, find standardDeviation(someList)
* NOTE: you will be adding to this library the entire semester--
* keep it up to date and well documented.
*/