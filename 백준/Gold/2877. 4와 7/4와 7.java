import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = Integer.toBinaryString(Integer.parseInt(br.readLine())+1).replace('0','4').replace('1', '7');
		for(int i=1;i<s.length();i++) 
			bw.write(s.charAt(i));
		
		bw.flush();
		bw.close();
	}
}