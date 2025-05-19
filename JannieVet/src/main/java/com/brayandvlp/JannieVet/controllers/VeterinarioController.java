package com.brayandvlp.JannieVet.controllers;

import com.brayandvlp.JannieVet.domain.direccion.dtos.DatosDireccion;
import com.brayandvlp.JannieVet.domain.veterinario.*;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosActualizarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosListadoVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosRegistrarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosRespuestaVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.service.RegistroService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("veterinarios")
//@SecurityRequirement(name = "bearer-key") //Anotacion swagger para bearer key, (visualizar en doc los datos)
public class VeterinarioController {

    @Autowired
    private VeterinarioRepository veterinarioRepository;
    @Autowired
    private RegistroService registroService;

    @PostMapping
    public ResponseEntity<DatosListadoVeterinario> registrarVeterinario(@RequestBody @Valid DatosRegistrarVeterinario datosRegistro,
                                                                          UriComponentsBuilder uriComponentsBuilder){
        var detallesRegistroVeterinario = registroService.registrar(datosRegistro);
        URI url = uriComponentsBuilder.path("/veterinarios/{id}").buildAndExpand(detallesRegistroVeterinario.id()).toUri();
        return ResponseEntity.created(url).body(detallesRegistroVeterinario);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoVeterinario>> listadoVeterinarios(@PageableDefault(size =5)Pageable paginacion) {
        return ResponseEntity.ok(veterinarioRepository.findByActivoTrue(paginacion).map(DatosListadoVeterinario::new));
    }
    @GetMapping("/inactive")
    public ResponseEntity<Page<DatosListadoVeterinario>> listadoVeterinariosInactivos(@PageableDefault(size = 5)Pageable paginacion){
        return ResponseEntity.ok(veterinarioRepository.findByActivoFalse(paginacion).map(DatosListadoVeterinario::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaVeterinario> actualizarDatosVeterinario(@RequestBody @Valid DatosActualizarVeterinario datosActualizacion){
        Veterinario veterinario = veterinarioRepository.getReferenceById(datosActualizacion.id());
        veterinario.actualizarDatos(datosActualizacion);
        return ResponseEntity.ok(new DatosRespuestaVeterinario(veterinario.getId(), veterinario.getDocumento(), veterinario.getNombreCompleto(),
                veterinario.getNumeroTelefonico(), veterinario.getEmail(), veterinario.getEspecialidad(), veterinario.getFecha(), veterinario.getActivo(),
                new DatosDireccion(veterinario.getDireccion().getCiudad(), veterinario.getDireccion().getCodigoPostal(), veterinario.getDireccion().getCalle(),
                        veterinario.getDireccion().getNumero(), veterinario.getDireccion().getComplemento())));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desactivarVeterinario(@PathVariable Long id) {
        Veterinario veterinario = veterinarioRepository.getReferenceById(id);
        veterinario.desactivarVeterinario();
        return ResponseEntity.noContent().build();
    }
}
