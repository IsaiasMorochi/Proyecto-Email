/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;

import Dato.DCliente;
import Dato.DFotografo;
import Dato.DPersonal;
import Dato.DUsuario;
import Dato.DZona;
import Negocio.NEvento;
import Negocio.NPedido;
import Negocio.NProforma;
import Negocio.NPromocion;
import Negocio.NServicio;
import Negocio.NUsuario;
import Negocio.NZona;


/**
 *
 * @author Saulo
 */
public class main {

    public static void main(String[] args) {

        
        //NEvento e = new NEvento();
        //System.out.println(e.mostrarListaEvento());
        
//        NServicio s = new NServicio();
//        System.out.println(s.mostrarLista());
        System.out.println("hello");
       //// "SANDOVAL KK"
        
        
        /*
        NZona n = new NZona();
        NUsuario usuario=new NUsuario();
        System.out.println(usuario.registrarFotografo("Danilo Joel Chacon", "9222911", 35660222, "saulopablojpl88@hotmail.com", "12345", 'M', 1, "Barrio San Julian2"));
        */
//        ClienteSMTP cliente = new ClienteSMTP();
//        
//        String destinatario = "davidjhonsg@gmail.com";
//        String asunto = "Prueba";
//        String imagen = "https://www.chiquipedia.com/imagenes/imagenes-flores19.jpg";
//        String cuerpo = "<img src=\"" + imagen + "\">";
//        String contenido = "Imagen de prueba";
//        
        //   cliente.sendMailHTML(destinatario, cuerpo, asunto);
        //cliente.enviarConGMail(destinatario, asunto, cuerpo+cuerpo+cuerpo+cuerpo+cuerpo);
        //cliente.sendMailWithFile(destinatario, "https://www.chiquipedia.com/imagenes/imagenes-flores19.jpg", contenido, asunto);
        //cliente.sendMail(destinatario, asunto, cuerpo);
        //software s =  new software();
        //s.processMessage(contenido, destinatario, cuerpo, cuerpo);
        /*String esta=new String();
        try {
                    System.out.println(esta.isEmpty());
        } catch (Exception e) {
            System.out.println("ok");
        }


        String resultados="Codigo: "+"22"+"     Carnet Identidad: "+"98299883"+"\n"+
                    "  Sexo: "+"M"+"      Telefono: "+"763131080"+"\n"
                    ;
        System.out.println(resultados);
        System.out.println("codigo: 1"+"         fecha: 2018-03-03\n"
                +"Cantidad         Subtotal         Evento\n"
                +"01               022             las carta es de una carta OK"
        );
        List<DZona> listaZona=new ArrayList<>();
        DZona zona=new DZona();
        zona.setId(1);zona.setNombre("zona zur");zona.setEstado(true);
        try {
            listaZona.add(zona);
        listaZona.add(zona);
        String resultado="Zonas\n\n";
        for (DZona zonaX : listaZona) {
            resultado = resultado +
                    "Codigo: "+zonaX.getId()+
                    "\nNombre: "+zonaX.getNombre()
                    ;
            if (zonaX.getEstado()) {
                resultado = resultado + 
                        "\nEstado: Habilitada"+
                         "\n------------------------------------------------------\n";
            }else{
                resultado = resultado + 
                        "\nEstado: No Habilitada"+
                        "\n------------------------------------------------------\n";
            }
        }
        System.out.println(resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         */
        //   NZona z = new NZona();
        //  z.registrar("nueva zona");
        // z.setEstado(true);
        // z.setNombre("zona la ramada");
        // Sy1stem.out.println(z.Mos);
        /*
        DUsuario u = new DUsuario();
        u.setId(1);
        u.setCi("12954948");
        u.setCorreo("correo23@gmail.com");
      u.setEstado(true);
      u.setNombre("david sandoval");
      u.setPassword("123456");
      u.setSexo('M');
      u.setTelefono(78403015);
      u.setTipo(1);
      u.insertar();
      DCliente cl = new DCliente();
        
        cl.setIdUsuario(u.autoincrement);
        cl.actualizar();
         */
 /*   
        DUsuario u = new DUsuario();
        u.setId(1);
        u.setCi("65816544");
        u.setCorreo("correo1@gmail.com");
        u.setEstado(true);
        u.setNombre("David Sandoval");
        u.setPassword("123456");
        u.setSexo('F');
        u.setTelefono(78465115);
        u.setTipo(1);
        u.insertar();
        System.out.println(u.autoincrement);
        DPersonal ps = new DPersonal();
        ps.setIdUsuario(u.autoincrement);
        // ps.setFechaIngreso("2018-10-06");
        ps.actualizar();
/*
       NServicio s = new NServicio();
s.registrar("servicio 2", "descripcion del servicio 2", 455, 132);
         */
 /*DUsuario u = new DUsuario();
        u.setCi("54546564");
        u.setCorreo("correo3@gmail.com");
      u.setEstado(true);
      u.setNombre("PUMA");
      u.setPassword("1234562");
      u.setSexo('M');
      u.setTelefono(784651125);
      u.setTipo(2);
      u.insertar();
        DFotografo ft = new DFotografo();
       ft.setIdUsuario(u.autoincrement);
       ft.setDireccion("en mi casa");
       ft.setIdServicio(1);
      //ft.setFechaIngreso(fechaIngreso);
        ft.insertar();
         */
        //   NUsuario n = new NUsuario();
        //    n.registrarPersonal("Daviña Sandoval", "12954949", 78403015, "@gmail.com", "457876565", 'M');
        //  System.out.println(n.mostrarLista());
        //   NPromocion p = new NPromocion();
        ///   p.agregarServicio(1, 3);
        //    System.out.println(p.mostrarListaPromociones());
        //  NProforma pr =new  NProforma();
        //pr.registrarProforma(10);
        //    pr.borrarProforma(1);
//  p.borrarPromocion(1);
        // System.out.println(pr.mostrarListaProforma());
        // System.out.println(pr.registrarDetalleProforma(100, 3, 3));
        //    NPedido p = new NPedido();
        //  p.registrarPedido("CALLE 27 DE MAYO", 4, 10, 3);
        //   System.out.println(p.mostrarPedidos());
        //NEvento e = new NEvento();
        //   p.registrarDetalle(50, 1, 2);
        //  p.borrarDetalle(2, 1);
        //  System.out.println(p.tablaDetalles(2));
        //NPedido p = new NPedido();
        //  p.registrarPedido("CALLE 27 DE MAYO", 4, 10, 3);
        //   System.out.println(p.mostrarPedidos());
        //NEvento e = new NEvento();
        // p.registrarDetalle(50, 1, 2);
        //  p.borrarDetalle(2, 1);
        //System.out.println(p.tablaDetalles(2));
        // e.registrarEvento("evento de locas", "123456", "2018-06-12 12:15", 4, 10);
//        Persona persona=new Persona(0, "", "pablo.jpl93@gmail.com", "", 0, 0, 0);
//        if(persona.busca1rPorCorreo()){
//            System.out.println("todo ok");
//        }
        //System.out.println(Ayuda.HELP_GLOBAL);
        //software sof=new software();
        //System.out.println(Ayuda.HELP_GLOBAL);
        //prueba cliente
    }
}
