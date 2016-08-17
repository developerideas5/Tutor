require "java"

class VisualAlarm
	include com.beans.Alarm
	
	def activate
		puts "VisualAlarm activated"
	end
	def deactivate
		puts "VisualAlarm deactivated"
	end
end

