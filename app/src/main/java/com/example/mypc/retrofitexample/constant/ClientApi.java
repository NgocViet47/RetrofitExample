package com.example.mypc.retrofitexample.constant;


import com.example.mypc.retrofitexample.repository.TicketBoxService;

public class ClientApi extends BaseApi {
    public TicketBoxService getTicketBoxService() {
        return this.getService(TicketBoxService.class, ConstantApi.BASE_URL);
    }

}