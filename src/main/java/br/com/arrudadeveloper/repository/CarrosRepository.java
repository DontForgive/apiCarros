package br.com.arrudadeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arrudadeveloper.dtos.CarrosDTOS;

public interface CarrosRepository extends JpaRepository<CarrosDTOS, Long>{
}
