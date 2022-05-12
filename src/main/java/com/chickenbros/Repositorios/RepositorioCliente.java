
package com.chickenbros.Repositorios;

import com.chickenbros.Entidades.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente extends JpaRepository <Cliente, String> {
    
    @Query("SELECT c FROM Cliente c WHERE c.id_cliente = :id")
    public Cliente buscarPorId(@Param("id") String id);
    
    @Query("SELECT c from Cliente c WHERE c.direccion = :direccion ")
	public List<Cliente> buscarDireccion(@Param("direccion")String direccion);
    
    //@Query("SELECT c from Cliente c WHERE c.email = :email ")
	//public List<Cliente> buscarDireccion(@Param("email")String direccion); Raro, es buscar direccion o email?
}
