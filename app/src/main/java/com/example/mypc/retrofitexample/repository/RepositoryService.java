package com.example.mypc.retrofitexample.repository;

import android.content.Context;
import android.util.Log;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.constant.ClientApi;
import com.example.mypc.retrofitexample.constant.ConstantUtils;
import com.example.mypc.retrofitexample.model.TicketCheck;
import com.example.mypc.retrofitexample.model.responseResultModel.ResultResponse;
import com.example.mypc.retrofitexample.model.ShowingEvent;
import com.example.mypc.retrofitexample.model.StatusOrder;
import com.example.mypc.retrofitexample.model.StatusTicket;
import com.example.mypc.retrofitexample.model.User;
import com.example.mypc.retrofitexample.utils.UserManager;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseEventData;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseOrderShowInData;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseReportData;
import com.example.mypc.retrofitexample.realm.RealmStatus;
import com.example.mypc.retrofitexample.realm.RealmUser;
import com.example.mypc.retrofitexample.retrofit.GeneralMethods;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 5/31/2017.
 */

public class RepositoryService implements TicketboxRepository {
    private HashMap<String, String> getHeaders(Context context) {

        HashMap<String, String> headers = new HashMap<>();
        headers.put("X-Site-Id", String.valueOf(UserManager.getXSiteId(context)));
        headers.put("X-Device-Type", ConstantUtils.DEVICE_TYPE.ANDROID + "");
        headers.put("X-Access-Token", "1");

        if (RealmUser.getUser(context) != null) {
            String accessToken = UserManager.getAccessToken(context);
            if (accessToken != null && accessToken.length() > 0) {
                headers.put("X-Access-Token", accessToken);
            }
        }

        return headers;
    }
    private HashMap<String,Integer> getTicketId(){
        HashMap<String,Integer> ticketId = new HashMap<>();
        ticketId.put("ticket_id",0);
        return ticketId;
    }

