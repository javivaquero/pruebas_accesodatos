package prconcesionario;

import java.util.ArrayList;

import dao.CocheDao;
import dao.MarcaDao;
import pojo.Coche;
import pojo.Marca;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marca m = new Marca("Opel");
		Marca ma = new Marca("Honda");
		Marca mb = new Marca("Toyota");
		Marca mc = new Marca(4,"Audi");
		Coche c = new Coche(1,"Corsa",60,1998,5,1);
		Coche ca = new Coche("Accord",110,2006,5,2);
		Coche cb = new Coche("Civic",192,1998,5,2);
		Coche cc = new Coche("Supra",320,1998,5,3);
		Coche cde = new Coche(5,"A3",105,2001,5,4);
		MarcaDao md = new MarcaDao();
		CocheDao cd = new CocheDao();
		
		//INSERTAR
		md.insertar(m);
		md.insertar(ma);
		md.insertar(mb);
		md.insertar(mc);
		cd.insertar(c);
		cd.insertar(ca);
		cd.insertar(cb);
		cd.insertar(cc);
		cd.insertar(cde);
		
		//MODIFICAR
		Marca m2 = new Marca (1,"Mazda");
		md.modificar(m2);
		Coche c2 = new Coche(1,"MX5",180,2017,6,1);
		cd.modificar(c2);
	
		//BORRAR		
		md.borrar(mc);
		cd.borrar(ca);
		
		//BUSCAR TODOS
		System.out.println(md.buscarTodos());
		System.out.println(cd.buscarTodos());
		
		//BUSCAR POR ID
		System.out.println(md.buscarPorId(1));
		System.out.println(cd.buscarPorId(1));
		
		
		
	}

}
