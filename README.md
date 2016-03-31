# CompassApp
Compass application for android platform

your android device should have support TYPE_ORIENTATION sensor.

you have define SensorManager.<br>
<code>
  private SensorManager mSensorManager;</code><br>
  <code>
  mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
</code>

In your Main Class, you need to implements <code>SensorEventListener</code>.<br>

onResume Method : <br> 
<code>@Override</code><br> 
    <code>protected void onResume() {</code><br> 
        <code>super.onResume();</code><br> 
       <code> mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);</code><br> 
   <code> }</code><br> 
   
   onPause Method : <br>
   <code>@Override</code><br> 
    <code>protected void onPause() {</code><br> 
        <code>super.onPause();</code><br> 
        <code>mSensorManager.unregisterListener(this);</code><br> 
    <code>}</code><br> 
    
    you will find full source code here : <br>
  https://github.com/lldeepakll/CompassApp/blob/master/app/src/main/java/com/chrono/compassapp/MainActivity.java<br>
  
  ![device-2016-03-31-190308](https://cloud.githubusercontent.com/assets/17099115/14177329/64a9f856-f773-11e5-8782-789bf201955a.png)
