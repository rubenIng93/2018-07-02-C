package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		model.creaGrafo(5);
		
		System.out.println(model.getIdMapAirport().values().size());

	}

}
