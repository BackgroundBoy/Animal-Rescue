package Input;

public class IOmanager {
	
	private static String code = "";
	private static boolean pressed = false;
	private static boolean triggered = false;
	
	public static boolean getpressed() {
		return IOmanager.pressed;
	}
	
	public static void setPressed(boolean press) {
		if (press) {
			IOmanager.pressed = true;
		} else {
			IOmanager.pressed = false;
		}
	}
	
	public static boolean getTriggered() {
		return IOmanager.triggered;
	}
	
	public static void setTriggered(String code, boolean trigger){
		if(trigger) {
			IOmanager.triggered = true;
			IOmanager.code = code;	
		} else {
			IOmanager.triggered = false;
		}
	}

	public static void postupdate() {
		IOmanager.triggered = false;
	}
	
	public static String getCode() {
		return code;
	}
}
