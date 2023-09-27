package DTO;

public class departDTO {
	 private String d_id;
	    private String d_name;
	    private String d_url;

	    public departDTO() {
	    }

	    public departDTO(String d_id, String d_name, String d_url) {
	        this.d_id = d_id;
	        this.d_name = d_name;
	        this.d_url = d_url;
	    }

	    public String getD_id() {
	        return d_id;
	    }

	    public void setD_id(String d_id) {
	        this.d_id = d_id;
	    }

	    public String getD_name() {
	        return d_name;
	    }

	    public void setD_name(String d_name) {
	        this.d_name = d_name;
	    }

	    public String getD_url() {
	        return d_url;
	    }

	    public void setD_url(String d_url) {
	        this.d_url = d_url;
	    }
}
