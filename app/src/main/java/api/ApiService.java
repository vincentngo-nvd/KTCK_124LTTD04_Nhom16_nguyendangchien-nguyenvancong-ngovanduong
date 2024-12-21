package api;

import java.util.ArrayList;

import model.Response;
import model.ThongtincanhanModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String url = "http://192.168.101.13:3009/";

    @GET("khachhang")
    Call<Response<ArrayList<ThongtincanhanModel>>> getThongtincanhan();
}
