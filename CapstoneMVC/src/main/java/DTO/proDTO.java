package DTO;

public class proDTO {
	 private String p_id;
	    private String d_id;
	    private String p_name;
	    private String p_url;

	    public proDTO() {
	    }

	    public proDTO(String p_id, String d_id, String p_name, String p_url) {
	        this.p_id = p_id;
	        this.d_id = d_id;
	        this.p_name = p_name;
	        this.p_url = p_url;
	    }

	    public String getP_id() {
	        return p_id;
	    }

	    public void setP_id(String p_id) {
	        this.p_id = p_id;
	    }

	    public String getD_id() {
	        return d_id;
	    }

	    public void setD_id(String d_id) {
	        this.d_id = d_id;
	    }

	    public String getP_name() {
	        return p_name;
	    }

	    public void setP_name(String p_name) {
	        this.p_name = p_name;
	    }

	    public String getP_url() {
	        return p_url;
	    }

	    public void setP_url(String p_url) {
	        this.p_url = p_url;
	    }
	}

