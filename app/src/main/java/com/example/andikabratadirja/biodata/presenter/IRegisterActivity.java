package com.example.andikabratadirja.biodata.presenter;

public interface IRegisterActivity {

    void checkInputan();
    boolean cekPassword(String Password, String confirmPassword);
    boolean cekUser(String Username);

}
