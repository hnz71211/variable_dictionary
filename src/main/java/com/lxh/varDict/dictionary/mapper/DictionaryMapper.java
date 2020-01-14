package com.lxh.varDict.dictionary.mapper;

import com.lxh.varDict.dictionary.entity.VarGroup;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface DictionaryMapper {

  @Select("SELECT * FROM var_group WHERE id = #{id}")
  VarGroup queryVarGroupsById(@Param("id") String id);

  @Insert("INSERT INTO var_group("
          + "id, name, focus, create_person, create_date) VALUES ("
          + "#{id}, #{name}, #{focus}, #{createPerson}, now())")
  int insertVarGroup(VarGroup varGroup);

  @Update({ "UPDATE var_group "
          + "SET name = #{name}"
          + "WHERE id = #{id}" })
  void updateVarGroup(VarGroup varGroup);
}
