package tk.rabidbeaver.standby;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        try {
            pm.getClass().getMethod("goToSleep", new Class[]{long.class}).invoke(pm, SystemClock.uptimeMillis());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }
}
