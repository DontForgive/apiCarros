package br.com.arrudadeveloper.services;

import java.util.List;
import br.com.arrudadeveloper.dtos.CarrosDTOS;

public interface CarrosService {
	
	List<CarrosDTOS> listarTodos();
	
	CarrosDTOS cadastrar(CarrosDTOS carros);
	
	CarrosDTOS listarPorId(Long id);	
	
	CarrosDTOS atualizar(CarrosDTOS carros);
	
	void remover(Long id);

}
