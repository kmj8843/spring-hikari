package com.rlalsa8843.hikari.demo;

import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {

    String select(String key);

    void insert(DemoModel model);

    void update(AliasModel model);

    void delete(Map<String, String> param);
}
