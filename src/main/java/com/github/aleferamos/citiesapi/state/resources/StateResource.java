package com.github.aleferamos.citiesapi.state.resources;

import com.github.aleferamos.citiesapi.countries.entities.Country;
import com.github.aleferamos.citiesapi.state.entities.State;
import com.github.aleferamos.citiesapi.state.repositories.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResource {

    private StateRepository repository;

    public StateResource(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<State> cities() {
        return repository.findAll();
    }
}
