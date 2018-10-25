package Bussines;

import java.util.Date;
import Data.DReserva;
import nucleo.utilidades.Utils;

public class NReserva {
	
	private DReserva reserva;
	
	 public NReserva() {
		 this.reserva = DReserva.getInstance();
	 }
	 
	 public DReserva getReserva() {
		return reserva;
	}

	public boolean registrar(String fecha, int id_persona, int id_evento){
		 reserva.setFecha(fecha);
		 reserva.setId_persona(id_persona);
		 reserva.setId_evento(id_evento);
		 reserva.setCreated_at(Utils.dateToString(new Date()));
		 
		 return reserva.insertar();
	 }

}
