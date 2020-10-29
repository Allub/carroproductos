package cl.inacap.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cl.inacap.carroproductos.dto.Producto;

public class VerProductoActivity extends AppCompatActivity {

    private TextView nombreTxt;
    private TextView descTxt;
    private ImageView imagenProd;
    private TextView precioTxt;
    private Toolbar toolbar;
    private TextView tituloToolbar;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto);
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.nombreTxt = findViewById(R.id.nombreProdTxt);
        this.imagenProd = findViewById(R.id.image_prod_view);
        this.descTxt = findViewById(R.id.desc_prod_view);
        this.precioTxt = findViewById(R.id.precio_prod_view);
        this.tituloToolbar = findViewById(R.id.titulo_toolbar);
        if(getIntent() != null){
            //Me enviaron cosas y que vengo desde otro activity
            Producto producto = (Producto) getIntent().getSerializableExtra("producto");
            this.nombreTxt.setText(producto.getNombre());
            this.tituloToolbar.setText(producto.getNombre());
            Picasso.get().load(producto.getFoto())
                    .resize(500,500)
                    .centerCrop()
                    .into(this.imagenProd);
            this.descTxt.setText(producto.getDescripcion());
            this.precioTxt.setText("$ "+producto.getPrecio());
        }
    }
}