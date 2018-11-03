package Software.Template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bussines.NReporte;
import nucleo.procesador.Anacom;



public class MailReportes extends TemplateMail {
	
	private NReporte obj = new NReporte();

	public static String GraficoEstadistico(List<String>etiquetas, List<Float> valores, String titulo, boolean b) {
        if(b){
            float total = (float) 0;
            for(int i=0; i<valores.size(); i++){
                total += valores.get(i);
            }
            for(int i=0; i<valores.size(); i++){
                valores.set(i, (valores.get(i)/total)*100);
            }
        }
        
        String s = "";
        String chdl = "";
        String chd = "";
        for (int i = 0; i < etiquetas.size(); i++) {
            chdl = chdl + etiquetas.get(i) + "%7C";
        }
        chdl = chdl.substring(0, chdl.length() - 3);
        for (int i = 0; i < valores.size(); i++) {
            chd = chd + valores.get(i) + "%2C";
        }
        chd = chd.substring(0, chd.length() - 3);

        String chl = "";
        if (b) {
            for (int i = 0; i < valores.size(); i++) {

                chl = chl + valores.get(i) + "%25%7C";
            }

        } else {
            for (int i = 0; i < valores.size(); i++) {

                chl = chl + valores.get(i) + "%7C";
            }
        }
        chl = chl.substring(0, chl.length() - 3);
        s = "https://image-charts.com/chart?cht=p&chd=t%3A" + chd + "&chof=.png&chs=500x400&chdl=" + chdl + "&chdls=000000&chtt=" + titulo + "&chl=" + chl + "&chdlp=b&chbh=10&icwt=false";
        s = "<img src=\"" + s + "\">";
        return s;
    }
    
    private String generarTabla(List<String> nombres, List<Integer> cantidades, String titulo){
        String tabla = "<table style=\"display:inline-block; position: relative; width: 20%; margin:20px; border-collapse: collapse;\">\n" +
                    "\n" +
                    "  <tr>\n" +
                    "    <th style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">Entidad</th>\n" +
                    "    <th style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">Cantidad</th>\n" +
                    "  </tr>\n" +
                    " <tr>\n";
        for(int i=0; i<nombres.size(); i++){
            tabla += "  <tr>\n" +
                     "    <td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">"+ nombres.get(i) +"</td>\n" +
                     "    <td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">"+ cantidades.get(i) +"</td>\n" +
                     "  </tr>\n";
        }
        tabla += "</table><br>";
        return tabla;
    }
   
    
/*   private void mostrarEstadistica(Anacom anacom, String correoDest) {
        // Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();
        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Foto Studio OnLine", Ayuda.HELP_MOSTRARESTADISTICA);
            System.out.println(Ayuda.HELP_MOSTRARESTADISTICA);
            return;
        }

        NEstadistica estadistica = new NEstadistica();
        List<ResultSet> listaEstadisticas = estadistica.mostrarEstadistica();
        String[] titulos = {"Porcentaje de ganancias por servicio", 
            "Porcentaje de ganancias por cliente",
            "Porcentaje de participacion de servicios en proformas",
            "Porcentaje de ganancias en pedidos por zona"};
        String cuerpo = "";
        for (int i = 0; i < listaEstadisticas.size(); i++) {
            ResultSet data = listaEstadisticas.get(i);
            System.out.println("Esta trabajando con el reporte "+i);
            try {
                List<String> nombres = new ArrayList<>();
                List<Float> totales = new ArrayList<>();
                if(data.next()){
                    do {
                        nombres.add(data.getString("nombre"));
                        totales.add(data.getFloat("Total"));
                    } while (data.next());
                    cuerpo += this.GraficoEstadistico(nombres, totales, titulos[i], true)+"\n\n";
                }
            } catch (SQLException ex) {
                System.out.println("Ocurrio un error al manejar los datos de la estadistica "+i);
                System.out.println(ex);
            }
        }
        System.out.println("Se acaban de mandar los graficos estadisticos al correo "+correoDest);
        ClienteSMTP.sendMailHTML(correoDest, cuerpo, "Mostrar estadistica");

    }*/
    
    private void mostrarReporte(Anacom anacom, String correoDest){
      
        
//        NReporte estadistica = new NReporte();
//        List<ResultSet> listaReportes = estadistica.mostrarReporte();
//        String[] titulos = {"Participacion de los servicios en pedidos, eventos y proformas",
//            "Participacion de clientes en la realizacion de pedidos, eventos y proformas",
//            "Participacion de los servicios en las proformas",
//            "Participacion de las zonas en la realizacion de pedidos y eventos"};
//        String cuerpo = "";
//        for (int i = 0; i < listaReportes.size(); i++) {
//            ResultSet data = listaReportes.get(i);
//            try {
//                List<String> nombres = new ArrayList<>();
//                List<Integer> cantidades = new ArrayList<>();
//                if(data.next()){
//                    do {
//                        nombres.add(data.getString("nombre"));
//                        cantidades.add(data.getInt("cantidad"));
//                    } while(data.next());
//                    cuerpo += this.generarTabla(nombres, cantidades, titulos[i])+"\n\n";
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex);
//            }
//        }
        
//        System.out.println("Se acaban de mandar los reportes al correo "+correoDest);
//        ClienteSMTP.sendMailHTML(correoDest, cuerpo, "Mostrar reporte");
    }
	
    
    
    
    
    
    @Override
	public boolean insertar(nucleo.procesador.Anacom anacom, String correo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(nucleo.procesador.Anacom anacom, String correo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(nucleo.procesador.Anacom anacom, String correo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String listar() {
        List<ResultSet> listaReportes = obj.mostrarReporte();
        String[] titulos = {"Participacion de los usuarios en eventos"};
//        String[] titulos = {"Participacion de los servicios en pedidos, eventos y proformas",
//            "Participacion de clientes en la realizacion de pedidos, eventos y proformas",
//            "Participacion de los servicios en las proformas",
//            "Participacion de las zonas en la realizacion de pedidos y eventos"};
        
        String cuerpo = "";
	        
        for (int i = 0; i < listaReportes.size(); i++) {
            ResultSet data = listaReportes.get(i);
            try {
                List<String> nombres = new ArrayList<>();
                List<Integer> cantidades = new ArrayList<>();
                if(data.next()){
                    do {
                        nombres.add(data.getString("nombre"));
                        cantidades.add(data.getInt("cantidad"));
                    } while(data.next());
                    cuerpo += this.generarTabla(nombres, cantidades, titulos[i])+"\n\n";
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
		return cuerpo;
	}

	@Override
	public String messageCreate(boolean sw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String messageEdit(boolean sw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String messageRemove(boolean sw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String messageFindAll(boolean sw) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
