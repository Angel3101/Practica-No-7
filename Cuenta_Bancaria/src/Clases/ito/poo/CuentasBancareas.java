

package Clases.ito.poo;

import Clases.ito.poo.Arreglo;
public class CuentasBancareas implements Arreglo<Cuenta_Bancaria> {

	

	private Cuenta_Bancaria cuentas[]=null;
	private int ultimo=0;
	private final int INC=5;
	
	public CuentasBancareas() {
		super();
		this.cuentas=new Cuenta_Bancaria[INC];
		this.ultimo=-1; // Indica que esta vacio el arreglo
	}
	
	
	public void crecerArreglo() {
		Cuenta_Bancaria copia[]=new Cuenta_Bancaria[this.cuentas.length+INC];
		for(int i=0;i<cuentas.length;i++)
			copia[i]=this.cuentas[i];
		cuentas=copia;
	}
	
	@Override
	public boolean addItem(Cuenta_Bancaria item) {
		boolean add=false;
		if(!this.existeItem1(item)) {
		if(this.isFull()) 
			crecerArreglo();
		int j=0;
		for(;j<=this.ultimo;j++)
			if(item.compareTo(this.cuentas[j])<0) {
				break;
				}
				
				for(int i=this.ultimo;i>=j;i--)
					cuentas[i+1]=cuentas[i];
				this.cuentas[j]=item;
				this.ultimo++;
				add=true;
			}
		return add;
	}


	public boolean existeItem1(Cuenta_Bancaria item) {
		boolean existe=false;
		for(int i=0;i<=this.ultimo;i++)
			if(item.compareTo(this.cuentas[i])==0) {
				existe=true;
				break;
			}
					
		return existe;
	}

	public Cuenta_Bancaria getItem1(int pos) {
		Cuenta_Bancaria cb=null;
		if(pos<=this.ultimo&&!this.isFree())
			cb=this.cuentas[pos];
		return cb;
	}

	@Override
	public int getSize() {
		return this.ultimo+1;
	}

	public boolean clear1(Cuenta_Bancaria item) {
		boolean borrar=false;
		if(this.existeItem1(item)) {
			int i=0;
			for(;i<=this.ultimo;i++)
				if(item.compareTo(this.cuentas[i])==0)
					break;
			for(;i<=this.ultimo;i++)
				cuentas[i]=cuentas[i+1];
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
		
		return this.ultimo+1==this.cuentas.length;
	}


	
	public Cuenta_Bancaria getItem11(int pos) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean addItem1(Cuenta_Bancaria item) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean existeItem(Cuenta_Bancaria item) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Cuenta_Bancaria getItem(int pos) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean clear(Cuenta_Bancaria item) {
		// TODO Auto-generated method stub
		return false;
	
	}
}
	
	


	