package com.br.aquario.controller;

import com.br.aquario.model.EventModel;
import com.br.aquario.model.MetricasModel;
import com.br.aquario.repository.EventRepository;
import com.br.aquario.repository.MetricasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private MetricasRepository metricasRepository;

    // Endpoint para receber eventos
    @PostMapping("eventos")
    public ResponseEntity<String> creat(@RequestBody EventModel evento) {
        evento.setData(LocalDateTime.now()); // Adicionar data/hora atual
        eventRepository.save(evento); // Salvar no banco
        return ResponseEntity.ok("Evento registrado com sucesso!");
    }

    // Endpoint para listar eventos
    @GetMapping("eventos")
    public List<EventModel> getAllEvents() {
        return eventRepository.findAll();
    }

    // Endpoint para receber metricas
    @PostMapping("metricas")
    public ResponseEntity<String> creat(@RequestBody MetricasModel metricas) {
        metricas.setData(LocalDateTime.now()); // Adicionar data/hora atual
        metricasRepository.save(metricas); // Salvar no banco
        return ResponseEntity.ok("Métricas registradas com sucesso!");
    }

    // Endpoint para listar metricas
    @GetMapping("metricas")
    public List<MetricasModel> getAllMetricas() {
        return metricasRepository.findAll();
    }

}
