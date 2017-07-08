/**
	Just aped the solution from the editorial. This is not
real quicksort but rather looks like merge sort, where sorted 
arrays are merged into one another to sort the complete array
*/
import java.util.*;
import java.lang.*;
class Solution{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List list = new ArrayList(n);
		for(int i=0; i<n; i++){
			list.add(sc.nextInt());
		}
		sort(list);
	}
	
	static List<Integer> sort(List<Integer> list){
		int size = list.size();
		if(size <= 1)
			return list;
		List<Integer> left_list = new ArrayList<Integer>();
		List<Integer> right_list = new ArrayList<Integer>();
		List<Integer> equal_list = new ArrayList<Integer>();
		List<Integer> complete_list = new ArrayList<Integer>();
		int pivot = list.get(0);
		for(int i=1; i<size; i++){
			int curr = list.get(i);
			if(curr<pivot)
				left_list.add(curr);
			else if(curr > pivot)
				right_list.add(curr);
			else if(curr==pivot)
				equal_list.add(curr);
		}
		equal_list.add(pivot);
		complete_list.addAll(sort(left_list));
		complete_list.addAll(equal_list);
		complete_list.addAll(sort(right_list));
		String answer = Arrays.toString(complete_list.toArray()).replace("[","").replace("]","").replace(",","");
		System.out.println(answer);
		return complete_list;
	}
}
