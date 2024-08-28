import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class Micro {
	int id, x, y, amount, dir;

	public Micro(int id, int x, int y, int amount, int dir) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.amount = amount;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "Micro [id=" + id + ", x=" + x + ", y=" + y + ", amount=" + amount + ", dir=" + dir + "]";
	}
}

class Solution
{
	static HashMap<String,LinkedList<Integer>> overlay;
	static int[][] dxdy = {{}, {-1,0}, {1, 0},{0,-1},{0,1}};
	static int[][] board;
	static HashMap<Integer, Micro> micros;
	static int N;
	static StringBuilder sb = new StringBuilder();	
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			micros = new HashMap<>();
			
			for(int i=0; i<K;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				micros.put(i,new Micro(i, x, y, a, d));
			}
			overlay = new HashMap<>();
			LinkedList<Integer> removes = new LinkedList<>();
			for(int i=0; i<M; i++) {
				overlay.clear();
				removes.clear();
				for (Map.Entry<Integer, Micro> o : micros.entrySet()) {
					Micro m = o.getValue();
					m.x = m.x+dxdy[m.dir][0];
					m.y = m.y+dxdy[m.dir][1];
					
					if(m.x == 0 || m.x == N-1) {
						m.amount /= 2;
						if(m.dir==2) m.dir=1;
						else m.dir=2;
					}
					if(m.y == 0 || m.y == N-1) {
						m.amount /= 2;
						if(m.dir==4) m.dir=3;
						else m.dir=4;
					}
//					System.out.println(o.getValue().toString());
					
					if(m.amount == 0) {
						removes.add(o.getKey());
						continue;
					}
					
					String key = m.x+" "+m.y;
					if(overlay.containsKey(key)) {
						overlay.get(key).add(m.id);
					}else {
						LinkedList<Integer> value = new LinkedList<>();
						value.add(m.id);
						overlay.put(key, value);
					}
				}
				
				for (Entry<String, LinkedList<Integer>> o : overlay.entrySet()) {
//					System.out.println(o.getKey()+" "+Arrays.deepToString(o.getValue().toArray())+" "+o.getValue().size());
					if(o.getValue().size()>1) {
						LinkedList<Integer> ms = o.getValue();
						int thisid = 0;
						int max = 0;
						int sum = 0;
						for(int id: ms) {
							Micro m = micros.get(id);
							sum += m.amount;
							if (m.amount>max) {
								max = m.amount;
								thisid = m.id;
								removes.add(id);
							} else removes.add(id);
						}
						removes.remove((Integer) thisid);
						micros.get(thisid).amount = sum;
					}
				}
				for (int id: removes) micros.remove(id);
			}
			
			int sum = 0;
			for (Map.Entry<Integer, Micro> o : micros.entrySet()) {
//				System.out.println(o.getValue().toString());
				sum += o.getValue().amount;
			}
			
			sb.append("#"+test+" "+sum+"\n");
		}
		System.out.println(sb);
	}
}