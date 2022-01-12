package com.taylan.endereco.controller;

import com.taylan.endereco.model.dto.EnderecoDto;
import com.taylan.endereco.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(path = "/adicionar", consumes ="application/json")
    public void adicionar(@RequestBody EnderecoDto enderecoDto){
        enderecoService.adicionarEndereco(enderecoDto);
    }

    @PutMapping(path = "/editar/{idEndereco}", consumes ="application/json")
    public void editar(@PathVariable("idEndereco") Integer idEndereco, @RequestBody EnderecoDto enderecoDto){
        enderecoService.editarEndereco(enderecoDto, idEndereco);
    }

    @DeleteMapping(path = "/remover/{idEndereco}")
    public void remover(@PathVariable("idEndereco") Integer idEndereco){
        enderecoService.removerEndereco(idEndereco);
    }

    @GetMapping(path = "/consultar/{idEndereco}")
    public EnderecoDto consultar(@PathVariable("idEndereco") Integer idEndereco){
        return enderecoService.consultarEndereco(idEndereco);
    }

}
