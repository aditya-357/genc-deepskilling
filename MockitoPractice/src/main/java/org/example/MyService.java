package org.example;

public class MyService {

    private Externalapi api;

    public MyService(Externalapi api ){
        this.api = api;
    }

    public String fetchData(){
        return api.getData();
    }

}
