package main;

import dao.SerieDao;
import pojo.Serie;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Serie s = new Serie("Los Simpsons", 7, "Disney Plus");
		SerieDao seriedao= new SerieDao();
		seriedao.insertar(s);
		
	}

}
