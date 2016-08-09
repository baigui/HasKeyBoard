package demo.baigui.com.setnoinput;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class ChoseInput extends EditText{

    private InputMethodManager mManager;

    SharedPreferences mHharedPreferences;

    public ChoseInput(Context context) {
        this(context, null);
    }

    public ChoseInput(Context context, AttributeSet attrs) {
        super(context, attrs);
        mManager    = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        mHharedPreferences= context.getSharedPreferences("is_hide_input", Activity.MODE_PRIVATE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        if (mHharedPreferences.getBoolean("is_hide_input" , false)){
            Log.v(">>>>>>>>","no input");
            mManager.hideSoftInputFromWindow(getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        }else {
            Log.v(">>>>>>>","has input");
            mManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        return true;
    }
}
