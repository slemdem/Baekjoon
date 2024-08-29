import java.io.*;
import java.util.*;

class Solution
{
	static int N, size, min, room[][], stair[][];
	static ArrayList<int[]> people;
	static boolean[] selection;
	static StringBuilder sb = new StringBuilder();
	static Comparator<Integer> compareInt = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1-o2;
		}
	};
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test=1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			stair = new int[2][];
			int ptr = 0;
			people = new ArrayList<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
					if(room[i][j]==1) {
						people.add(new int[]{i, j});
					}else if(room[i][j]>1) {
						stair[ptr++] = new int[] {i,j,room[i][j]};
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			size =people.size();
			selection = new boolean[size];
			
			subset(0);
			
			sb.append("#"+test +" "+(min+1)+"\n");
		}
		System.out.println(sb);
	}

	private static void subset(int i) {
		if(i==size) {
			PriorityQueue<Integer> stair1 = new PriorityQueue<>();
			PriorityQueue<Integer> stair2 = new PriorityQueue<>();
//			System.out.println(Arrays.toString(selection));
			for(int idx = 0; idx<size; idx++) {
				int[] person = people.get(idx);
				if(selection[idx])
					stair1.add(Math.abs(person[0] - stair[0][0])+Math.abs(person[1] - stair[0][1]));
				else
					stair2.add(Math.abs(person[0] - stair[1][0])+Math.abs(person[1] - stair[1][1]));
			}
			
			int time = 0;
			int curmax = 0;
			LinkedList<Integer> onstair1 = new LinkedList<>();
			LinkedList<Integer> onstair2 = new LinkedList<>();
//			System.out.println(Arrays.toString(stair1.toArray())+ " "+Arrays.toString(stair2.toArray()));
			while (!stair1.isEmpty() || !stair2.isEmpty()) {
				time++;
				while (!onstair1.isEmpty()&&onstair1.peek()<=time) {
					onstair1.pollFirst();
				}
				while (!onstair2.isEmpty()&&onstair2.peek()<=time) {
					onstair2.pollFirst();
				}
				
				while(!stair1.isEmpty() && stair1.peek()<=time && onstair1.size()<3) {
					stair1.poll();
					onstair1.add(time+stair[0][2]);
					if(curmax<time+stair[0][2]) curmax = time+stair[0][2];
				}
				while(!stair2.isEmpty() && stair2.peek()<=time && onstair2.size()<3) {
					stair2.poll();
					onstair2.add(time+stair[1][2]);
					if(curmax<time+stair[1][2]) curmax = time+stair[1][2];
				}
//				System.out.println(Arrays.toString(onstair1.toArray())+ " "+Arrays.toString(onstair2.toArray()));
			}
//			System.out.println(curmax);
			min = Math.min(min, curmax);
			return;
		}
		selection[i] = true;
		subset(i+1);
		selection[i] = false;
		subset(i+1);
	}
}