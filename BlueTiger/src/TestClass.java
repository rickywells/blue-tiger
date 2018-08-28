import java.util.ArrayList;
import java.util.List;

public class TestClass 
{
	public static void main(String[] args) {
		TestClass test = new TestClass();
	}
	
	public TestClass()
	{
		Weapon sword = 
				new Weapon("Longsword", 6, 3, 100, false, false, 0, false, 
						true, false, false, false, 5.0, 4.0);
		Weapon spear = 
				new Weapon("Spear", 4, 3, 100, false, false, 0, true, 
						false, false, true, false, 5.0, 4.0);
		Weapon dagger = 
				new Weapon("Dagger", false);
		
		List<Weapon> armory = new ArrayList<Weapon>();
		armory.add(spear);
		armory.add(sword);
		armory.add(dagger);
		armory.add(new Weapon("Shortsword", true));
		
		
		
		for (int i = 0; i < armory.size(); i++)
		{
			System.out.println(armory.get(i).getName());
			System.out.println("d"+ armory.get(i).getDamage());
			System.out.println("Speed: " + armory.get(i).getSpeed());
			if(armory.get(i).isDualWield()) {System.out.println("Can dual wield");}
			if(armory.get(i).isMajorWounding()) {System.out.println("Deals Major Wounds");}
			if(armory.get(i).isRanged()) {System.out.println("Range: " + armory.get(i).getRange() + "'");}
			if(armory.get(i).isStealthy()) {System.out.println("Concealable");}
			if(armory.get(i).isStunning()) {System.out.println("Can stun");}
			if(armory.get(i).isThrusting()) {System.out.println("Can thrust at opponent out of reach");}
			if(armory.get(i).isTwoHanded()) {System.out.println("Requires two hands");}
			System.out.println("----------------------------------------");
		}

	}
}
