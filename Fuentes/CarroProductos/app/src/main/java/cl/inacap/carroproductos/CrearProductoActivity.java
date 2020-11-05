package cl.inacap.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cl.inacap.carroproductos.dao.ProductosDAO;
import cl.inacap.carroproductos.dao.ProductosDAOSQLite;
import cl.inacap.carroproductos.dto.Producto;

public class CrearProductoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText nombreTxt;
    private EditText precioTxt;
    private EditText fotoTxt;
    private EditText descTxt;
    private Button crearBtn;
    private ProductosDAO prodDAO = new ProductosDAOSQLite(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.nombreTxt = findViewById(R.id.nombre_prod_txt_cr);
        this.precioTxt = findViewById(R.id.precio_prod_txt_cr);
        this.fotoTxt = findViewById(R.id.foto_txt_cr);
        this.descTxt = findViewById(R.id.desc_prod_txt_cr);
        this.crearBtn = findViewById(R.id.crear_btn);
        this.crearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.Crear producto
                Producto p = new Producto();
                p.setNombre(nombreTxt.getText().toString());
                p.setDescripcion(descTxt.getText().toString());
                p.setFoto(fotoTxt.getText().toString());
                p.setPrecio(Integer.parseInt(precioTxt.getText().toString()));
                //2. Llamar al DAO y agregarlo
                prodDAO.save(p);
                //3. Redirigir al Main activity
                startActivity(new Intent(CrearProductoActivity.this,MainActivity.class));
            }
        });
}
}
