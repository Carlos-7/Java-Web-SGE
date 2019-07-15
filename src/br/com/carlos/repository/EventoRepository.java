package br.com.carlos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.carlos.entity.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long>{

}
