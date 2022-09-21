package ToxPredictor.Application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Vector;

public class PredictionResults {

	private String reportBase;
	
	
    private String Smiles;//test chemical CAS (chemical being predicted)
    

	private String DTXSID;//test chemical CAS (chemical being predicted)
    private String CAS;//test chemical CAS (chemical being predicted)

    private String endpoint; //endpoint being calculated
    private String method;//method used to calculate endpoint
    private String error;
    
    public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	private int imgSize;//size of image to display
    
    private String webImagePathByCID;//path to get images on Chemistry Dashboard
    private String webImagePathBySID;//path to get images on Chemistry Dashboard
    
    public String getWebImagePathBySID() {
		return webImagePathBySID;
	}

	public void setWebImagePathBySID(String webImagePathBySID) {
		this.webImagePathBySID = webImagePathBySID;
	}

	private String webPathDashboardPage;//path to get property prediction page on Chemistry Dashboard 
    
    private double SCmin;//minimum similar coefficient for chemicals to display in similar chemicals table
    private boolean isBinaryEndpoint;//whether endpoint is binary (i.e. mutagenicity)
    private boolean isLogMolarEndpoint;// whether endpoint is log molar (i.e. fathead minnow LC50)
    
    private String imageURL;//can be used for test chemical image for consensus table and similar chemicals tables

    private boolean createDetailedReport;
    
    private ClusterTable clusterTable;
    private ClusterTable invalidClusterTable;


	// Main results table:
	private PredictionResultsPrimaryTable predictionResultsPrimaryTable = new PredictionResultsPrimaryTable();

	
	//Consensus predictions table:
	private MOATable moaTable = new MOATable();

	
	//Consensus predictions table:
	private IndividualPredictionsForConsensus individualPredictionsForConsensus;
    
	//Similar chemicals tables for test and training sets:
	private Vector<SimilarChemicals> similarChemicals = new Vector<>();

	
	public String getReportBase() {
		return reportBase;
	}

	public void setReportBase(String reportBase) {
		this.reportBase = reportBase;
	}

	public ClusterTable getClusterTable() {
		return clusterTable;
	}

	public void setClusterTable(ClusterTable clusterTable) {
		this.clusterTable = clusterTable;
	}

	public ClusterTable getInvalidClusterTable() {
		return invalidClusterTable;
	}

	public void setInvalidClusterTable(ClusterTable invalidClusterTable) {
		this.invalidClusterTable = invalidClusterTable;
	}

	public boolean isCreateDetailedReport() {
		return createDetailedReport;
	}

	public void setCreateDetailedReport(boolean createDetailedReport) {
		this.createDetailedReport = createDetailedReport;
	}


	public MOATable getMoaTable() {
		return moaTable;
	}

	public void setMoaTable(MOATable moaTable) {
		this.moaTable = moaTable;
	}

    public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public boolean isLogMolarEndpoint() {
		return isLogMolarEndpoint;
	}

	public void setLogMolarEndpoint(boolean isLogMolarEndpoint) {
		this.isLogMolarEndpoint = isLogMolarEndpoint;
	}


    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getCAS() {
        return CAS;
    }

    @JsonProperty("CAS")
    public void setCAS(String CAS) {
        this.CAS = CAS;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Vector<SimilarChemicals> getSimilarChemicals() {
        return similarChemicals;
    }

    public void setSimilarChemicals(Vector<SimilarChemicals> similarChemicals) {
        this.similarChemicals = similarChemicals;
    }

    public IndividualPredictionsForConsensus getIndividualPredictionsForConsensus() {
        return individualPredictionsForConsensus;
    }

    public void setIndividualPredictionsForConsensus(IndividualPredictionsForConsensus individualPredictionsForConsensus) {
        this.individualPredictionsForConsensus = individualPredictionsForConsensus;
    }

    public double getSCmin() {
        return SCmin;
    }

    @JsonProperty("SCmin")
    public void setSCmin(double SCmin) {
        this.SCmin = SCmin;
    }

    public PredictionResultsPrimaryTable getPredictionResultsPrimaryTable() {
        return predictionResultsPrimaryTable;
    }

    public void setPredictionResultsPrimaryTable(PredictionResultsPrimaryTable predictionResultsPrimaryTable) {
        this.predictionResultsPrimaryTable = predictionResultsPrimaryTable;
    }

    public boolean isBinaryEndpoint() {
        return isBinaryEndpoint;
    }

    @JsonProperty("isBinaryEndpoint")
    public void setBinaryEndpoint(boolean isBinaryEndpoint) {
        this.isBinaryEndpoint = isBinaryEndpoint;
    }

    public int getImgSize() {
        return imgSize;
    }

    public void setImgSize(int imgSize) {
        this.imgSize = imgSize;
    }

    public String getWebImagePathByCID() {
        return webImagePathByCID;
    }

    public void setWebImagePathByCID(String webPath) {
        this.webImagePathByCID = webPath;
    }

    public String getWebPathDashboardPage() {
        return webPathDashboardPage;
    }

    public void setWebPathDashboardPage(String webPathDashboardPage) {
        this.webPathDashboardPage = webPathDashboardPage;
    }
    
    public String getSmiles() {
		return Smiles;
	}

	public void setSmiles(String smiles) {
		Smiles = smiles;
	}

	public String getDTXSID() {
		return DTXSID;
	}

	public void setDTXSID(String dTXSID) {
		DTXSID = dTXSID;
	}

}