    @Override
    public void login(final Context context, String email, String password, final CallBackData<User> callBackData) {
        ClientApi clientApi = new ClientApi();

        Call<ResponseBody> serviceCall = clientApi.getTicketBoxService().login(getHeaders(context), email, password, "1");
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response != null && response.body() != null) {
                    try {
                        String result = response.body().string();
                        Log.e("result", result);
                        Type type = new TypeToken<ResultResponse<User>>() {
                        }.getType();

                        ResultResponse<User> resultResponse = GeneralMethods.getGson().fromJson(result, type);

                        if (resultResponse != null) {
                            if (resultResponse.isSuccess()) {

                                User user = resultResponse.getData();
                                // save user to realm
                                RealmUser.createUser(context, user);
                                callBackData.onResponseData(user);

                            } else {
                                callBackData.onFailed(resultResponse.getMessage());
                            }
                        } else {
                            callBackData.onFailed(context.getString(R.string.msg_network_error));
                        }

                    } catch (IOException e) {
                        callBackData.onFailed(context.getString(R.string.msg_network_error));
                    }
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                if (t instanceof UnknownHostException) {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }
        });
    }

    @Override
    public void getStatusTicketBox(final Context context, final CallBackData<ResultResponse<List<Integer>>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> listCall = clientApi.getTicketBoxService().getStatusTicketbox(getHeaders(context));
        listCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {
                    try {
                        String result = response.body().string();
                        Log.e("result", result);
                        Type type = new TypeToken<ResultResponse<List<Integer>>>() {
                        }.getType();
                        ResultResponse<List<Integer>> resultResponse = GeneralMethods.getGson().fromJson(result, type);
                        if (resultResponse != null) {
                            if (resultResponse.isSuccess()) {
                                for (int i : resultResponse.getData()) {
                                    StatusTicket statusTicket = new StatusTicket();
                                    statusTicket.setData(i);
                                    RealmStatus.createStatusTicket(context, statusTicket);
                                }
                                callBackData.onResponseData(resultResponse);
                            } else {
                                callBackData.onFailed(resultResponse.getMessage());

                            }
                        } else {
                            callBackData.onFailed(context.getString(R.string.msg_network_error));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (t instanceof UnknownHostException) {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }
        });
    }

    @Override
    public void getStatusOrder(final Context context, final CallBackData<ResultResponse<List<Integer>>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> listCall = clientApi.getTicketBoxService().getStatusOrder(getHeaders(context));
        listCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {
                    try {
                        String result = response.body().string();
                        Log.e("result", result);
                        Type type = new TypeToken<ResultResponse<List<Integer>>>() {
                        }.getType();
                        ResultResponse<List<Integer>> resultResponse = GeneralMethods.getGson().fromJson(result, type);
                        if (resultResponse != null) {
                            if (resultResponse.isSuccess()) {

                                for (int i : resultResponse.getData()) {
                                    StatusOrder statusOrder = new StatusOrder();
                                    statusOrder.setData(i);
                                    RealmStatus.createStatusOrder(context, statusOrder);
                                }

                                callBackData.onResponseData(resultResponse);
                            } else {
                                callBackData.onFailed(resultResponse.getMessage());
                            }
                        } else {
                            callBackData.onFailed(context.getString(R.string.msg_network_error));
                        }

                    } catch (IOException e) {

                    }
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (t instanceof UnknownHostException) {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }
        });
    }

    @Override
    public void getEvents(final Context context, String timeZone, String lastSyncTime, final CallBackData<ResultResponse<ResponseEventData>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> callEvents = clientApi.getTicketBoxService().getEvents(getHeaders(context), timeZone, lastSyncTime);
        callEvents.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {
                    try {
                        String result = response.body().string();
                        Log.e("result", result);
                        Type type = new TypeToken<ResultResponse<ResponseEventData>>() {
                        }.getType();
                        ResultResponse<ResponseEventData> resultResponse = GeneralMethods.getGson().fromJson(result, type);
                        if (resultResponse != null) {
                            if (resultResponse.isSuccess()) {
                                callBackData.onResponseData(resultResponse);
                            } else {
                                callBackData.onFailed(resultResponse.getMessage());
                            }
                        } else {
                            callBackData.onFailed(context.getString(R.string.msg_network_error));
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (t instanceof UnknownHostException) {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }
        });
    }

    @Override
    public void resetPassword(Context context, String email) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> callResetPassword = clientApi.getTicketBoxService().resetPassword(getHeaders(context), email, "1");
        callResetPassword.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void getShowingByEventId(final Context context, Integer evnetId, String timeZone, final CallBackData<ResultResponse<List<ShowingEvent>>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> callShowingByEventId = clientApi.getTicketBoxService().getShowingByEventId(getHeaders(context), evnetId, timeZone);
        callShowingByEventId.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {

                    try {
                        String result = response.body().string();
                        Log.e("result", result);
                        Type type = new TypeToken<ResultResponse<List<ShowingEvent>>>() {
                        }.getType();
                        ResultResponse<List<ShowingEvent>> resultResponse = GeneralMethods.getGson().fromJson(result, type);
                        if (resultResponse != null) {
                            if (resultResponse.isSuccess()) {
                                callBackData.onResponseData(resultResponse);
                            } else {
                                callBackData.onFailed(resultResponse.getMessage());
                            }
                        } else {
                            callBackData.onFailed(context.getString(R.string.msg_network_error));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (t instanceof UnknownHostException) {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }
        });
    }

    @Override
    public void getRePorting(final Context context, Integer eventId, Integer showingId, String startDate, String endDate, String timeZone, final CallBackData<ResultResponse<ResponseReportData>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> callGetReportByEventIdAndShowingId = clientApi.getTicketBoxService().getRePorting(eventId, showingId, getHeaders(context),timeZone);
        callGetReportByEventIdAndShowingId.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {

                    try {
                        String result = response.body().string();
                        Log.e("result", result);
                        Type type = new TypeToken<ResultResponse<ResponseReportData>>() {
                        }.getType();
                        ResultResponse<ResponseReportData> resultResponse = GeneralMethods.getGson().fromJson(result, type);
                        if (resultResponse != null) {
                            if (resultResponse.isSuccess()) {
                                callBackData.onResponseData(resultResponse);
                            } else {
                                callBackData.onFailed(resultResponse.getMessage());
                            }
                        } else {
                            callBackData.onFailed(context.getString(R.string.msg_network_error));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (t instanceof UnknownHostException) {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }
        });
    }

    @Override
    public void getShowInOrder(final Context context, Integer showingId, String timeZone, final CallBackData<ResultResponse<ResponseOrderShowInData>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> callGetReportByEventIdAndShowingId = clientApi.getTicketBoxService().getShowInOrder(showingId,getHeaders(context),getTicketId(),getTicketId(),timeZone);
        callGetReportByEventIdAndShowingId.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {

                    try {
                        String result = response.body().string();
                        Log.e("result", result);
                        Type type = new TypeToken<ResultResponse<ResponseOrderShowInData>>() {
                        }.getType();
                        ResultResponse<ResponseOrderShowInData> resultResponse = GeneralMethods.getGson().fromJson(result, type);
                        if (resultResponse != null) {
                            if (resultResponse.isSuccess()) {
                                callBackData.onResponseData(resultResponse);
                            } else {
                                callBackData.onFailed(resultResponse.getMessage());
                            }
                        } else {
                            callBackData.onFailed(context.getString(R.string.msg_network_error));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (t instanceof UnknownHostException) {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }
        });
    }

    @Override
    public void postTicketCheckIn(final Context context, Integer showingId, String timeZone, List<TicketCheck> ticketCheckList, final CallBackData<ResultResponse<ResponseOrderShowInData>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> postTicketCheckIn = clientApi.getTicketBoxService().postTicketNewCheckIn(showingId,getHeaders(context),ticketCheckList,getTicketId(),timeZone);
        postTicketCheckIn.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {

                    try {
                        String result = response.body().string();
                        Log.e("result", result);
                        Type type = new TypeToken<ResultResponse<ResponseOrderShowInData>>() {
                        }.getType();
                        ResultResponse<ResponseOrderShowInData> resultResponse = GeneralMethods.getGson().fromJson(result, type);
                        if (resultResponse != null) {
                            if (resultResponse.isSuccess()) {
                                callBackData.onResponseData(resultResponse);
                            } else {
                                callBackData.onFailed(resultResponse.getMessage());
                            }
                        } else {
                            callBackData.onFailed(context.getString(R.string.msg_network_error));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (t instanceof UnknownHostException) {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                } else {
                    callBackData.onFailed(context.getString(R.string.msg_network_error));
                }
            }
        });
    }
}
