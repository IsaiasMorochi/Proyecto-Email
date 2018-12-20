package Email;

import Negocio.NReporte;

import java.util.List;

public class MailReporte {

    
    private NReporte obj;
    
    public MailReporte() throws Exception{  
        this.obj = new NReporte();
    }

  

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

    private String generarTabla(List<String> nombres, List<String> programa, List<Integer> cantidades, String titulo){

        String tabla = "<h2> "+ titulo + "</h2><br><table style=\"display:inline-block; position: relative; width: 30%; margin:20px; border-collapse: collapse;\">\n" +
                "\n" +
                "  <tr>\n" +
                "    <th style=\"border: 2px solid #dddddd; text-align: center; padding: 8px;\">Participante</th>\n" +
                "    <th style=\"border: 2px solid #dddddd; text-align: center; padding: 8px;\">Programa</th>\n" +
                "    <th style=\"border: 2px solid #dddddd; text-align: center; padding: 8px;\">Nro de Asistencia a Talleres</th>\n" +
                "  </tr>\n" +
                " <tr>\n";
        for(int i=0; i<nombres.size(); i++){

            tabla += "  <tr>\n" +
                    "    <td style=\"border: 2px solid #dddddd; text-align: center; padding: 8px;\">"+ nombres.get(i) +"</td>\n" +
                    "    <td style=\"border: 2px solid #dddddd; text-align: center; padding: 8px;\">"+ programa.get(i) +"</td>\n" +
                    "    <td style=\"border: 2px solid #dddddd; text-align: center; padding: 8px;\">"+ cantidades.get(i) +"</td>\n" +
                    "  </tr>\n";
        }
        tabla += "</table><br>";

        String columnas = "";
        String valores  = "";
        for(int i=0; i < nombres.size(); i++){
            if (i+1 >= nombres.size()){
                columnas += nombres.get(i);
                valores += cantidades.get(i);
            }else{
                columnas += nombres.get(i) + "|";
                valores += cantidades.get(i) + ",";
            }
        }
        System.out.println(columnas);
        System.out.println(valores);

        tabla +=    "<img src=\" http://chart.apis.google.com/chart?chs=800x300&cht=p3&chd=t:"+ valores+"&chl="+columnas+"\" alt=\"Participacion\" height=\"300\" width=\"800\">";
        return tabla;
    }

}
