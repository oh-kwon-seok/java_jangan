package com.springboot.java_jangan.data.repository.sensor;

import com.springboot.java_jangan.data.dto.sensor.SensorSearchDto;
import com.springboot.java_jangan.data.entity.Sensor;

import java.util.List;

public interface SensorRepositoryCustom {
    List<Sensor> findTempAll(SensorSearchDto sensorSearchDto);
    List<Sensor> findHumiAll(SensorSearchDto sensorSearchDto);


}
