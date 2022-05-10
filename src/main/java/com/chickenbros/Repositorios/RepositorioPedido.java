
package com.chickenbros.Repositorios;

import com.chickenbros.Entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioPedido extends JpaRepository <Pedido, String>  {
    
    
}
