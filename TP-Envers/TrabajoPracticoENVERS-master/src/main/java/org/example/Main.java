package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");

        EntityManager em = emf.createEntityManager();


        try {
            em.getTransaction().begin();

            /*Factura factura1 = new Factura();

            factura1.setNumero(12);
            factura1.setFecha("10/08/2020");

            Domicilio dom1 = Domicilio.builder()
                    .nombreCalle("Godoy Cruz")
                    .numero(9895)
                    .build();

            Cliente cliente1 = Cliente.builder()
                    .nombre("Juliana")
                    .apellido("Perez")
                    .dni(45144862)
                    .build();

            cliente1.setDomicilio(dom1);
            dom1.setCliente(cliente1);

            //creacion de las categorias
            Categoria perecederos = Categoria.builder()
                    .denominacion("perecederos")
                    .build();

            Categoria lacteos = Categoria.builder()
                    .denominacion("lacteos")
                    .build();

            Categoria limpieza = Categoria.builder()
                    .denominacion("limpieza")
                    .build();

            //creacion de los articulos
            Articulo art1 = Articulo.builder()
                    .cantidad(200)
                    .denominacion("Yogurt Frutilla")
                    .precio(20)
                    .build();

            Articulo art2 = Articulo.builder()
                    .cantidad(300)
                    .denominacion("Detergente")
                    .precio(80)
                    .build();

            //asigno categorias a los articulos y los articulos a la categoria
            art1.getCategorias().add(perecederos);
            art1.getCategorias().add(lacteos);
            lacteos.getArticulos().add(art1);
            perecederos.getArticulos().add(art1);

            art2.getCategorias().add(limpieza);
            limpieza.getArticulos().add(art2);

            //creo detalles de facturas
            DetalleFactura det1 = DetalleFactura.builder()
                    .build();

            det1.setArticulo(art1);
            det1.setCantidad(2);
            det1.setSubtotal(40);

            //bidireccionales
            art1.getDetalle().add(det1);
            factura1.getDetalles().add(det1);
            det1.setFactura(factura1);

            //creo otro detalle
            DetalleFactura det2 = DetalleFactura.builder()
                    .build();

            det2.setArticulo(art2);
            det2.setCantidad(1);
            det2.setSubtotal(80);

            art2.getDetalle().add(det2);
            factura1.getDetalles().add(det2);
            det2.setFactura(factura1);

            //seteo el total de la factura
            factura1.setTotal(120);*/

            Factura factura1 = em.find(Factura.class, 1L);
            //factura1.setNumero(85);


            em.remove(factura1);

            em.flush(); //para limpiar la conexion

            em.getTransaction().commit();


        }catch (Exception e){

            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase");}

        // Cerrar el EntityManager y el EntityManagerFactory
      em.close();
        emf.close();
    }
}
