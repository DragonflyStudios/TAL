package ca.turix.widgets;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import ca.turix.tal.R;

public class TimePickerPopup
{
    
    public TimePickerPopup(View anchor, int timeInMinutes, boolean is24HourView, OnTimeChangedListener callBack)
    {
        m_anchor = anchor;
        
        LayoutInflater inflater =
                (LayoutInflater) anchor.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        m_timePicker = (TimePicker)inflater.inflate(R.layout.time_picker, null, false);

        m_timePicker.setIs24HourView(is24HourView);
        m_timePicker.setCurrentHour(timeInMinutes / 60);
        m_timePicker.setCurrentMinute(timeInMinutes % 60);
        m_timePicker.setOnTimeChangedListener(callBack);
        m_timePicker.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        m_popupWindow = new PopupWindow(m_timePicker, m_timePicker.getMeasuredWidth(), m_timePicker.getMeasuredHeight());
        m_popupWindow.setOutsideTouchable(true);
        m_popupWindow.setFocusable(true);
        m_popupWindow.setBackgroundDrawable(new BitmapDrawable(anchor.getResources()));
    }

    // TODO: make this work!
    public void showAboveAnchor()
    {
        int x = m_anchor.getLeft() + (m_anchor.getRight() - m_anchor.getLeft()) / 2;
        int y = m_anchor.getTop() + (m_anchor.getBottom() - m_anchor.getTop()) / 2;
        m_popupWindow.showAtLocation(m_anchor, Gravity.NO_GRAVITY, x, y);
    }

    // TODO: make this work!
    public void showAboveView(View view)
    {
        int x = view.getLeft() + (view.getRight() - view.getLeft()) / 2;
        int y = view.getTop() + (view.getBottom() - view.getTop()) / 2;
        m_popupWindow.showAtLocation(view, Gravity.CENTER, x, y);
    }

    public void show()
    {
        m_popupWindow.showAtLocation(m_anchor, Gravity.CENTER, 0, 0);
    }
    
    public void setTime(int timeInMinutes)
    {
        m_timePicker.setCurrentHour(timeInMinutes / 60);
        m_timePicker.setCurrentMinute(timeInMinutes % 60);
    }
    
    private View m_anchor;
    private PopupWindow m_popupWindow;
    private TimePicker m_timePicker;
}
