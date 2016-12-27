package com.zhoujian.sensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener
{
	private SensorManager sensorManager;
	private TextView text;
	private TextView text1;
	private TextView text2;
	private TextView text3;
	private TextView text4;
	private TextView text5;
	private TextView text6;
	private TextView text7;
	private StringBuilder sb;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getAllAccelerometerService();
		initView();

	}

	@Override
	protected void onResume()
	{

		super.onResume();
		// 为系统方向传感器添加注册监听事件
		sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_GAME);

		// 为系统螺旋仪传感器添加注册监听事件
		sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),SensorManager.SENSOR_DELAY_GAME);

		// 为系统磁场传感器添加注册监听事件
		sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),SensorManager.SENSOR_DELAY_GAME);

		// 为系统重力传感器添加注册监听事件
		sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),SensorManager.SENSOR_DELAY_GAME);

		// 为系统线性加速度传感器添加注册监听事件
		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),SensorManager.SENSOR_DELAY_GAME);

		// 为系统温度传感器添加注册监听事件
		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),SensorManager.SENSOR_DELAY_GAME);

		// 为系统光传感器添加注册监听事件
		sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_GAME);

		// 为系统压力传感器添加注册监听事件
		sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE),SensorManager.SENSOR_DELAY_GAME);

	}

	private void getAllAccelerometerService()
	{
		// 获取系统传感器服务管理器
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

	}

	private void initView()
	{

		text = (TextView) findViewById(R.id.text);
		text1 = (TextView) findViewById(R.id.text1);
		text2 = (TextView) findViewById(R.id.text2);
		text3 = (TextView) findViewById(R.id.text3);
		text4 = (TextView) findViewById(R.id.text4);
		text5 = (TextView) findViewById(R.id.text5);
		text6 = (TextView) findViewById(R.id.text6);
		text7 = (TextView) findViewById(R.id.text7);
	}

	@Override
	protected void onStop()
	{

		// 取消监听
		sensorManager.unregisterListener(this);
		super.onStop();
	}

	@Override
	protected void onPause()
	{

		// 取消监听
		sensorManager.unregisterListener(this);
		super.onPause();

	}

	/**
	 *
	 * SensorEventListener接口必须实现的方法
	 *
	 * 当传感器的值发生改变的时候回调该方法
	 */
	@Override
	public void onSensorChanged(SensorEvent event)
	{
		float[] values = event.values;
		int sensorType = event.sensor.getType();
		sb = null;
		switch (sensorType)

		{
			// 方向传感器
			case Sensor.TYPE_ORIENTATION:
				sb = new StringBuilder();
				sb.append("方向传感器返回的值:");
				sb.append("\n绕Z轴转过的角度:");
				sb.append(values[0]);
				sb.append("\n绕X轴转过的角度:");
				sb.append(values[1]);
				sb.append("\n绕Y轴转过的角度:");
				sb.append(values[2]);
				text.setText(sb.toString());
				break;

			// 螺旋仪传感器
			case Sensor.TYPE_GYROSCOPE:
				sb = new StringBuilder();
				sb.append("螺旋仪传感器返回的值:");
				sb.append("\n绕X轴旋转的角速度:");
				sb.append(values[0]);
				sb.append("\n绕Y轴旋转的角速度:");
				sb.append(values[1]);
				sb.append("\n绕Z轴旋转的角速度:");
				sb.append(values[2]);
				text1.setText(sb.toString());
				break;

			// 磁场传感器
			case Sensor.TYPE_MAGNETIC_FIELD:
				sb = new StringBuilder();
				sb.append("磁场传感器返回的值:");
				sb.append("\n绕X轴方向上的磁场强度:");
				sb.append(values[0]);
				sb.append("\n绕Y轴方向上的磁场强度:");
				sb.append(values[1]);
				sb.append("\n绕Z轴方向上的磁场强度:");
				sb.append(values[2]);
				text2.setText(sb.toString());
				break;

			// 重力传感器
			case Sensor.TYPE_GRAVITY:
				sb = new StringBuilder();
				sb.append("重力传感器返回的值:");
				sb.append("\nX轴方向上的重力:");
				sb.append(values[0]);
				sb.append("\nY轴方向上的重力:");
				sb.append(values[1]);
				sb.append("\nZ轴方向上的重力:");
				sb.append(values[2]);
				text3.setText(sb.toString());
				break;

			// 线性加速度传感器
			case Sensor.TYPE_LINEAR_ACCELERATION:
				sb = new StringBuilder();
				sb.append("线性加速度传感器返回的值:");
				sb.append("\nX轴方向上的线性加速度:");
				sb.append(values[0]);
				sb.append("\nY轴方向上的线性加速度:");
				sb.append(values[1]);
				sb.append("\nZ轴方向上的线性加速度:");
				sb.append(values[2]);
				text4.setText(sb.toString());
				break;

			// 温度传感器
			case Sensor.TYPE_AMBIENT_TEMPERATURE:

				sb = new StringBuilder();
				sb.append("温度传感器返回的值：");
				sb.append("\n当前温度为:");
				sb.append(values[0]);
				text5.setText(sb.toString());
				break;

			// 光传感器
			case Sensor.TYPE_LIGHT:

				sb = new StringBuilder();
				sb.append("光传感器返回的值：");
				sb.append("\n当前光的强度为:");
				sb.append(values[0]);
				text6.setText(sb.toString());
				break;

			// 压力传感器
			case Sensor.TYPE_PRESSURE:

				sb = new StringBuilder();
				sb.append("压力传感器返回的值：");
				sb.append("\n当前压力为:");
				sb.append(values[0]);
				text7.setText(sb.toString());
				break;
		}
	}

	/**
	 *
	 * SensorEventListener接口必须实现的方法
	 *
	 * 当传感器精度改变时回调该方法
	 */
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{

	}
}
