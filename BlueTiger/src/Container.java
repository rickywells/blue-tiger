import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Container {
	private List<GameItem> myInventory;
	private double myCapacity;
	private String myName;
	
	public Container(String name)
	{
		this.setMyName(name);
		myInventory = new ArrayList<GameItem>();
		this.setFromJSON(name);
	}
	
	private void setFromJSON(String n)
	{
		Scanner read = new Scanner(Weapon.class.getResourceAsStream("container.json"));
		String temp = "";
		
		while(read.hasNext())
		{
			temp += read.next();
		}
		read.close();
		JSONObject json = new JSONObject(temp);
		JSONArray array = json.getJSONArray("containers");
		for(int i = 0 ; i < array.length(); i++)
		{
			if(array.getJSONObject(i).get("name").equals(n))
			{
				if(array.getJSONObject(i).has("capacity")){this.setMyCapacity((Integer) array.getJSONObject(i).get("capacity"));}
			}
		}
	}
	
	public boolean addItem(GameItem i)
	{
		double temp = 0;
		for (GameItem j : myInventory)
		{
			temp += j.getWeight();
		}
		
		if (temp + i.getWeight() > myCapacity)
		{
			return false;
		}
		else
		{
			myInventory.add(i);
			return true;
		}
	}
	
	public void removeItem(GameItem i)
	{
		this.myInventory.remove(i);
	}

	public List<GameItem> getMyInventory() {
		return myInventory;
	}

	public double getMyCapacity() {
		return myCapacity;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyCapacity(double myCapacity) {
		this.myCapacity = myCapacity;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}
	
	
	
	
}
