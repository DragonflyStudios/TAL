package ca.turix.utils.time;

public class LengthOfTime
{
    public static String lengthInMinutesString(int minutes)
    {
        return lengthInMinutesString(minutes, true, null);
    }

    public static String lengthInMinutesString(int minutes, String negativeString)
    {
        return lengthInMinutesString(minutes, true, negativeString);
    }
    
    public static String lengthInMinutesString(int minutes, boolean withUnit, String negativeString)
    {
        if (minutes < 0)
            return negativeString;

        return minutes + (withUnit ? ((minutes > 1) ? " mins" : ((minutes >= 0) ? " min" : "")) : "");
    }

    private int m_lengthInMinutes;
    public int getTime() { return m_lengthInMinutes; }
    public void setTime(int lengthInMinutes) { m_lengthInMinutes = lengthInMinutes; }

    private String m_negativeString;

    public LengthOfTime(int lengthInMinutes, String negativeString)
    {
        m_lengthInMinutes = lengthInMinutes;
        m_negativeString = negativeString;
    }

    public String toString()
    {
        return lengthInMinutesString(m_lengthInMinutes, m_negativeString);
    }
    
    
}
