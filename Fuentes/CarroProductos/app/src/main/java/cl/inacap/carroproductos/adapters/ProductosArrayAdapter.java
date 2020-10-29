package cl.inacap.carroproductos.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.inacap.carroproductos.R;
import cl.inacap.carroproductos.dto.Producto;

public class ProductosArrayAdapter extends ArrayAdapter<Producto> {
    private Activity activity;
    private List<Producto> productos;
    public ProductosArrayAdapter(@NonNull Activity context, int resource, @NonNull List<Producto> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.productos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = this.activity.getLayoutInflater();
        View fila = inflater.inflate(R.layout.productos_list,null,true);
        TextView nombreTv = fila.findViewById(R.id.nombre_prod_lv);
        ImageView imageProd = fila.findViewById(R.id.imagen_prod_lv);

        Producto actual = productos.get(position);
        nombreTv.setText(actual.getNombre());
        Picasso.get().load(actual.getFoto())
                .resize(300,300)
                .centerCrop()
                .into(imageProd);
        return fila;
    }
}
