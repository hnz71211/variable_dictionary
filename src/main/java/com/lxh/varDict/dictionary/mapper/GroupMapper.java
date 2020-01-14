package com.lxh.varDict.dictionary.mapper;

import com.lxh.varDict.dictionary.entity.VarGroup;
import com.lxh.varDict.dictionary.entity.VarGroupFocus;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: GroupMapper
 * @Description:
 * @Author: hexli
 * @Date: 2020-01-14 
 **/
@Component
public interface GroupMapper {

  @Select("SELECT * FROM var_group WHERE id = #{id}") VarGroup queryVarGroupsById(@Param("id") String id);

  @Insert("INSERT INTO var_group("
          + "id, name, create_person, create_date) VALUES ("
          + "#{id}, #{name}, #{createPerson}, now())")
  int insertVarGroup(VarGroup varGroup);

  @Update({ "UPDATE var_group "
          + "SET name = #{name}"
          + "WHERE id = #{id}" })
  void updateVarGroup(VarGroup varGroup);

  @Select("SELECT focus FROM var_group_focus WHERE group_id = #{id}") List<String> queryVarGroupFocus(String id);

  @Insert({"<script>"
          + "INSERT INTO var_group_focus ("
          + "follower, groupId, state) VALUES "
          + "<foreach collection=\"varGroupFocus.groupIds\" item=\"groupId\" separator=\",\">"
          + "(#{varGroupFocus.follower},"
          + "#{groupId}"
          + "#{state})"
          + "</foreach>"
          + "</script>"})
  int insertVarGroupFocus(VarGroupFocus varGroupFocus);

  @Delete("delete from var_group_focus where group_id = #{groupId} and focus = #{focus}")
  void deleteVarGroupFocus(String groupId, String focus);
}
