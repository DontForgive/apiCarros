package br.com.arrudadeveloper.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arrudadeveloper.dtos.CarrosDTOS;
import br.com.arrudadeveloper.repository.CarrosRepository;
import br.com.arrudadeveloper.services.CarrosService;

@Service
public class CarrosServiceImpl implements CarrosService{
	
	@Autowired
	private CarrosRepository carrosRepository;

	@Override
	public List<CarrosDTOS> listarTodos(){
		return carrosRepository.findAll();
	}

	@Override
	public CarrosDTOS cadastrar(CarrosDTOS carros) {
		return carrosRepository.save(carros);
	}

	@Override
	public CarrosDTOS listarPorId(Long id) {		
		return carrosRepository.getById(id);
	}

	@Override
	public CarrosDTOS atualizar(CarrosDTOS carros) {
		return carrosRepository.save(carros);
	}

	@Override
	public void remover(Long id) {
		carrosRepository.deleteById(id);		
	}

}
