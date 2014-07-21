import java.util.Scanner;


public class Calendar1 {
	public static void main(String[] arge)
	{
		
		System.out.printf("Year:");
		
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		
		System.out.printf("Month:");
		int month = scan.nextInt();
		
		MyCalendar MyCal = new MyCalendar(year, month);
		MyCal.GetCalender();
	}

}

class MyCalendar {
	
	private int year;
	private int month;
	private int FirstDay;
	
	
	public MyCalendar(int year, int month)
	{
		this.year = year;
		this.month = month;
		FirstDay = 1;
	}
	
	public  void GetCalender()
	{
		
		if((year > 0) && (month >= 1) && (month <= 12))
		{
			FirstDay(year);
			OutCalendar(year, month, FirstDay);
		}
		else
		{
			System.out.println("Format Error");
		}
	
		
		
		
	}
	
	private boolean isLeapYear(int year)
	{
		return ((year%400 == 0) || ((year%4 == 0) && (year%100 != 0)));
	}
	
	
	//find out what the day of week about the January 1st in the year  
	private void FirstDay(int year)
	{
		if(year >= 1990)
		{
			for(int iyear = 1990; iyear < year; iyear++)
			{
				if(isLeapYear(iyear))
				{
					FirstDay = (FirstDay + 366) %7;
				}
				else
				{
					FirstDay = (FirstDay + 365) %7;
				}
			}
		}
		else
		{
			for(int iyear = 1989; iyear >= year; iyear--)
			{
				if(isLeapYear(iyear))
				{
					FirstDay = 6 - ((6-FirstDay) + 366)%7;
				}
				else
				{
					FirstDay = 6 - ((6-FirstDay) + 365)%7;
				}
			}
		}
		
	}
	
	
	private void OutCalendar(int year, int month, int FirstDay)
	{
		int monthDay[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int space[] = {FirstDay, 0,0,0,0,0,0,0,0,0,0,0,0};
		String[] monthname = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Nonember", "December"};
		
		if(isLeapYear(year))
			monthDay[1] = 29;
		
		for(int i=0; i < month; i++)
		{
			space[i+1] = (space[i] + monthDay[i])%7;
		}
		
		
		System.out.println("Year:"+year+"       "+monthname[month-1]);
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
}
