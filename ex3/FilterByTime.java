package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {
	
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
		Date endDate = regularFormat.parse("2015-12-31 19:00:00");
		String filePath = "C:\\Users\\Colonnello\\Desktop\\data.txt";
		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			Pattern p = Pattern.compile("(\\d+.\\d+.\\d+.\\d+).*(\\[.*\\])");
			Matcher m = p.matcher(line);
			if(m.find()){
				String strIp = null;
				String strTime = null;
				strIp = m.group(1);
				String t[] = m.group(2).split(" ");
				strTime=t[0].substring(1, t[0].length());
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:SS",Locale.ENGLISH);
				date = df.parse(strTime);
				if(date.after(beginDate) && date.before(endDate)){
					System.out.println(strIp+"\t"+date);
				}
			}
		}
	}
	
}
