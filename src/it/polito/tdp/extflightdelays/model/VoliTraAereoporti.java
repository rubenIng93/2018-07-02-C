package it.polito.tdp.extflightdelays.model;

public class VoliTraAereoporti implements Comparable<VoliTraAereoporti>{
	
	private Airport aereoportoO;
	private Airport aereoportoD;
	private Integer nVoli;
	
	public VoliTraAereoporti(Airport aereoportoO, Airport aereoportoD, Integer nVoli) {
		super();
		this.aereoportoO = aereoportoO;
		this.aereoportoD = aereoportoD;
		this.nVoli = nVoli;
	}

	public Airport getAereoportoO() {
		return aereoportoO;
	}

	public void setAereoportoO(Airport aereoportoO) {
		this.aereoportoO = aereoportoO;
	}

	public Airport getAereoportoD() {
		return aereoportoD;
	}

	public void setAereoportoD(Airport aereoportoD) {
		this.aereoportoD = aereoportoD;
	}

	public Integer getnVoli() {
		return nVoli;
	}

	public void setnVoli(Integer nVoli) {
		this.nVoli = nVoli;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aereoportoD == null) ? 0 : aereoportoD.hashCode());
		result = prime * result + ((aereoportoO == null) ? 0 : aereoportoO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoliTraAereoporti other = (VoliTraAereoporti) obj;
		if (aereoportoD == null) {
			if (other.aereoportoD != null)
				return false;
		} else if (!aereoportoD.equals(other.aereoportoD))
			return false;
		if (aereoportoO == null) {
			if (other.aereoportoO != null)
				return false;
		} else if (!aereoportoO.equals(other.aereoportoO))
			return false;
		return true;
	}

	@Override
	public int compareTo(VoliTraAereoporti o) {
		// TODO Auto-generated method stub
		return o.getnVoli() - this.getnVoli();
	}
}
	
	
	
	
	
