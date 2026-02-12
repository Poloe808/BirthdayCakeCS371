package cs301.birthdaycake;

import static android.view.MotionEvent.ACTION_DOWN;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    //this is where we store all the goodies in the cakeview
    private CakeView cakeView;
    private CakeModel cakeModel;

    CakeController(CakeView cakeview){
        this.cakeView = cakeview;
        cakeModel = cakeview.getCakeView();
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


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
            cakeModel.hasBalloon = true;
            cakeModel.x = motionEvent.getX();
            cakeModel.y = motionEvent.getY();
            cakeView.invalidate();
            return true;
    }
}
