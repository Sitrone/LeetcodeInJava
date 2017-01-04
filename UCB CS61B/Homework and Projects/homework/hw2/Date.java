package com.cs61b.hw2;

public class Date
{
	private static final int[] LEAPYEAR_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] NON_LEAPYEAR_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
    /* Put your private data fields here. */
    private int day;
    private int month;
    private int year;

    /**
     * Constructs a date with the given month, day and year. If the date is not
     * valid, the entire program will halt with an error message.
     * 
     * @param month
     *            is a month, numbered in the range 1...12.
     * @param day
     *            is between 1 and the number of days in the given month.
     * @param year
     *            is the year in question, with no digits omitted.
     */
    public Date(int month, int day, int year)
    {
        if (isValidDate(month, day, year))
        {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        System.out.println("Not valid format ");
    }

    /**
     * Constructs a Date object corresponding to the given string.
     * 
     * @param s
     *            should be a string of the form "month/day/year" where month
     *            must be one or two digits, day must be one or two digits, and
     *            year must be between 1 and 4 digits. If s does not match these
     *            requirements or is not a valid date, the program halts with an
     *            error message.
     */
    public Date(String s)
    {
        String[] dates = null;
        try
        {
            dates = s.split("/");
        } catch (IllegalArgumentException e)
        {
            System.out.println("Not valid format ");
            return;
        }
        if (dates.length != 3)
        {
            System.out.println("Not valid format ");
            return;
        }

        int m = 0, d = 0, y = 0;
        try
        {
            m = Integer.parseInt(dates[0]);
            d = Integer.parseInt(dates[1]);
            y = Integer.parseInt(dates[2]);
        } catch (IllegalArgumentException e)
        {
            System.out.println("Not valid format ");
            return;
        }
        if (isValidDate(m, d, y))
        {
            this.month = m;
            this.day = d;
            this.year = y;
        } else
        {
            System.out.println("Not valid format ");
            return;
        }

    }

    /**
     * Checks whether the given year is a leap year.
     * 
     * @return true if and only if the input year is a leap year.
     */
    public static boolean isLeapYear(int year)
    {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    /**
     * Returns the number of days in a given month.
     * 
     * @param month
     *            is a month, numbered in the range 1...12.
     * @param year
     *            is the year in question, with no digits omitted.
     * @return the number of days in the given month.
     */
	public static int daysInMonth(int month, int year)
	{
		return isLeapYear(year) ? LEAPYEAR_DAYS[month] : NON_LEAPYEAR_DAYS[month];
	}

    /**
     * Checks whether the given date is valid.
     * 
     * @return true if and only if month/day/year constitute a valid date.
     *
     *         Years prior to A.D. 1 are NOT valid.
     */
    public static boolean isValidDate(int month, int day, int year)
    {
        if (year < 1 || month < 1 || month > 12)
        {
            return false;
        }
        return day > 0 && day <= daysInMonth(month, year);
    }

    /**
     * Returns a string representation of this date in the form month/day/year.
     * The month, day, and year are expressed in full as integers; for example,
     * 12/7/2006 or 3/21/407.
     * 
     * @return a String representation of this date.
     */
    public String toString()
    {
        return month + "/" + day + "/" + year;
    }

    /**
     * Determines whether this Date is before the Date d.
     * 
     * @return true if and only if this Date is before d.
     */
    public boolean isBefore(Date d)
    {
        if (this.year > d.year)
        {
            return false;
        } 
        else if (this.year < d.year)
        {
            return true;
        }

        if (this.month > d.month)
        {
            return false;
        } 
        else if (this.month < d.month)
        {
            return true;
        }

        if (this.day >= d.day)
        {
            return false; // replace this line with your solution
        } 
        else
        {
            return true;
        }
    }

    /**
     * Determines whether this Date is after the Date d.
     * 
     * @return true if and only if this Date is after d.
     */
    public boolean isAfter(Date d)
    {
        return !(isBefore(d) || isSame(d));
    }

    private boolean isSame(Date d)
    {
        return this.year == d.year && this.month == d.month && this.day == d.day;
    }

    /**
     * Returns the number of this Date in the year.
     * 
     * @return a number n in the range 1...366, inclusive, such that this Date
     *         is the nth day of its year. (366 is used only for December 31 in
     *         a leap year.)
     */
    public int dayInYear()
    {
/*        int sum = 0;
        for (int i = 1; i < month; i++)
        {
            sum += daysInMonth(i, year);
        }
        return sum + this.day;*/
        return dayInYear(this.month - 1, 0);
    }
    
    private int dayInYear(int month, int total)
    {
        if (month == 0)
        {
            return total + this.day;
        }
        else
        {
            return  dayInYear(month - 1, total + daysInMonth(month, year));
        }
    }

    /**
     * Determines the difference in days between d and this Date. For example,
     * if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1. If
     * this Date occurs before d, the result is negative.
     * 
     * @return the difference in days between d and this date.
     */
    public int difference(Date d)
    {
        return this.standardDate() - d.standardDate();
    }
    
    private int standardDate()
    {
/*        int sumDays = 0;
        for(int i = 1; i < this.year; i++)
        {
            if(isLeapYear(i))
            {
                sumDays += 366;
            }
            else
            {
                sumDays += 365;
            }
        }
        
        return sumDays + dayInYear();*/
        return standardDate(this.year - 1, 0);
    }
    
    private int standardDate(int year, int total)
    {
        if(year == 0)
        {
            return total + dayInYear();
        }
        else
        {
            return standardDate(year - 1, total + (isLeapYear(year) ? 366 : 365));
        }
    }

    public static void main(String[] argv)
    {
        System.out.println("\nTesting constructors.");
        Date d1 = new Date(1, 1, 1);
        System.out.println("Date should be 1/1/1: " + d1);
        d1 = new Date("2/4/2");
        System.out.println("Date should be 2/4/2: " + d1);
        d1 = new Date("2/29/2000");
        System.out.println("Date should be 2/29/2000: " + d1);
        d1 = new Date("2/29/1904");
        System.out.println("Date should be 2/29/1904: " + d1);

        d1 = new Date(12, 31, 1975);
        System.out.println("Date should be 12/31/1975: " + d1);
        Date d2 = new Date("1/1/1976");
        System.out.println("Date should be 1/1/1976: " + d2);
        Date d3 = new Date("1/2/1976");
        System.out.println("Date should be 1/2/1976: " + d3);

        Date d4 = new Date("2/27/1977");
        Date d5 = new Date("8/31/2110");

        /* I recommend you write code to test the isLeapYear function! */

        System.out.println("\nTesting before and after.");
        System.out.println(d2 + " after " + d1 + " should be true: " + d2.isAfter(d1));
        System.out.println(d3 + " after " + d2 + " should be true: " + d3.isAfter(d2));
        System.out.println(d1 + " after " + d1 + " should be false: " + d1.isAfter(d1));
        System.out.println(d1 + " after " + d2 + " should be false: " + d1.isAfter(d2));
        System.out.println(d2 + " after " + d3 + " should be false: " + d2.isAfter(d3));

        System.out.println(d1 + " before " + d2 + " should be true: " + d1.isBefore(d2));
        System.out.println(d2 + " before " + d3 + " should be true: " + d2.isBefore(d3));
        System.out.println(d1 + " before " + d1 + " should be false: " + d1.isBefore(d1));
        System.out.println(d2 + " before " + d1 + " should be false: " + d2.isBefore(d1));
        System.out.println(d3 + " before " + d2 + " should be false: " + d3.isBefore(d2));

        System.out.println("\nTesting difference.");
        System.out.println(d1 + " - " + d1 + " should be 0: " + d1.difference(d1));
        System.out.println(d2 + " - " + d1 + " should be 1: " + d2.difference(d1));
        System.out.println(d3 + " - " + d1 + " should be 2: " + d3.difference(d1));
        System.out.println(d3 + " - " + d4 + " should be -422: " + d3.difference(d4));
        System.out.println(d5 + " - " + d4 + " should be 48762: " + d5.difference(d4));
    }
}
