package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao ;
	private Map<Integer, Airport> idMapAirport;
	
	public Model() {
		
		this.dao = new ExtFlightDelaysDAO();
		this.idMapAirport = new HashMap<>();
		dao.loadAllAirports(idMapAirport);
		
	}
	
	public void creaGrafo(Integer limite) {
		
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, dao.numMinimoCompagnie(limite, idMapAirport));
		Graphs.addAllVertices(this.grafo, dao.numMinimoCompagnieDestinazione(limite, idMapAirport));
		
		for(VoliTraAereoporti vta : dao.getVoliTraAereoporti(idMapAirport)) {
			
			if(this.grafo.containsVertex(vta.getAereoportoO()) && this.grafo.containsVertex(vta.getAereoportoD())) {
				
				Graphs.addEdgeWithVertices(grafo, vta.getAereoportoO(), vta.getAereoportoD(), vta.getnVoli());
				
			}
		
					
		}
		
		System.out.println("Grafo creato!!!\n#vertici: "+grafo.vertexSet().size()+"\n#archi: "+grafo.edgeSet().size());
	}
	
	public List<VoliTraAereoporti> getAdiacentiConPeso(Airport partenza){
		
		List<VoliTraAereoporti> result = new ArrayList<>();
		
		for(Airport a : Graphs.neighborListOf(grafo, partenza)) {
			
			Double peso = grafo.getEdgeWeight(grafo.getEdge(partenza, a));
			
			VoliTraAereoporti vta = new VoliTraAereoporti(partenza, a, peso.intValue());
			
			result.add(vta);
			
		}
		
		Collections.sort(result);
		
		return result;
		
		
	}

	public Graph<Airport, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}

	public Map<Integer, Airport> getIdMapAirport() {
		return idMapAirport;
	}
	
	

}
