package entity;

public class AjaxsEntity {
    private int stuid;
	private String name;
	private String pwd;
	private String code;
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public AjaxsEntity(int stuid, String name, String pwd, String code) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.pwd = pwd;
		this.code = code;
	}
	public AjaxsEntity(String name, String pwd, String code) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.code = code;
	}
	public AjaxsEntity() {
		super();
	}
	   
}
