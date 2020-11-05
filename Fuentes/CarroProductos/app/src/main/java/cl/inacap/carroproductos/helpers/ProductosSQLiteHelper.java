package cl.inacap.carroproductos.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProductosSQLiteHelper extends SQLiteOpenHelper {

    private final String sqlCreate = "CREATE TABLE productos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
            ",nombre TEXT" +
            ",descripcion TEXT" +
            ",foto TEXT" +
            ",precio INTEGER)";

    public ProductosSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
        sqLiteDatabase.execSQL("INSERT INTO productos(nombre,descripcion,precio,foto)" +
                " VALUES('Coca cola Zero','Coca Cola Pulenta',1000,'https://jumbo.vteximg.com.br/arquivos/ids/336745/Principal-3942.jpg?v=637237316746070000')");
        sqLiteDatabase.execSQL("INSERT INTO productos(nombre,descripcion,precio,foto)" +
                " VALUES('Centella','Esto fue desde la bd',400,'https://www.casagamovi.cl/wp-content/uploads/2020/08/helado-centella-manzana.png')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS productos");
            sqLiteDatabase.execSQL(sqlCreate);
        sqLiteDatabase.execSQL("INSERT INTO productos(nombre,descripcion,precio,foto)" +
                " VALUES('Coca cola Zero','Coca Cola Pulenta',1000,'https://jumbo.vteximg.com.br/arquivos/ids/336745/Principal-3942.jpg?v=637237316746070000')");
        sqLiteDatabase.execSQL("INSERT INTO productos(nombre,descripcion,precio,foto)" +
                " VALUES('Centella','Esto fue desde la bd',400,'https://www.casagamovi.cl/wp-content/uploads/2020/08/helado-centella-manzana.png')");
    }
}
