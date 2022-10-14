package prZoologicoDAO;

import clases.Animal;
import clases.AnimalDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal a = new Animal("Ardilla","Bosque",0.1);
		AnimalDAO.insertAnimal(a);
	}

}
