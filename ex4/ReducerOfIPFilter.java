package No4;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class ReducerOfIPFilter {
	public static void main(String[] args){
		         Scanner scanner = new Scanner(System.in);
		         //使用set集合存放ip，保证没有重复ip地址，方便统计
		         Set<String> s = new HashSet<String>();
		         while (scanner.hasNext()){
		             String[] line = scanner.nextLine().split("\\t");
		             //将ip添加进Set集合
		             s.add(line[0]);
		        }
		         //直接输出集合ip的个数
		         System.out.println(s.size());
		     }
}
