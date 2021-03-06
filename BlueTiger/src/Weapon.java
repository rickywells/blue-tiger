import java.util.*;

public class Weapon extends GameItem {

	private String name;
	private int damage;
	private int speed;
	private int durability;
	private boolean stealthy;
	private boolean ranged;
	private int range;
	private boolean twoHanded;
	private boolean majorWounding;
	private boolean stunning;
	private boolean thrusting;
	private boolean dualWield;
	private double weight;
	private double value;
	
	/**
	 * Constructor to build a weapon.
	 * @param name is the type of weapon 
	 * @param damage represents the dice value of damage
	 * @param speed is how quickly this weapon can attack
	 * @param durability is the current condition of the weapon (out of 100)
	 * @param stealthy determines if it can be concealed
	 * @param ranged determines if it is a ranged weapon
	 * @param range is the range of the weapon in feet. 0 for non-ranged weapons
	 * @param twoHanded determines if it requires two hands to use
	 * @param majorWounding determines if it can deliver a major wound
	 * @param stunning determines if it can stun
	 * @param thrusting determines if it can be thrust out of arms reach (ie, spear)
	 * @param dualWield determines if it is possible to wield it with another weapon
	 */
	public Weapon(String name, int damage, int speed, int durability, 
			boolean stealthy, boolean ranged, int range, boolean twoHanded,
			boolean majorWounding, boolean stunning, boolean thrusting, 
			boolean dualWield, double weight, double value) {
		
		this.name = name;
		this.damage = damage;
		this.speed = speed;
		this.durability = durability;
		this.stealthy = stealthy;
		this.ranged = ranged;
		this.range = range;
		this.twoHanded = twoHanded;
		this.majorWounding = majorWounding;
		this.stunning = stunning;
		this.thrusting = thrusting;
		this.dualWield = dualWield;
		this.weight = weight;
		this.value = value;
	}
	
	public Weapon(String name, boolean isBrandNew)
	{
		this.name = name;
		setFromJSON(name);
		if(!isBrandNew)
		{
			randomDurability();
		}
	}
	
	private void setFromJSON(String n)
	{
		Scanner read = new Scanner(Weapon.class.getResourceAsStream("weapons.json"));
		String temp = "";
		
		while(read.hasNext())
		{
			temp += read.next();
		}
		read.close();
		JSONObject json = new JSONObject(temp);
		JSONArray array = json.getJSONArray("weapons");
		for(int i = 0 ; i < array.length(); i++)
		{
			if(array.getJSONObject(i).get("name").equals(n))
			{
				if(array.getJSONObject(i).has("damage")){this.setDamage((Integer) array.getJSONObject(i).get("damage"));}
				if(array.getJSONObject(i).has("speed")){this.setSpeed((Integer) array.getJSONObject(i).get("speed"));}
				if(array.getJSONObject(i).has("durability")){this.setDurability((Integer) array.getJSONObject(i).get("durability"));}
				if(array.getJSONObject(i).has("stealthy")){this.setStealthy((Boolean) array.getJSONObject(i).get("stealthy"));}
				if(array.getJSONObject(i).has("ranged")){this.setRanged((Boolean) array.getJSONObject(i).get("ranged"));}
				if(array.getJSONObject(i).has("range")){this.setRange((Integer) array.getJSONObject(i).get("range"));}
				if(array.getJSONObject(i).has("twoHanded")){this.setTwoHanded((Boolean) array.getJSONObject(i).get("twoHanded"));}
				if(array.getJSONObject(i).has("majorWounding")){this.setMajorWounding((Boolean) array.getJSONObject(i).get("majorWounding"));}
				if(array.getJSONObject(i).has("stunning")){this.setStunning((Boolean) array.getJSONObject(i).get("stunning"));}
				if(array.getJSONObject(i).has("thrusting")){this.setThrusting((Boolean) array.getJSONObject(i).get("thrusting"));}
				if(array.getJSONObject(i).has("dualWield")){this.setDualWield((Boolean) array.getJSONObject(i).get("dualWield"));}
			}
		}
	}

	private void randomDurability()
	{
		Random r = new Random();
		setDurability(r.nextInt(50) + 30);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public double getValue() {
		return value;
	}

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @return the durability
	 */
	public int getDurability() {
		return durability;
	}

	/**
	 * @return the stealthy
	 */
	public boolean isStealthy() {
		return stealthy;
	}

	/**
	 * @return the ranged
	 */
	public boolean isRanged() {
		return ranged;
	}

	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @return the twoHanded
	 */
	public boolean isTwoHanded() {
		return twoHanded;
	}

	/**
	 * @return the majorWounding
	 */
	public boolean isMajorWounding() {
		return majorWounding;
	}

	/**
	 * @return the stunning
	 */
	public boolean isStunning() {
		return stunning;
	}

	/**
	 * @return the thrusting
	 */
	public boolean isThrusting() {
		return thrusting;
	}

	/**
	 * @return the dualWield
	 */
	public boolean isDualWield() {
		return dualWield;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @param durability the durability to set
	 */
	public void setDurability(int durability) {
		this.durability = durability;
	}

	/**
	 * @param stealthy the stealthy to set
	 */
	public void setStealthy(boolean stealthy) {
		this.stealthy = stealthy;
	}

	/**
	 * @param ranged the ranged to set
	 */
	public void setRanged(boolean ranged) {
		this.ranged = ranged;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * @param twoHanded the twoHanded to set
	 */
	public void setTwoHanded(boolean twoHanded) {
		this.twoHanded = twoHanded;
	}

	/**
	 * @param majorWounding the majorWounding to set
	 */
	public void setMajorWounding(boolean majorWounding) {
		this.majorWounding = majorWounding;
	}

	/**
	 * @param stunning the stunning to set
	 */
	public void setStunning(boolean stunning) {
		this.stunning = stunning;
	}

	/**
	 * @param thrusting the thrusting to set
	 */
	public void setThrusting(boolean thrusting) {
		this.thrusting = thrusting;
	}

	/**
	 * @param dualWield the dualWield to set
	 */
	public void setDualWield(boolean dualWield) {
		this.dualWield = dualWield;
	}
	
//	
}
