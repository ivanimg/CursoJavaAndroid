package es.miempresa.carrito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.SortedList;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import es.miempresa.carrito.models.Categoria;
import es.miempresa.carrito.rest.RestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoActivity extends AppCompatActivity {

    ListView lista;
    ArrayList<String> listArray = new ArrayList<>();
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lista = findViewById(R.id.listado);
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listArray);
        lista.setAdapter(adaptador);

        getCategorias();
    }

    private void getCategorias(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.80:8090").addConverterFactory(GsonConverterFactory.create()).build();

        RestService rest = retrofit.create(RestService.class);
        Call<List<Categoria>> call = rest.getAllCategories();

        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                System.out.println(response.body());

                List<Categoria> cats = response.body();

                for(Categoria c:cats){
                    listArray.add(c.getNombre());
                }
                adaptador.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void crearCategoria(){
        Retrofit retrofit = getRetrofit();

        RestService rest = retrofit.create(RestService.class);

        Call retorno = rest.createCategories(new Categoria("Nueva"));

        retorno.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                System.out.println("Respuesta: "+ response.code());
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }

    private Retrofit getRetrofit(){
        return new Retrofit().Builder
    }
}
