package com.springboot.java_jangan.service;


import com.springboot.java_jangan.data.dto.sensor.SensorDto;
import com.springboot.java_jangan.data.dto.sensor.SensorSearchDto;
import com.springboot.java_jangan.data.entity.Sensor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SensorService {

    List<Sensor> getTempSensor(SensorSearchDto sensorSearchDto);
    List<Sensor> getHumiSensor(SensorSearchDto sensorSearchDto);


}
