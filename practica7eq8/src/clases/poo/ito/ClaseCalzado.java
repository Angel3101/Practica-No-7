package clases.poo.ito;

//import java.time.LocalDate;
import java.util.HashSet;
// Start of user code (user defined imports)
import java.util.Scanner;
import interfaces.ito.poo.Arreglo;
// End of user code

/**
 * Description of ClaseCalzado.
 * 
 * @author hp
 */
public class ClaseCalzado implements Comparable<ClaseCalzado>{
	private int contColores;

	public ClaseCalzado(int clave, String material, String troquel, int cantProdxDia, HashSet<String> colores, int contColores) {
		super();
		this.clave = clave;
		this.material = material;
		this.troquel = troquel;
		this.cantProdxDia = cantProdxDia;
		this.colores = colores;
		this.contColores = contColores;
	}

	public int clave = 0;
	public String material = "";
	public String troquel = "";
	public int cantProdxDia = 0;
	public HashSet<String> colores = new HashSet<String>();

	public ClaseCalzado() {
		// Start of user code constructor for ClaseCalzado)
		super();
		this.lotes=new ClaseCalzado[INC];
		this.ultimo=-1; // Indica que esta vacio el arreglo
		// End of user code
	}

	/**
	 * Description of the method costoxLote.
	 * @param  
	 * @return 
	 */
	
	public float getcostoxLote(float costoxUnidad) {
		
		float costoxLote = 0F;
		
		float costos=0;
		float numUnidades=0;
		
		System.out.println("Ingrese el costo por unidad");
		Scanner entrada=new Scanner(System.in);
		costos=entrada.nextInt();
		
		System.out.println("Ingrese número de unidades que contiene el lote");
		cantProdxDia=entrada.nextInt();
		costoxLote=costos*cantProdxDia;
		return costoxLote;
	}
	public void setcostoxLote(int newcostoxLote) {
		this.cantProdxDia = newcostoxLote;
	}

	/**
	 * Returns clave.
	 * @return clave 
	 */
	public int getClave() {
		return this.clave;
	}

	/**
	 * Sets a value to attribute clave. 
	 * @param newClave 
	 */
	public void setClave(int newClave) {
		this.clave = newClave;
	}

	/**
	 * Returns material.
	 * @return material 
	 */
	public String getMaterial() {
		return this.material;
	}

	/**
	 * Sets a value to attribute material. 
	 * @param newMaterial 
	 */
	public void setMaterial(String newMaterial) {
		this.material = newMaterial;
	}

	/**
	 * Returns troquel.
	 * @return troquel 
	 */
	public String getTroquel() {
		return this.troquel;
	}

	/**
	 * Sets a value to attribute troquel. 
	 * @param newTroquel 
	 */
	public void setTroquel(String newTroquel) {
		this.troquel = newTroquel;
	}

	/**
	 * Returns cantProdxDia.
	 * @return cantProdxDia 
	 */
	public int getCantProdxDia() {
		return this.cantProdxDia;
	}

	/**
	 * Sets a value to attribute cantProdxDia. 
	 * @param newCantProdxDia 
	 */
	public void setCantProdxDia(int newCantProdxDia) {
		this.cantProdxDia = newCantProdxDia;
	}

	/**
	 * Returns colores.
	 * @return colores 
	 */
	
	public HashSet<String> getColores() {
		return this.colores;
		
	}

	public void setColores(HashSet<String> newcolores) {
		this.colores = newcolores;
	}
	
	
	@Override
	public String toString() {
		
		return "ClaseCalzado [clave=" + clave + ", material=" + material + ", troquel=" + troquel + ", cantProdxDia="
				+cantProdxDia + ", colores=" + colores + "]";
		
		
		
	}
	

	@Override
	public int compareTo(ClaseCalzado arg0) {
		// TODO Auto-generated method stub
		int compare=0;
			/**if (this.Clave<o.getClave())
			compare=-1;
		else if(this.Clave>o.getClave())
			compare=1;**/
		float costos=0;
		float costoxLote=costos*cantProdxDia;
		return 0;
	}

	private ClaseCalzado lotes[]=null;
	private int ultimo=0;
	private final int INC=5;
		
	private void crecerArreglo() {
		ClaseCalzado copia[]=new ClaseCalzado[this.lotes.length+INC];
		for(int i=0;i<lotes.length;i++)
			copia[i]=this.lotes[i];
		lotes=copia;
	}

	public boolean addItem(ClaseCalzado item) {
		boolean r=false;
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
					r=true;
				}
		return r;
	}

	
	public boolean existeItem(ClaseCalzado item) {
		boolean existe=false;
		for(int i=0;i<=this.ultimo;i++)
			if(item.compareTo(this.lotes[i])==0) {
				existe=true;
				break;
			}
					
		return existe;
	}
	
	public ClaseCalzado getItem(int i) {
		ClaseCalzado cal=null;
		if(i<=this.ultimo&&!this.isFree())
			cal=this.lotes[i];
		return cal;
	}

	public int getSize() {
		return this.ultimo+1;
	}

	public boolean isFree() {
			return this.ultimo==-1;
		}
	public boolean isFull() {
		return this.ultimo+1==this.lotes.length;
	}

	

	public boolean clear(ClaseCalzado nueva) {
		boolean borrar=false;
		if(this.existeItem(nueva)) {
			int i=0;
			for(i=0;i<=this.ultimo;i++)
				if(nueva.compareTo(this.lotes[i])==0)
					break;
			for(i=i;i<=this.ultimo;i++)
				lotes[i]=lotes[i+1];
			this.ultimo--;
			borrar=true;
		}
		return borrar;
	}

}
