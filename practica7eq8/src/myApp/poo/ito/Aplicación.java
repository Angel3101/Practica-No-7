package myApp.poo.ito;
import java.time.LocalDate;
import clases.poo.ito.ClaseCalzado;
//import clases.poo.ito.OperacionesClaseCalzado;
import javax.swing.JOptionPane;
public class Aplicación {
static ClaseCalzado c;
	
	static void menu() {
		inicializa();
		boolean ciclo=true;
		int respuesta=0;
		while(ciclo) {
		String opciones="Elija la opción que desee:\n 1)Agregar lote\n 2)Mostrar lotes\n 3)borrarLote\n 4)Exit";
		respuesta=Integer.parseInt(JOptionPane.showInputDialog(opciones));
		switch(respuesta) {
		case 1:agregarLote();/**JOptionPane.showMessageDialog(null);**/;break;
		case 2:mostrarLotes();break;
		case 3:borrarLote();break;
		case 4:ciclo=false;break;
		default:JOptionPane.showMessageDialog(null,"Ingrese una de las opciones indicadas por favor");
		  }
		}
	}
	static ClaseCalzado capturarLote() {
		ClaseCalzado n=new ClaseCalzado();
		long l;String fecha,material, troquel, colores;float costoxUnidad; int clave,cantProdxDia;
		//l=Long.parseLong(JOptionPane.showInputDialog("Proporciona el número de lotes por día:"));
		clave=Integer.parseInt(JOptionPane.showInputDialog("Proporciona la clave del calzado:"));
		material=JOptionPane.showInputDialog("Proporciona material del que está hecho el calzado:");
		troquel=JOptionPane.showInputDialog("Proporciona troquel el calzado:");
		cantProdxDia=Integer.parseInt(JOptionPane.showInputDialog("Proporciona la cantidad de calzado producida por dia:"));
		colores=JOptionPane.showInputDialog("Proporciona color del calzado:");
		costoxUnidad=Float.parseFloat(JOptionPane.showInputDialog("Proporciona el costo por unidad:"));
		
		n.setClave(clave);
		n.setMaterial(material);
		n.setTroquel(troquel);
		n.setCantProdxDia(cantProdxDia);
		n.setColores(null);
		
		//n.setcostoxUnidad(costoxUnidad);
		
		return n;
	}
	private static void inicializa() {
		c=new ClaseCalzado();
		
	}
	static void agregarLote() {
		ClaseCalzado item;
		item=capturarLote();
		if(c.addItem(item))
			JOptionPane.showMessageDialog(null,"Se ha agregado el lote con exito!!");
		else
			JOptionPane.showMessageDialog(null,"Error:el lote ya existe!!");
	}
	static void mostrarLotes() {
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no hay ningun lote");
		else {
		String lotes="";
		for(int i=0;i<c.getCantProdxDia();i++)
			lotes=lotes+"\n"+(c.getItem(i));
		JOptionPane.showMessageDialog(null,lotes);
		}
	}
	
	static void borrarLote() {
		int pos=0;
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no hay ningun lote");
		else {
			boolean bandera=true;
			while(bandera) {
		    String lotes="";
		    for(int i=0;i<c.getSize();i++)
			    lotes=lotes+"\n"+(i+1)+")"+(c.getItem(i));
		    pos=Integer.parseInt(JOptionPane.showInputDialog("Cual lote desea dar de baja?\n"+lotes));
		    if((c.getSize())>=pos&&pos>0) {
		    	c.clear(c.getItem(pos-1));
		    	JOptionPane.showMessageDialog(null,"lote dada de baja con éxito!!");
		    	bandera=false;
		    }	
		    else
		    	JOptionPane.showMessageDialog(null,"Ese lote no existe!!");
		  }
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
