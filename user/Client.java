package user;

public abstract class Client {
	protected String name;
	protected String BI;
	protected String email;
	protected String tell;
	protected String clientCode;

	public String getName      () { return name;       }
	public String getBI        () { return BI;         }
	public String getEmail     () { return email;      }
	public String getTell      () { return tell;       }
	public String getClientCode() { return clientCode; }

	public abstract void setName();
	public abstract void setBI();
	public abstract void setEmail();
	public abstract void setTell();
	public abstract void setClientCode();
}
