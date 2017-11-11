package tk.rabidbeaver.standby;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.standby);
        b.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
                try {
                    pm.getClass().getMethod("goToSleep", new Class[]{long.class}).invoke(pm, SystemClock.uptimeMillis());
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
