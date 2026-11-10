
import java.util.*;
public class CheckSum{
	static String add(String a,String b,int m)
	{
		String result="";
		int carry=0;
		for(int i=m-1;i>=0;i--){
			int sum=(a.charAt(i)-'0')+(b.charAt(i)-'0')+carry;
			result=(sum%2)+result;
			carry=sum/2;
		}
		while(carry==1){
			String temp="";
			carry=0;
			for(int i=m-1;i>=0;i--){
				int sum=(result.charAt(i)-'0')+(i==m-1?1:0)+carry;
				temp=(sum%2)+temp;
				carry=sum/2;
			}
			result=temp;
		}
		return result;
	}
	static String complement(String a,int m)
	{
		String res="";
		for(int i=0;i<m;i++){
			if(a.charAt(i)=='0') res=res+'1';
			else res=res+'0';
		}
		return res;
	} 
	static String sender(String[] data,int k,int m){
		String sum=data[0];
		for(int i=1;i<k;i++){
			sum=add(sum,data[i],m);
		}
		return complement(sum,m);
	}
	static boolean receiver(String[] data,String checksum,int k,int m){
		String sum=checksum;
		for(int i=0;i<k;i++){
			sum=add(sum,data[i],m);
		}
		for(int i=0;i<m;i++){
			if(sum.charAt(i)!='1') return false;
		}
		return true;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no:of segments(k)");
		int k=sc.nextInt();
		System.out.println("enter no;of bits(m)");
		int m=sc.nextInt();
		System.out.println("enter input");
		String binaryData=sc.next();
		if(binaryData.length()!=k*m){
			 System.out.println("Invalid input length");
			 return;
		}
		String[] data=new String[k];
		for(int i=0;i<k;i++){
			data[i]=binaryData.substring(i*m,(i+1)*m);
		}
		String checksum=sender(data,k,m);
		System.out.println("sender checksum:"+checksum);
		boolean result=receiver(data,checksum,k,m);
		if(result) System.out.println("no error detected");
		else
			System.out.println("error detected");
	}
}
