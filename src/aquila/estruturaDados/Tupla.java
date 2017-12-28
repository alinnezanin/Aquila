package aquila.estruturaDados;

public class Tupla<T,V> {

	T pri;
	V seg;
	
	public Tupla(T pri, V seg)
	{
		this.pri = pri;
		this.seg = seg;
	}
	
	public T getPri()
	{
		return this.pri;
	}
	public V getSeg()
	{
		return this.seg;
	}
}
