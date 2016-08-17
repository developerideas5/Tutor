

class SoundAlarm
	include com.beans.Alarm
	
	def activate
		puts "SoundAlarm activated"
	end
	def deactivate
		puts "SoundAlarm deactivated"
	end
end

