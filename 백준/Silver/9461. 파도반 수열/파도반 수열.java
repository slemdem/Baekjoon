import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<Long> nums = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		nums.add(1L);
		nums.add(1L);
		nums.add(1L);
		nums.add(2L);
		nums.add(2L);


		for(int i=0; i<T; i++){
			int n = Integer.parseInt(br.readLine());
			if(nums.size()<n){
				for (int j=nums.size()-1; j<n-1; j++){
					nums.add(nums.get(j)+nums.get(j-4));
				}
			}
			sb.append(nums.get(n-1)+"\n");
		}
		System.out.println(sb);
    }

}