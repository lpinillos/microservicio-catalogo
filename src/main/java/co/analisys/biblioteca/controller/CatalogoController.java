package co.analisys.biblioteca.controller;

import co.analisys.biblioteca.model.Libro;
import co.analisys.biblioteca.model.LibroId;
import co.analisys.biblioteca.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class CatalogoController {
    private final CatalogoService catalogoService;

    @Autowired
    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @GetMapping("/{id}")
    public Libro obtenerLibro(@PathVariable String id) {
        return catalogoService.obtenerLibro(new LibroId(id));
    }

    @PutMapping("/{id}/disponibilidad")
    public void actualizarDisponibilidad(@PathVariable String id, @RequestParam boolean disponible) {
        catalogoService.actualizarDisponibilidad(new LibroId(id), disponible);
    }

    @GetMapping("/buscar")
    public List<Libro> buscarLibros(@RequestParam String criterio) {
        return catalogoService.buscarLibros(criterio);
    }
}
