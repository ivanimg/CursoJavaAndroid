package es.miempresa.carrito.rest;

import java.util.List;

import es.miempresa.carrito.models.Categoria;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestService {
    String API_ROUTE = "/categoria";

    @GET(API_ROUTE)
    Call<List<Categoria>> getAllCategories();

    @POST(API_ROUTE)
    Call<Void> createCategories(@Body Categoria cat);
}
