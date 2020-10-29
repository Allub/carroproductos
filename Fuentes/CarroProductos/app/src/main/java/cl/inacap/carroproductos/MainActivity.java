package cl.inacap.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import cl.inacap.carroproductos.adapters.ProductosArrayAdapter;
import cl.inacap.carroproductos.dao.ProductosDAO;
import cl.inacap.carroproductos.dao.ProductosDAOLista;
import cl.inacap.carroproductos.dto.Producto;

public class MainActivity extends AppCompatActivity {

    private ListView productosLv;
    private List<Producto> productos;
    private ProductosArrayAdapter adaptador;
    private ProductosDAO productosDAO = ProductosDAOLista.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        productos = productosDAO.getAll();
        adaptador = new ProductosArrayAdapter(this,R.layout.productos_list,productos);
        productosLv = findViewById(R.id.productos_lv);
        productosLv.setAdapter(adaptador);
        productosLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, VerProductoActivity.class);
                //1. Cual fue la fila que clickearon?
                Producto prodActual = productos.get(i);
                //2. Como le paso el producto seleccionado al otro activity?
                intent.putExtra("producto", prodActual);
                startActivity(intent);

            }
        });

    }
}