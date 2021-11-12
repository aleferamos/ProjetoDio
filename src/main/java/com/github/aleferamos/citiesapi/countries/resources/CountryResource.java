package com.github.aleferamos.citiesapi.countries.resources;

import com.github.aleferamos.citiesapi.countries.entities.Country;
import com.github.aleferamos.citiesapi.countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@RestController
@RequestMapping(value = "/countries")
public class CountryResource {

    private CountryRepository repository;


    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public Page<Country> cities(@PageableDefault (sort = "name") Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);

        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
