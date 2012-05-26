package ca.turix.widgets;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import ca.turix.tal.R;

public class TimePickerPopup
{
    
    public TimePickerPopup(View anchor, int hourOfDay, int minute, boolean is24HourView, OnTimeChangedListener callBack)
    {
        m_anchor = anchor;
        
        LayoutInflater inflater =
                (LayoutInflater) anchor.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        m_timePicker = (TimePicker)inflater.inflate(R.layout.time_picker, null, false);

        m_timePicker.setIs24HourView(is24HourView);
        m_timePicker.setCurrentHour(hourOfDay);
        m_timePicker.setCurrentMinute(minute);
        m_timePicker.setOnTimeChangedListener(callBack);
        m_timePicker.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        m_popupWindow = new PopupWindow(m_timePicker, m_timePicker.getMeasuredWidth(), m_timePicker.getMeasuredHeight());
        m_popupWindow.setOutsideTouchable(true);
        m_popupWindow.setFocusable(true);
        m_popupWindow.setBackgroundDrawable(new BitmapDrawable(anchor.getResources()));
    }

    public void show()
    {
        m_popupWindow.showAtLocation(m_anchor, Gravity.CENTER, 0, 0);
    }
    
    private View m_anchor;
    private PopupWindow m_popupWindow;
    private TimePicker m_timePicker;
}
