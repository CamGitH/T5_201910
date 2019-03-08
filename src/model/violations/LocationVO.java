package model.violations;

public class LocationVO implements Comparable<LocationVO> {

	private int addressID, numberOfRegisters;
	
	private String stringLocation;

	public LocationVO(int pAddressID, int pNumberOfRegisters, String pStringLocation) {

		addressID = pAddressID;
		numberOfRegisters = pNumberOfRegisters;
		stringLocation = pStringLocation;
	}

	/**
	 * @return the addressID
	 */
	public int getAddressID() {
		return addressID;
	}

	/**
	 * @param pAddressID the addressID to set
	 */
	public void setAddressID(int pAddressID) {
		this.addressID = pAddressID;
	}

	/**
	 * @return the numberOfRegisters
	 */
	public int getNumberOfRegisters() {
		return numberOfRegisters;
	}

	/**
	 * @param pNumberOfRegisters the numberOfRegisters to set
	 */
	public void setNumberOfRegisters(int pNumberOfRegisters) {
		this.numberOfRegisters = pNumberOfRegisters;
	}

	/**
	 * @return the stringLocation
	 */
	public String getStringLocation() {
		return stringLocation;
	}

	/**
	 * @param pStringLocation the stringLocation to set
	 */
	public void setStringLocation(String pStringLocation) {
		stringLocation = pStringLocation;
	}

	public int compareTo(LocationVO pLocation) {
		int numero = 0;
		
		if((numberOfRegisters>pLocation.getNumberOfRegisters())){
			numero = -1;
		}
		else if((numberOfRegisters<(pLocation.getNumberOfRegisters()))){
			numero = 1;
		}
		else{
			if(stringLocation.compareToIgnoreCase(pLocation.getStringLocation())==0){
				numero = 0;
			}
			else if(stringLocation.compareToIgnoreCase(pLocation.getStringLocation())==-1){
				numero = -1;
				}
			else if(stringLocation.compareToIgnoreCase(pLocation.getStringLocation())==1){
				numero = 1;
				}
		}
		return numero;
	}
	
	
	
}
