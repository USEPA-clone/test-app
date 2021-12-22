package ToxPredictor.Application.model;


import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimilarChemical {

    
    private String DSSTOXSID;
    private String DSSTOXCID;
    public String getDSSTOXCID() {
		return DSSTOXCID;
	}

	public void setDSSTOXCID(String dSSTOXCID) {
		DSSTOXCID = dSSTOXCID;
	}

	private String CAS;
    private String backgroundColor;
    private String similarityCoefficient;
    private String expVal;
    private String predVal;
    private String imageUrl;


    public String getDSSTOXSID() {
        return DSSTOXSID;
    }

    @JsonProperty("DSSTOXSID")
    public void setDSSTOXSID(String DSSTOXSID) {
        this.DSSTOXSID = DSSTOXSID;
    }

    public String getCAS() {
        return CAS;
    }

    @JsonProperty("CAS")
    public void setCAS(String CAS) {
        this.CAS = CAS;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getSimilarityCoefficient() {
        return similarityCoefficient;
    }

    public void setSimilarityCoefficient(String similarityCoefficient) {
        this.similarityCoefficient = similarityCoefficient;
    }

    public String getExpVal() {
        return expVal;
    }

    public void setExpVal(String expVal) {
        this.expVal = expVal;
    }

    public String getPredVal() {
        return predVal;
    }

    public void setPredVal(String predVal) {
        this.predVal = predVal;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

	public LinkedHashMap<String, String> convertToLinkedHashMap() {
		// TODO Auto-generated method stub
		LinkedHashMap<String,String> lhm=new LinkedHashMap();
		lhm.put("CAS",CAS);
		lhm.put("Structure",imageUrl);
		lhm.put("Similarity", similarityCoefficient);
		lhm.put("Experimental value", expVal);
		lhm.put("Predicted value", predVal);
		lhm.put("backgroundColor", backgroundColor);
		return lhm;
	}
}
