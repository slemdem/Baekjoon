import java.io.*;
import java.util.*;

class Jual implements Comparable<Jual>{
	int weight;
	int value;
	
	public Jual(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	@Override
	public int compareTo(Jual o) {
		return this.weight-o.weight;
	}
	
}
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jual[] juals = new Jual[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			juals[i] = new Jual(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int[] bag = new int[K];
		for(int i=0; i<K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(juals);
		Arrays.sort(bag);

		int j = 0;
        long result=0;
		PriorityQueue<Jual> pque = new PriorityQueue<>((j1, j2)->j2.value-j1.value);
		for(int b=0; b<K; b++) {
			while (j<N && juals[j].weight<=bag[b]) {
				pque.add(juals[j]);
				j++;
			}
			if(pque.isEmpty()) continue;
			result+=pque.poll().value;
			
		}
		
		System.out.println(result);
	}

}