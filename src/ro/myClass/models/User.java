package ro.myClass.models;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String adress;
    private boolean isActive;

    private String type;

    public User(String type,int id,String firstName,String lastName,String email,String password,String adress,boolean isActive){
        this.type = type;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.adress = adress;
        this.isActive = isActive;
    }
    public User(String text){
        String[] proprietes = text.split(",");
        this.type = proprietes[0];
        this.id = Integer.parseInt(proprietes[1]);
        this.firstName = proprietes[2];
        this.lastName = proprietes[3];
        this.email = proprietes[4];
        this.password = proprietes[5];
        this.adress = proprietes[6];
        this.isActive = Boolean.parseBoolean(proprietes[7]);
    }
    public String show(){
        String text = "";
        text += "Type: " + type;
        text += "\nId: " + id;
        text += "\nFirst name: " + firstName;
        text += "\nLast name: " + lastName;
        text += "\nEmail: " + email;
        text += "\nPassword: " + password;
        text += "\n Adress: " + adress;
        text += "\n Is active? " + isActive;
        text += "\n======================================\n";
        return text;
    }
    @Override
    public String toString(){
        String text = "";
        text += "Type: " + type;
        text += "\nId: " + id;
        text += "\nFirst name: " + firstName;
        text += "\nLast name: " + lastName;
        text += "\nEmail: " + email;
        text += "\nPassword: " + password;
        text += "\n Adress: " + adress;
        text += "\n Is active? " + isActive;
        return text;
    }

    public String toSave(){
        return type+","+id+","+firstName+","+lastName+","+email+","+password+","+adress+","+isActive;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
