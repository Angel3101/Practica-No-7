package clases.poo.ito;

import interfaces.ito.poo.Arreglo;
public class OperacionesClaseCalzado implements Arreglo<ClaseCalzado> {

	private ClaseCalzado lotes[]=null;
	private int ultimo=0;
	private final int INC=5;
	
	public OperacionesClaseCalzado() {
		super();
		this.lotes=new ClaseCalzado[INC];
		this.ultimo=-1; // Indica que esta vacio el arreglo
	}
	
	
	private void crecerArreglo() {
		ClaseCalzado copia[]=new ClaseCalzado[this.lotes.length+INC];
		for(int i=0;i<lotes.length;i++)
			copia[i]=this.lotes[i];
		lotes=copia;
	}
	
	@Override
	public boolean addItem(ClaseCalzado item) {
		boolean add=false;
		if(!this.existeItem(item)) {
		if(this.isFull()) 
			crecerArreglo();
		int j=0;
		for(;j<=this.ultimo;j++)
			if(item.compareTo(this.lotes[j])<0) {
				break;
				}
				
				for(int i=this.ultimo;i>=j;i--)
					lotes[i+1]=lotes[i];
				this.lotes[j]=item;
				this.ultimo++;
				add=true;
			}
		return add;
	}

	@Override
	public boolean existeItem(ClaseCalzado item) {
		boolean existe=false;
		for(int i=0;i<=this.ultimo;i++)
			if(item.compareTo(this.lotes[i])==0) {
				existe=true;
				break;
			}
					
		return existe;
	}

	@Override
	public ClaseCalzado getItem(int pos) {
		ClaseCalzado cal=null;
		if(pos<=this.ultimo&&!this.isFree())
			cal=this.lotes[pos];
		return cal;
	}

	@Override
	public int getSize() {
		return this.ultimo+1;
	}

	@Override
	public boolean clear(ClaseCalzado item) {
		boolean borrar=false;
		if(this.existeItem(item)) {
			int i=0;
			for(;i<=this.ultimo;i++)
				if(item.compareTo(this.lotes[i])==0)
					break;
			for(;i<=this.ultimo;i++)
				lotes[i]=lotes[i+1];
			this.ultimo--;
			borrar=true;
		}
		return borrar;
	}

	@Override
	public boolean isFree() {
		return this.ultimo==-1;
	}

	@Override
	public boolean isFull() {
		return this.ultimo+1==this.lotes.length;
	}

}
