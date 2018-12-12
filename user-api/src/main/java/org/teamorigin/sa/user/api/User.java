package org.teamorigin.sa.user.api;

public class User {

    private String name,id,mobile_no;

    public User(){
    }

    public User(String name,String id,String mobile_no){

        this.name = name;
        this.id = id;
        this.mobile_no = mobile_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
}
