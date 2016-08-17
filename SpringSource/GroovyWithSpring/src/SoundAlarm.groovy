import com.groovyWithSpring.Alarm;


class SoundAlarm implements Alarm
{
	String model
	void  activate()
	{
		println("SoundAlarm [" + model + "] activated");
	}
	void deactivate()
	{
		println("SoundAlarm [" + model + "] deactivated");

	}
}