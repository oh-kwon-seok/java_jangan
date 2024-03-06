package com.springboot.java_jangan.data.repository.sensor;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_jangan.data.dto.sensor.SensorSearchDto;
import com.springboot.java_jangan.data.entity.Sensor;
import com.springboot.java_jangan.data.entity.QSensor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SensorRepositoryCustomImpl extends QuerydslRepositorySupport implements SensorRepositoryCustom {

    public SensorRepositoryCustomImpl(){
        super(Sensor.class);
    }

    @Override
    public List<Sensor> findTempAll(SensorSearchDto sensorSearchDto){
        QSensor sensor = QSensor.sensor;

        String filter_title = sensorSearchDto.getFilter_title();
        String search_text = sensorSearchDto.getSearch_text();

        LocalDateTime start_date = sensorSearchDto.getStart_date();
        LocalDateTime end_date = sensorSearchDto.getEnd_date();




        Predicate dateRange = sensor.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate type = sensor.type.eq("온도");


        List<Sensor> sensorList = from(sensor)

                .select(sensor)
                .where(dateRange,type)
                .groupBy(sensor.created.year(), sensor.created.month(), sensor.created.dayOfMonth(), sensor.created.hour())  // 날짜별, 시간별로 그룹화
                .orderBy(sensor.created.desc())
                .limit(5)
                .fetch();

        return sensorList;
    }
    @Override
    public List<Sensor> findHumiAll(SensorSearchDto sensorSearchDto){
        QSensor sensor = QSensor.sensor;

        String filter_title = sensorSearchDto.getFilter_title();
        String search_text = sensorSearchDto.getSearch_text();

        LocalDateTime start_date = sensorSearchDto.getStart_date();
        LocalDateTime end_date = sensorSearchDto.getEnd_date();




        Predicate dateRange = sensor.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate type = sensor.type.eq("습도");


        List<Sensor> sensorList = from(sensor)

                .select(sensor)
                .where(dateRange,type)
                .groupBy(sensor.created.year(), sensor.created.month(), sensor.created.dayOfMonth(), sensor.created.hour())  // 날짜별, 시간별로 그룹화
                .orderBy(sensor.created.desc())
                .limit(5)
                .fetch();

        return sensorList;
    }

}
