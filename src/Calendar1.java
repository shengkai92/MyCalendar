/********************************************************************
    FileName		[ Calendar1.java ]
    PackageName		[ MyCalendar ]
    JavaProjectName	[ MyCalendar ]
    Synopsis		[  ]
	Author			[ Sheng-Kai Chen ]
	Copyright		[ Copyleft(c) 2014 MITLAB, GIEE, NTUST, Taiwan ]
********************************************************************/
import java.util.Scanner;


public class Calendar1 {
	public static void main(String[] arge)
	{		

		MyCalendar MyCal = new MyCalendar();
			
	}

}

class MyCalendar {
	
	Scanner scan = new Scanner(System.in);
	int monthDay[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Nonember", "December"};
	String[] weekDayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Firday", "Saturday"};
	
	
	public MyCalendar()
	{
		FunctionNum();
	}
	
	
	private void FunctionNum()
	{
		boolean a;
		do
		{
			System.out.println("1. 判斷是否為閏年");
			System.out.println("2. 輸入年月傳回有幾天");
			System.out.println("3. 輸入年月日傳回星期幾");
			System.out.println("4. 輸入年月傳回整月");
			System.out.println("5. 輸入年 傳回有幾個六日");
			System.out.println("0. EXIT");
			System.out.printf("Select Function:");
			
			
			int functionNum = scan.nextInt();
			a = switchFunction(functionNum);
		}while(a);

	}
	
	private boolean switchFunction(int functionNum)
	{
		switch(functionNum)
		{	
			case 0:
				return false;
				
				
			//判斷是否為閏年
			case 1:   
				System.out.println();
				System.out.println("1. 判斷是否為閏年");
				
				System.out.printf("Year:");
				int year = scan.nextInt();
				
				
				if(judgeInputNumCorrectness(year,1,1))
				{
					System.out.println("The Input is error!");
					return ContinueOrExit();
				}
				
				if(isLeapYear(year))
					System.out.println(year+" is leap year.");
				else
					System.out.println(year+" is not leap year.");
				
				return ContinueOrExit();
				
				
			//輸入年月傳回有幾天
			case 2:
				System.out.println();
				System.out.println("2. 輸入年月傳回有幾天");
				
				System.out.printf("Year:");
				year = scan.nextInt();
				
				System.out.printf("month:");
				int month = scan.nextInt();
				
				if(judgeInputNumCorrectness(year,month,1))
				{
					System.out.println("The Input is error!");
					return ContinueOrExit();
				}
				
				System.out.println(monthName[month-1]+" has "+getMonthDay(year,month)+" in "+year);
				
				return ContinueOrExit();
				
			//輸入年月日傳回星期幾
			case 3:
				System.out.println();
				System.out.println("3. 輸入年月日傳回星期幾");
				
				System.out.printf("Year:");
				year = scan.nextInt();
				
				System.out.printf("Month:");
				month = scan.nextInt();
				
				System.out.printf("Day:");
				int day = scan.nextInt();
				
				if(judgeInputNumCorrectness(year,month,day))
				{
					System.out.println("The Input is error!");
					return ContinueOrExit();
				}
				
				int weekDay = (FirstDay(year,month) + day - 1) % 7;
				
				System.out.println("The day is "+weekDayName[weekDay]);
				
				return ContinueOrExit();
				
			//輸入年月傳回整月
			case 4:
				System.out.println();
				System.out.println("4. 輸入年月傳回整月");
				
				System.out.printf("Year:");
				year = scan.nextInt();
				
				System.out.printf("Month:");
				month = scan.nextInt();
				
				if(judgeInputNumCorrectness(year,month,1))
				{
					System.out.println("The Input is error!");
					return ContinueOrExit();
				}
				
				GetCalender(year,month);
				
				return ContinueOrExit();
			
			//輸入年 傳回有幾個六日
			case 5:
				System.out.println();
				System.out.println("5. 輸入年 傳回有幾個六日");
				
				System.out.printf("Year:");
				year = scan.nextInt();
				
				if(judgeInputNumCorrectness(year,1,1))
				{
					System.out.println("The Input is error!");
					return ContinueOrExit();
				}
				
				System.out.println("There're "+howManyHoliday(year)+" holiday in "+year);
				
				return ContinueOrExit();
			
			default:
				System.out.println("Input Error!");
				return ContinueOrExit();
					
		}
	}
	
	private boolean judgeInputNumCorrectness(int year, int month, int day)
	{
		if(year <= 0)
			return true;
		if(month <=0 || month > 12)
			return true;
		if(day <= 0 || day > getMonthDay(year,month))
			return true;
		
		return false;
	}
	
	private boolean ContinueOrExit()
	{
		System.out.printf("Continue/Exit (1/0):");
		int con = scan.nextInt();
		if(con == 1)
			return true;
		else
			return false;
	}
	
	
	/**************************************************************************
	method 
	**************************************************************************/
	
	
	private int getMonthDay(int year, int month)
	{
		int monthDay[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(isLeapYear(year))
			monthDay[1] = 29;
		
		return monthDay[month-1];
	}
	
	private boolean isLeapYear(int year)
	{
		return ((year%400 == 0) || ((year%4 == 0) && (year%100 != 0)));
	}
	
	private int FirstDay(int year, int month)
	{
		//find out the fisrt da of the year
		int firstDay = 1;
		if(year >= 1990)
		{
			for(int iyear = 1990; iyear < year; iyear++)
			{
				if(isLeapYear(iyear))
				{
					firstDay = (firstDay + 366) %7;
				}
				else
				{
					firstDay = (firstDay + 365) %7;
				}
			}
		}
		else
		{
			for(int iyear = 1989; iyear >= year; iyear--)
			{
				if(isLeapYear(iyear))
				{
					firstDay = 6 - ((6-firstDay) + 366)%7;
				}
				else
				{
					firstDay = 6 - ((6-firstDay) + 365)%7;
				}
			}
		}
		
		
		//find out the fisrt da of the month
		for(int i = 1; i < month; i++)
		{
			firstDay = (firstDay + getMonthDay(year,i)) % 7;
		}
		
		return firstDay;
	}
	
	private  void GetCalender(int year, int month)
	{
		
		if((year > 0) && (month >= 1) && (month <= 12))
		{
			
			OutCalendar(year, month, FirstDay(year,1));
		}
		else
		{
			System.out.println("Format Error");
		}	
		
	}
	
	private void OutCalendar(int year, int month, int FirstDay)
	{
		
		int space[] = {FirstDay, 0,0,0,0,0,0,0,0,0,0,0,0};
		
		
		if(isLeapYear(year))
			monthDay[1] = 29;
		
		for(int i=0; i < month; i++)
		{
			space[i+1] = (space[i] + monthDay[i])%7;
		}
		
		
		System.out.println("Year:"+year+"       "+monthName[month-1]);
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		
		for(int n = 1; n <= space[month-1]; n++)
			System.out.printf("    ");
		
		for(int n = 1; n <= monthDay[month-1]; n++)
		{
			System.out.printf("%3d",n);
			System.out.printf(" ");
			
			if(((space[month-1]+n-1)%7) == 6)
				System.out.printf("\n");
		}
		System.out.printf("\n");

	}
	
	private int howManyHoliday(int year)
	{
		int monthDay[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int holidayNum = 0;
		
		if(isLeapYear(year))
			monthDay[1] = 29;
		
		for(int i = 0; i < 12; i++)
		{
			int firstDay = FirstDay(year,i+1);
			for(int j = 1; j <= monthDay[i]; j++)
			{
				if((firstDay + j - 1) %7 == 6 || (firstDay + j - 1) %7 == 0)
					holidayNum++;
			}
		}
		
		return holidayNum;
	}
	
	
}


