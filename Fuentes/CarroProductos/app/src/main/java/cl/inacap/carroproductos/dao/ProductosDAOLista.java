package cl.inacap.carroproductos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.carroproductos.dto.Producto;

public class ProductosDAOLista implements ProductosDAO{

    private List<Producto> productos = new ArrayList<>();
    private static ProductosDAOLista instancia;
    private ProductosDAOLista(){
        Producto p = new Producto();
        p.setNombre("Coca cola Zero");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sit amet pulvinar ex, eu tincidunt odio. Sed eu mauris non dolor consequat blandit.");
        p.setPrecio(1000);
        p.setFoto("https://jumbo.vteximg.com.br/arquivos/ids/336745/Principal-3942.jpg?v=637237316746070000");
        productos.add(p);

        p = new Producto();
        p.setNombre("Centella");
        p.setDescripcion("Lorem ipsum is sit amet pulvinar ex, eu tincidunt odio. Sed eu mauris non dolor consequat blandit.");
        p.setPrecio(100);
        p.setFoto("https://www.casagamovi.cl/wp-content/uploads/2020/08/helado-centella-manzana.png");
        productos.add(p);

        p = new Producto();
        p.setNombre("Chocolate");
        p.setDescripcion("odio. Sed eu mauris non dolor consequat blandit.");
        p.setPrecio(5000);
        p.setFoto("https://jumbo.vteximg.com.br/arquivos/ids/324250/Principal-7136.jpg?v=637153902477430000");
        productos.add(p);

    }
    public static ProductosDAOLista getInstance(){
        if(instancia == null){
            instancia = new ProductosDAOLista();
        }
        return instancia;
    }

    @Override
    public List<Producto> getAll() {
        return productos;
    }

    @Override
    public Producto save(Producto p) {
        productos.add(p);
        return p;
    }
}
