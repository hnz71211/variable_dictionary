package com.lxh.varDict.user.mapper;

import com.lxh.varDict.user.entity.VarUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface VarUserMapper {

  @Insert("INSERT INTO var_user("
          + "id, account, password) VALUES ("
          + "#{varUser.id}, #{varUser.account}, #{varUser.password})")
  void insertVarUser(VarUser varUser);

  @Select("SELECT * FROM var_user WHERE id = #{id}")
  VarUser getVarUser(String id);
}
