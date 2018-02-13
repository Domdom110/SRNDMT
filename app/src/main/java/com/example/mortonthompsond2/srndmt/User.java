package com.example.mortonthompsond2.srndmt;

/**
 * Created by mortonthompsond2 on 2/1/2018.
 */

public class User {
    // Labels table name
    public static final String TABLE = "User";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_email = "email";
    public static final String KEY_age = "age";
    public static final String Key_password = "password";

    // property help us to keep data
    public int user_ID;
    public String name;
    public String email;
    public int age;
    public String password;
}


/*public class User {
    private int id;
    private String name;
    private String address;
    public User()
    {

    }
    public User (int id,String name,String address)
    {
        this.id=id;
        this.name=name;
        this.address=address;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
}
*/
