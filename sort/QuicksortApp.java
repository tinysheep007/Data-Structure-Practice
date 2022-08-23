package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuicksortApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter list of integers, comma separated: ");
        String liststr = sc.next();
        String[] items = liststr.split(",");
        Integer[] list = new Integer[items.length];
        for (int i=0; i < list.length; i++) {
            list[i] = Integer.parseInt(items[i]);
        }
        System.out.print("Enter insertion sort threshold: ");
        int ist = sc.nextInt();
        System.out.print("Before: ");
        System.out.println(Arrays.toString(list));
        
        Quicksort.sort(list, ist);
        
        System.out.print(" After: ");
        System.out.println(Arrays.toString(list)); 
	}
}
