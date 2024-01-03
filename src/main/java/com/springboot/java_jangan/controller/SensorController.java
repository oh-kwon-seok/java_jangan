package com.springboot.java_jangan.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.data.dto.sensor.SensorDto;
import com.springboot.java_jangan.data.dto.sensor.SensorSearchDto;
import com.springboot.java_jangan.data.entity.Sensor;
import com.springboot.java_jangan.service.SensorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sensor")
@Controller
public class SensorController {
    private final SensorService sensorService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(SensorController.class);

    @Autowired
    public SensorController(SensorService sensorService){
        this.sensorService = sensorService;
    }

    @GetMapping(value= "/temp_select")
    public ResponseEntity<List<Sensor>> getTempSensor(@ModelAttribute SensorSearchDto sensorSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Sensor> selectedTotalSensor = sensorService.getTempSensor(sensorSearchDto);

        LOGGER.info("[getTempSensor] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalSensor);

    }
    @GetMapping(value= "/humi_select")
    public ResponseEntity<List<Sensor>> getHumiSensor(@ModelAttribute SensorSearchDto sensorSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<Sensor> selectedTotalSensor = sensorService.getHumiSensor(sensorSearchDto);

        LOGGER.info("[getTempSensor] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalSensor);

    }



}
