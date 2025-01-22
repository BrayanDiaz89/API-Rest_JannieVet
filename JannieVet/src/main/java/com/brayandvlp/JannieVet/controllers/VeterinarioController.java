package com.brayandvlp.JannieVet.controllers;

import com.brayandvlp.JannieVet.domain.direccion.DatosDireccion;
import com.brayandvlp.JannieVet.domain.veterinario.DatosRegistrarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.DatosRespuestaVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.Veterinario;
import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("veterinarios")
//@SecurityRequirement(name = "bearer-key") //Anotacion swagger para bearer key, (visualizar en doc los datos)
public class VeterinarioController {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaVeterinario> registrarVeterinario(@RequestBody @Valid DatosRegistrarVeterinario datosRegistrarVeterinario,
                                                                          UriComponentsBuilder uriComponentsBuilder){
        Veterinario veterinario = veterinarioRepository.save(new Veterinario(datosRegistrarVeterinario));

        DatosRespuestaVeterinario datosRespuestaVeterinario = new DatosRespuestaVeterinario(veterinario.getId(), veterinario.getDocumento(), veterinario.getNombreCompleto(),
                veterinario.getNumeroTelefonico(), veterinario.getEmail(), veterinario.getEspecialidad(), veterinario.getFecha(), veterinario.getActivo(),
                new DatosDireccion(veterinario.getDireccion().getCiudad(), veterinario.getDireccion().getCodigoPostal(), veterinario.getDireccion().getCalle(),
                        veterinario.getDireccion().getNumero(), veterinario.getDireccion().getComplemento()));
        URI url = uriComponentsBuilder.path("/veterinarios/{id}").buildAndExpand(veterinario.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaVeterinario);
    }

}
