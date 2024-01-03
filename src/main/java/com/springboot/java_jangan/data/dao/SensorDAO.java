package com.springboot.java_jangan.data.dao;


import com.springboot.java_jangan.data.dto.sensor.SensorDto;
import com.springboot.java_jangan.data.dto.sensor.SensorSearchDto;
import com.springboot.java_jangan.data.entity.Sensor;

import java.util.List;


public interface SensorDAO {


    List<Sensor> selectTempSensor(SensorSearchDto SensorSearchDto);

    List<Sensor> selectHumiSensor(SensorSearchDto SensorSearchDto);


}
