import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
//		String[] operations = {"I 16","D 1"}; // return {0,0}
		String[] operations = {"I 16","I -1","I 18", "D 1", "I 3"}; // return {0,0}
		
//		String[] operations = {"I 7","I 5","I -5","D -1"}; // return {7,5}
		
		System.out.println(Arrays.toString(new Solution().solution(operations)));
	}

}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (String operation: operations) {
        	if (operation.charAt(0) == 'I') {
        		q.add(Integer.parseInt(operation.split(" ")[1]));
        	} else { // 'D'
        		if (q.isEmpty()) continue;
        		String dir = operation.split(" ")[1];
        		if (dir.equals("1")) {
        			List<Integer> temp = new ArrayList<>();
        			while(!q.isEmpty())
        				temp.add(q.poll());
        			q.addAll(temp.subList(0, temp.size()-1));
        		} else if (dir.equals("-1")) {
        			q.poll();
        		}
        	}
        }
        if (!q.isEmpty()) {
            answer[1] = q.poll();
            answer[0] = answer[1];
            while(!q.isEmpty())
            	answer[0] = q.poll();        	
        }
        return answer;
    }
}
