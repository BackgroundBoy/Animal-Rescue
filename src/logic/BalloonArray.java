package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *	This map collect Key of alphabet and Value of List of Balloon
 *	Example >> ['A': <Balloon a>, 'B': <Balloon b, Balloon b, Balloon b>]
 */

public class BalloonArray {

	private Map<String, List<Balloon>> map;
	
	// Constructor
	public BalloonArray() {
		map = new HashMap<String, List<Balloon>>();
	}
	
	// Method :
	
	public void addBalloon(Balloon balloon) {
		
		if (map.get(balloon.getAlphabet()) == null)
			map.put(balloon.getAlphabet(), new ArrayList<>());
		map.get(balloon.getAlphabet()).add(balloon);
		
	}
	
	// TODO balloon pop graphic animation...
	public void popAlpha(String alpha) {
	
		for (int i=0; i<map.get(alpha).size(); i++) {
			map.get(alpha).get(i).pop();
		}
		map.get(alpha).clear();
	}
	
	public boolean contains(String s) {
		return map.get(s) != null;
	}
	
	
}
