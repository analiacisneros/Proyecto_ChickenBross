
package com.chickenbros.Controladores;

import com.chickenbros.Servicios.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class ControladorCliente {
    
    
	@Autowired
	private ServicioCliente servCliente;
	
	@GetMapping("/lista")
	public String lista(ModelMap modelo) {
		
		//List<Cliente> todos = clienteServ.listarTodos();
		
		//modelo.addAttribute("clientes", todos);
		
		return "lista_cliente";
	}
	
	@GetMapping("/registro")
	public String formulario() throws Exception {
            //clienteServ.guardarCliente(); *Esto solo realiza una prueba sin post
		return "form_cliente";
	}
	
	@PostMapping("/registro")
	public String guardar(ModelMap modelo, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String email, @RequestParam String clave, @RequestParam String direccion, @RequestParam String telefono, @RequestParam String claveRep) {
		
		try {
                    Long telefonoL = Long.parseLong(telefono);
                       servCliente.guardarCliente(nombre,apellido, email, clave,  direccion, telefonoL,claveRep);
                      modelo.put("exito", "Guardado con exito");
                       return "form_cliente";

		} catch (Exception e) {
			modelo.put("error", e.getMessage());
			return "form_cliente";
		}
	}
}
