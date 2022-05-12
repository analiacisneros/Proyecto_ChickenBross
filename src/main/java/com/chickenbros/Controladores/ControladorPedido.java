
package com.chickenbros.Controladores;

import com.chickenbros.Servicios.ServicioPedido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pedido")
public class ControladorPedido {
    
    
    @Autowired
    private ServicioPedido servPedido;

    @GetMapping("/agregar")
    public String agregarpedido(ModelMap modelo)
    {
        List<String> listaHoras = servPedido.listarHoras(); //Me trae una lista con horarios de 30 min extra 
        
        modelo.put("listaHora", listaHoras);
        
        return "pedido";
    }
    
    @PostMapping("/agregar")
    public String guardar( ModelMap modelo, @RequestParam String id_cliente, 
                @RequestParam Double monto_total, @RequestParam String hora_entrega, 
                @RequestParam String lugar )
    {
		
		try {
                       servPedido.agregarPedido(id_cliente, monto_total, hora_entrega, lugar);
                       List<String> listaHoras = servPedido.listarHoras(); //Me trae una lista con horarios de 30 min extra 
        
                       modelo.put("listaHora", listaHoras);
                       
                      //modelo.put("hora", hora_entrega); Para mostrar en la vista
                       return "pedido";

		} catch (Exception e) {
			modelo.put("error", e.getMessage());
			return "pedido";
		}
	}
}
