package tk.rabidbeaver.standby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.SystemClock;

import java.lang.reflect.InvocationTargetException;

public class StandbyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        try {
            pm.getClass().getMethod("goToSleep", new Class[]{long.class}).invoke(pm, SystemClock.uptimeMillis());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }
}
