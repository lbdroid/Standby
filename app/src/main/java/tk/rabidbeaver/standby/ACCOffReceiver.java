package tk.rabidbeaver.standby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.PowerManager;
import android.os.SystemClock;

import java.lang.reflect.InvocationTargetException;

public class ACCOffReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Uri alert = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.powersave);
            MediaPlayer m = new MediaPlayer();
            m.setDataSource(context, alert);
            m.setAudioStreamType(5);
            m.prepare();
            m.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
