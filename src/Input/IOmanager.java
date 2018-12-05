package Input;

public class IOmanager {
	
	public static String code = "";
	private static boolean pressed = false;
	private static boolean triggered = false;
	
	public static boolean getpressed() {
		return IOmanager.pressed;
	}
	
	public static void setPressed(boolean p) {
		if(p) {
			IOmanager.pressed = true;
		}else {
			IOmanager.pressed = false;
		}
	}
	
	public static boolean getTriggered() {
		return IOmanager.triggered;
	}
	
	public static void setTrriggered(String code, boolean trig){
		if(trig) {
			IOmanager.triggered = true;
			if(code.equals(IOmanager.code)) {
				
			}else {
				IOmanager.code = code;	
			}
		}else {
			IOmanager.triggered = false;
		}

	}

	public static void postupdate() {
		IOmanager.triggered = false;
	}
}
