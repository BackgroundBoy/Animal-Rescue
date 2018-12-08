package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import logic.Animals;
import logic.Grounds;
import logic.Hunters;

public class IRenderableHolder {

	private List<IRenderable> container;
	private Comparator<IRenderable> comparator;
	private static final IRenderableHolder instance = new IRenderableHolder();
	public static Image a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21;
	public static Image a22,a23,a24,a25,a26;
	public static Image bg1;
	public static Image s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
	public static Image h1;
	public static Image p1;
	public static Image ground;
			
	static{
		loadResources();
	}
	
	public IRenderableHolder() {
		container = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if(o1.getZ() > o2.getZ())
				return 1;
			return -1;	// return false as default
		};
	}
	
	public void add(IRenderable unit) {
		container.add(unit);
		Collections.sort(container, comparator);
	}
	
	public void update() {
		for(int i = container.size()-1; i>=0; i--) {
			if(container.get(i).isDestroyed()) {
				container.remove(i);
			}
		}
	}
	
	public static IRenderableHolder getInstance() {
		return instance;
	}
	
	public ArrayList<IRenderable> getContainer(){
		return (ArrayList) container;
	}
	
	public void clear() {
		for(int i = container.size()-1; i >=0; i--) {
			if( container.get(i) instanceof Animals || container.get(i) instanceof Hunters )
				container.remove(i);
		}
	}
	
	private static void loadResources() {
		a1 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_a.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a2 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_b.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a3 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_c.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a4 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_d.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a5 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_e.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a6 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_f.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a7 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_g.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a8 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_h.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a9 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_i.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a10 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_j.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a11 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_k.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a12 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_l.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a13 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_m.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a14 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_n.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a15 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_o.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a16 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_p.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a17 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_q.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a18 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_r.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a19 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_s.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a20 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_t.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a21 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_u.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a22 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_v.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a23 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_w.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a24 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_x.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a25 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_y.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		a26 = new Image(ClassLoader.getSystemResourceAsStream("animals/ani_z.png"), Animals.WIDTH, Animals.HEIGHT, true, false);		
		bg1 = new Image(ClassLoader.getSystemResourceAsStream("images/a.jpg"), 1366, 768, false, false);
		s1 = new Image(ClassLoader.getSystemResourceAsStream("animals/s1.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		s2 = new Image(ClassLoader.getSystemResourceAsStream("animals/s2.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		s3 = new Image(ClassLoader.getSystemResourceAsStream("animals/s3.png"), Animals.WIDTH, Animals.HEIGHT, true, false);		
		s4 = new Image(ClassLoader.getSystemResourceAsStream("animals/s4.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		s5 = new Image(ClassLoader.getSystemResourceAsStream("animals/s5.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		s6 = new Image(ClassLoader.getSystemResourceAsStream("animals/s6.png"), Animals.WIDTH, Animals.HEIGHT, true, false);		
		s7 = new Image(ClassLoader.getSystemResourceAsStream("animals/s7.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		s8 = new Image(ClassLoader.getSystemResourceAsStream("animals/s8.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		s9 = new Image(ClassLoader.getSystemResourceAsStream("animals/s9.png"), Animals.WIDTH, Animals.HEIGHT, true, false);		
		s10 = new Image(ClassLoader.getSystemResourceAsStream("animals/s10.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		s11 = new Image(ClassLoader.getSystemResourceAsStream("animals/s11.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		s12 = new Image(ClassLoader.getSystemResourceAsStream("animals/s12.png"), Animals.WIDTH, Animals.HEIGHT, true, false);
		h1 = new Image(ClassLoader.getSystemResourceAsStream("images/hunter.gif"), Hunters.WIDTH, 288, true, false);
		p1 = new Image(ClassLoader.getSystemResourceAsStream("images/parachute.png"), 115, 115, true, false);
		ground = new Image(ClassLoader.getSystemResourceAsStream("images/ground100.png"),Grounds.WIDTH,Grounds.HEIGHT,true,false);
	}
}
