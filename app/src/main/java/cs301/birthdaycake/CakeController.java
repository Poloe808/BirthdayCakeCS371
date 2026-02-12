package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnTouchListener{

    //this is where we store all the goodies in the cakeview
    private CakeView cakeView;
    private CakeModel cakeModel;

    CakeController(CakeView cakeview){
        this.cakeView = cakeview;
        cakeModel = cakeview.getCakeView();

    }

    @Override
    public boolean onTouch(View v, MotionEvent m){
        if(m.getAction() == MotionEvent.ACTION_DOWN || m.getAction() == MotionEvent.ACTION_MOVE){
            cakeModel.touchX = m.getX();
            cakeModel.touchY = m.getY();
            cakeModel.isTouch = true;
            cakeView.invalidate();
            return true;
        }
        return false;
        //cakeView.drawCircleX(cakeModel.touchX);
        //cakeView.drawCircleY(cakeModel.touchY);
    }

    @Override
    public void onClick (View v) {
        cakeModel.isLit = false;
        cakeView.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        cakeModel.hasCandles = isChecked;
        cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        cakeModel.candles = progress;
        cakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
