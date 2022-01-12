package com.taylan.endereco.teste;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taylan.endereco.controller.EnderecoController;
import com.taylan.endereco.model.dto.EnderecoDto;
import com.taylan.endereco.repository.EnderecoRepository;
import com.taylan.endereco.service.EnderecoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@AutoConfigureMockMvc
class EnderecoTeste {

    private EnderecoController enderecoController;

    private EnderecoRepository enderecoRepository;

    private MockMvc mockMvc;

    @Autowired
    public EnderecoTeste(EnderecoController enderecoController, MockMvc mockMvc) {
        this.enderecoController = enderecoController;
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    public void setup() {
        MockMvcBuilders.standaloneSetup(this.enderecoController);
    }

    @Test
    public void adicionar() throws Exception {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setRua("Ungava");
        enderecoDto.setNumero("735");
        enderecoDto.setComplemento("Casa");
        enderecoDto.setBairro("14 de Novembro");
        enderecoDto.setCidade("Cascavel");
        enderecoDto.setEstado("Parana");
        enderecoDto.setPais("Brasil");
        enderecoDto.setCep("85801-622");

        final String enderecoToString = new ObjectMapper().writeValueAsString(enderecoDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/endereco/adicionar")
                        .content(enderecoToString.getBytes(StandardCharsets.UTF_8))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void editar() throws Exception {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setRua("Ungava");
        enderecoDto.setNumero("735");
        enderecoDto.setComplemento("Casa");
        enderecoDto.setBairro("14 de Novembro");
        enderecoDto.setCidade("Cascavel");
        enderecoDto.setEstado("Parana");
        enderecoDto.setPais("Brasil");
        enderecoDto.setCep("85801-622");

        String enderecoToString = new ObjectMapper().writeValueAsString(enderecoDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/endereco/adicionar")
                        .content(enderecoToString.getBytes(StandardCharsets.UTF_8))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        String nomeRua = "Rua Ungava";
        enderecoDto = new EnderecoDto();
        enderecoDto.setRua(nomeRua);

        enderecoToString = new ObjectMapper().writeValueAsString(enderecoDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/endereco/editar/{idEndereco}", 1L)
                        .content(enderecoToString.getBytes(StandardCharsets.UTF_8))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void remover() throws Exception {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setRua("Ungava");
        enderecoDto.setNumero("735");
        enderecoDto.setComplemento("Casa");
        enderecoDto.setBairro("14 de Novembro");
        enderecoDto.setCidade("Cascavel");
        enderecoDto.setEstado("Parana");
        enderecoDto.setPais("Brasil");
        enderecoDto.setCep("85801-622");

        String enderecoToString = new ObjectMapper().writeValueAsString(enderecoDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/endereco/adicionar")
                        .content(enderecoToString.getBytes(StandardCharsets.UTF_8))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.delete("/endereco/remover/{idEndereco}", 1L)
                        .content(enderecoToString.getBytes(StandardCharsets.UTF_8))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void buscar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/endereco/consultar/{idEndereco}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
