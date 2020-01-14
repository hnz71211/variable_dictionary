package com.lxh.varDict.dictionary.mapper;

import com.lxh.varDict.dictionary.entity.VarGroup;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DictionaryMapper {

  @Select("SELECT * FROM var_group WHERE id = #{id}")
  VarGroup queryVarGroupsById(@Param("id") String id);

  @Insert("INSERT INTO var_group("
          + "id, name, create_person, create_date) VALUES ("
          + "#{id}, #{name}, #{createPerson}, now())")
  int insertVarGroup(VarGroup varGroup);

  @Update({ "UPDATE var_group "
          + "SET name = #{name}"
          + "WHERE id = #{id}" })
  void updateVarGroup(VarGroup varGroup);

  @Select("SELECT focus FROM var_group_focus WHERE group_id = #{id}")
  List<String> queryVarGroupFocus(String id);

  @Insert({"<script>"
          + "INSERT INTO var_group_focus ("
          + "group_id, focus) VALUES "
          + "<foreach collection=\"focusList\" item=\"focus\" separator=\",\">"
          + "(#{groupId},"
          + "#{focus})"
          + "</foreach>"
          + "</script>"})
  int insertVarGroupFocus(String groupId, List<String> focusList);
}
