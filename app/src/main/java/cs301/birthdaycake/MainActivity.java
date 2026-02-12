package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView cake = findViewById(R.id.cakeview);
        CakeController controller = new CakeController(cake);

        Button blowOut = findViewById(R.id.blowout);
        blowOut.setOnClickListener(controller);

        Switch candleSwitch = findViewById(R.id.candleswitch);
        candleSwitch.setOnCheckedChangeListener(controller);

        SeekBar candleBar = findViewById(R.id.candleSeekBar);
        candleBar.setOnSeekBarChangeListener(controller);

        cake.setOnTouchListener(controller);

    }
}
