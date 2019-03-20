package source.sirnigelcogs.cabintown;

public class Item {
	
	private String description;
	private String id;
	private String title;
	
	private int doorway;
	
	private boolean getable;
	
	public Item(String id, String title, String description) {
		this.setId(id.toUpperCase());
		this.setTitle(title);
		this.setDescription(description);
		this.doorway = 0;
		this.getable = true;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getDoorway() {
		return doorway;
	}
	
	public void setDoorway(int loc) {
		doorway = loc;
	}
	
	public boolean isGetable() {
		return getable;
	}
	
	public void setGetable(boolean g) {
		getable = g;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
