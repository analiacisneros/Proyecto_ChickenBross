
package com.chickenbros.Servicios;

import com.chickenbros.Entidades.Cliente;
import com.chickenbros.Entidades.Pedido;
import com.chickenbros.Repositorios.RepositorioCliente;
import com.chickenbros.Repositorios.RepositorioPedido;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPedido {
    
    @Autowired
    private RepositorioPedido repoPedido;
    @Autowired
    private RepositorioCliente repoCliente;


    public void agregarPedido(String id_cliente, Double monto_total, String hora_entrega, String lugar){

        //String id="fb27ec3a-c254-4b6a-9be1-2a9e6f31ca6b";
        Pedido pedido= new Pedido();
        
        Cliente cliente=repoCliente.buscarPorId(id_cliente);

        pedido.setCliente(cliente);
        pedido.setMonto_total(monto_total);
        pedido.setHora_entrega(new Time(14, 06,00)); //Agrega Horario

        pedido.setFecha(new GregorianCalendar());
        pedido.setLugar(true);
        pedido.setEstado(1);

        repoPedido.save(pedido);
    }
   
    public List<String> listarHoras()
    {
        List<String> listaHs= new ArrayList<>();
        
        Calendar calendario = Calendar.getInstance();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        
        listaHs.add(formatearMinutosAHoraMinuto(120));
        
        return listaHs;
    }
    
    public String formatearMinutosAHoraMinuto(int minutos) {
        String formato = "%02d:%02d";
        long horasReales = TimeUnit.MINUTES.toHours(minutos);
        long minutosReales = TimeUnit.MINUTES.toMinutes(minutos) - TimeUnit.HOURS.toMinutes(TimeUnit.MINUTES.toHours(minutos));
    return String.format(formato, horasReales, minutosReales);
}
}
