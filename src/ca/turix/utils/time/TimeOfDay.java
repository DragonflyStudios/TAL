package ca.turix.utils.time;

public class TimeOfDay
{
    public static int timeOfDayInMinutes(int hourOfDay, int minute)
    {
        return hourOfDay * 60 + minute;
    }
    
    public static String timeOfDayString(int minutes)
    {
        return timeOfDayString(minutes, false, true);
    }
    
    public static String timeOfDayString(int hourOfDay, int minute)
    {
        return timeOfDayString(hourOfDay * 60 + minute);
    }
    
    public static String timeOfDayString(int minutes, boolean format24, boolean leadingZero)
    {
        if (minutes < 0)
            return null;
        
        if (minutes > 1440)
            minutes %= 1440;
        
        StringBuilder sb = new StringBuilder();
        
        int hour = minutes / 60;
        int minute = minutes % 60;
        
        boolean isPM = (hour >= 12);
        int hour12 = (hour > 12) ? (hour - 12) : hour;
        
        if (hour < 10 && leadingZero)
            sb.append("0");
        
        sb.append(format24 ? hour : hour12).append(":");
        
        if (minute < 10 && leadingZero)
            sb.append("0");
        
        sb.append(minute);
        
        if (!format24)
            sb.append(isPM ? " PM" : " AM");
        
        return sb.toString();
    }

    // minutes elapsed since midnight
    private int m_timeInMinutes;
    
    public int getTime()
    {
        return m_timeInMinutes;
    }
    
    public void setTime(int timeInMinutes)
    {
        m_timeInMinutes = timeInMinutes;
    }
    
    public TimeOfDay(int timeInMinutes)
    {
        m_timeInMinutes = timeInMinutes;
    }
    
    public String toString()
    {
        return timeOfDayString(m_timeInMinutes);
    }
}
