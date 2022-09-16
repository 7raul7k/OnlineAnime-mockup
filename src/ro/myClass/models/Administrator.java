package ro.myClass.models;

public class Administrator extends User {
    private String studioName;
    private String domain;
    public Administrator(int id,String firstName,String lastName,String email,String password,String adress,boolean isActive,String studioName,String domain){
        super("administrator", id, firstName, lastName, email, password, adress, isActive);
        this.studioName = studioName;
        this.domain = domain;
    }
    public Administrator(String text){
        super(text);
        String[] proprietes = text.split(",");
        this.studioName = proprietes[8];
        this.domain = proprietes[9];
    }
    public String show(){
        String text = "";
        text += super.show();
        text += "Studio name: " + studioName;
        text += "Domain: " + domain;
        text += "\n====================================\n";
        return text;
    }
    @Override
    public String toString(){
        String text = "";
        text += super.show();
        text += "Studio name: " + studioName;
        text += "Domain: " + domain;
        return text;
    }

    public String toSave(){
        return super.toSave()+","+studioName+","+domain;
    }
    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
