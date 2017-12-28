package aquila.estruturaDados;

public class Transition  {
	
	private State origin;
	private State destination;
	private String input;
	
	public Transition(State o, State d, String i)
	{
		this.origin = o;
		this.destination = d;
		this.input = i;
	}

	public State getOrigin() {
		return origin;
	}
	
	public State getDestination() {
		return destination;
	}
	
	public String getInput() {
		return input;
	}
	
	public String toString()
	{
		return origin.toString() + " - " + input + " - " + destination.toString();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Transition))return false;
		
		Transition temp = (Transition) other;
		if(temp.getOrigin().equals(this.getOrigin()) && temp.getInput().equals(this.getInput()) 
				&& temp.getDestination().equals(this.getDestination()))return true;
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return getInput().hashCode();
	}
}
