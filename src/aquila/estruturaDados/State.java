package aquila.estruturaDados;

public class State {

	private String name;

	public String getName() {
		return name;
	}
	
	public State(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof State))return false;
		
		State temp = (State) other;
		if(temp.getName().equals(this.getName()))return true;
		return false;
	}
	
	@Override
	public String toString()
	{
		return this.getName();
	}
	
	public int hashCode() {
	     return this.getName().hashCode();
	  }
}
