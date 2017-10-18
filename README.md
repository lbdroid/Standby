This is a receiver that sends the Android unit it is running on into standby<br>
<br>
Note: Requires root, and *does not* install like a normal application.<br>
<br>
Installation:<br>
1) Build apk.<br>
2) Create directory /system/priv-app/Standby (mode 755)<br>
3) Install apk to /system/priv-app/Standby/Standby.apk (mode 644)<br>
4) Reboot<br>
5) Edit /data/system/packages.xml:<br>
a) Find section for package name="com.android.settings", make note of its cert index="X" and proper-signing-keyset identifier="Y" values.<br>
b) Find section for package name="tk.rabidbeaver.standby", change cert index and proper-signing-keyset identifier values to match com.android.settings.<br>
c) Add perms section as follows;<br>
```
<perms><br>
<item name="android.permission.DEVICE_POWER" granted="true" flags="0" /><br>
</perms><br>
```
d) save, sync, reboot.<br>
