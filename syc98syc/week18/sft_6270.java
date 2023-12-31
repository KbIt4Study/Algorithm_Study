import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GBC {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String token[] = br.readLine().split(" ");
		int n = Integer.parseInt(token[0]);
		int m = Integer.parseInt(token[1]);
		int[][] array1=new int[n][2]; 
		int[][] array2=new int[m][2]; 
		for(int i=0; i<n; i++) {
			String temp[] = br.readLine().split(" ");
			array1[i][0]=Integer.parseInt(temp[0]);
			array1[i][1]=Integer.parseInt(temp[1]);
		}
		for(int i=0; i<m; i++) {
			String temp[] = br.readLine().split(" ");
			array2[i][0]=Integer.parseInt(temp[0]);
			array2[i][1]=Integer.parseInt(temp[1]);
		}
		
		int[] sN=new int[n+1];
		sN[0]=0;
		for(int i=0; i<n; i++) {
			sN[i+1]=sN[i]+array1[i][0];
		}
		int[][] a=new int[101][2];
		int index=0;
		while(index<=100) {
			a[index][0]=index;
			if(index<=sN[1])
				a[index][1]=array1[0][1];
			else if(index>sN[n-1])
				a[index][1]=array1[n-1][1];
			else {
				for(int i=1;i<n-1;i++) {
					if(index>sN[i]&&index<=sN[i+1])
						a[index][1]=array1[i][1];
				}
			}
			index++;
		}
		int[] sM=new int[m+1];
		sM[0]=0;
		for(int i=0; i<m; i++) {
			sM[i+1]=sM[i]+array2[i][0];
		}
		int[][] b=new int[101][2];
		index=0;
		while(index<=100) {
			b[index][0]=index;
			if(index<=sM[1])
				b[index][1]=array2[0][1];
			else if(index>sM[m-1])
				b[index][1]=array2[m-1][1];
			else {
				for(int i=1;i<m-1;i++) {
					if(index>sM[i]&&index<=sM[i+1])
						b[index][1]=array2[i][1];
				}
			}
			index++;
		}
  
		int result=0;
		for(int i=0;i<=100;i++) {
			if(b[i][1]-a[i][1]>result)
				result=b[i][1]-a[i][1];
			}
		System.out.println(result);
		}
}
