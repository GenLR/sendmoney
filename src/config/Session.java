
package config;


public class Session {
    
    private static Session instance;
    private String eid;
    private String name;
    private String username;
    private String password;
    private String acctype;
    private String status;

    private Session(){
         
    }

    public static synchronized Session getInstance() {
        if(instance == null){
            instance = new Session();
        }
        
        return instance;
    }

    public static boolean isInstanceEmpty() {
        return instance == null;
    }
    
    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
