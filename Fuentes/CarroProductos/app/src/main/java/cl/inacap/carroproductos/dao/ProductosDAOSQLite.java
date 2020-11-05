package cl.inacap.carroproductos.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.carroproductos.dto.Producto;
import cl.inacap.carroproductos.helpers.ProductosSQLiteHelper;

public class ProductosDAOSQLite implements ProductosDAO {

    private ProductosSQLiteHelper prodHelper;

    public ProductosDAOSQLite(Context context){
        this.prodHelper = new ProductosSQLiteHelper(context,"DBProductos"
        , null,4);
    }
    @Override
    public List<Producto> getAll() {
        SQLiteDatabase reader = this.prodHelper.getReadableDatabase();
        List<Producto> productos = new ArrayList<>();
        try {
            if(reader != null){
                Cursor c = reader.rawQuery("SELECT id,nombre,precio,descripcion,foto FROM productos",null);
                if(c.moveToFirst()){
                    do{
                        Producto p = new Producto();
                        p.setId(c.getInt(0));
                        p.setNombre(c.getString(1));
                        p.setPrecio(c.getInt(2));
                        p.setDescripcion(c.getString(3));
                        p.setFoto(c.getString(4));
                        productos.add(p);
                    }while(c.moveToNext());
                }
                reader.close();
            }
        }catch (Exception ex){
            Log.e("PRODUCTOSDAO",ex.toString());
            productos = null;
        }

        return productos;
    }

    @Override
    public Producto save(Producto p) {
        SQLiteDatabase writer = this.prodHelper.getWritableDatabase();
        String sql = String.format("INSERT INTO productos(nombre,precio,descripcion,foto)" +
                " VALUES ('%s',%d,'%s','%s')",p.getNombre(),p.getPrecio(),p.getDescripcion(),p.getFoto());
        writer.execSQL(sql);
        writer.close();
        return p;
    }
}
