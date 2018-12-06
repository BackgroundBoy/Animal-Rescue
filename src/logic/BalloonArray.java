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
	public int popAlpha(String alpha) {
		for (int i=0; i<map.get(alpha).size(); i++) {
			map.get(alpha).get(i).pop();
		}
		int temp = map.get(alpha).size();
		map.get(alpha).clear();
		return temp;
	}
	
	public boolean contains(String s) {
		return map.get(s) != null && map.get(s).size() != 0;
	}
	
	public void pause() {
		for (Map.Entry<String, List<Balloon>> entry : map.entrySet()){
			for (int i=0; i<entry.getValue().size(); i++) {
				entry.getValue().get(i).pause();
				entry.getValue().get(i).setAlphabet(null);
			}
		}
	}
	
	public void unpause() {
		for (Map.Entry<String, List<Balloon>> entry : map.entrySet()){
			for (int i=0; i<entry.getValue().size(); i++) {
				entry.getValue().get(i).unpause();
				entry.getValue().get(i).setAlphabet(entry.getKey());
			}
		}
	}
	
	public void clear() {
		for (Map.Entry<String, List<Balloon>> entry : map.entrySet()){
			popAlpha(entry.getKey());
		}
	}
	
}
