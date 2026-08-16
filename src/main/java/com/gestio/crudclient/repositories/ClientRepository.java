package com.gestio.crudclient.repositories;

import com.gestio.crudclient.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
