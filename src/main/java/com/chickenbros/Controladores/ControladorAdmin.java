
package com.chickenbros.Controladores;

import com.chickenbros.Entidades.Pedido;
import com.chickenbros.Servicios.ServicioAdmin;
import com.chickenbros.Servicios.ServicioPedido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class ControladorAdmin {
    
    
	@Autowired
	private ServicioAdmin adminServ;
	@Autowired 
        private ServicioPedido servPedido;
        
	 @GetMapping("/listarPedido") //En el lado del Admin
        public String agregarpedido(ModelMap modelo)
        {
        List<Pedido> listaPedidos = servPedido.listarPedido(); 
        
        modelo.put("listaPedidos", listaPedidos);
        
        return "adminIndex";
         }
	
	@GetMapping("/registro")
	public String formulario(ModelMap modelo, @RequestParam String nombre,@RequestParam String email, @RequestParam String clave ) throws Exception {
            adminServ.guardar(nombre, email, clave); 
         return "form_admin";
	}
}
