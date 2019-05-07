package com.el.mbg.mapper;

import com.el.mbg.domain.DeptModel;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface DeptModelMapper {
    @Delete({
        "delete from dept",
        "where deptno = #{deptno,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long deptno);

    @Insert({
        "insert into dept (deptno, dname, ",
        "db_source, id, pid, ",
        "cid)",
        "values (#{deptno,jdbcType=BIGINT}, #{dname,jdbcType=VARCHAR}, ",
        "#{dbSource,jdbcType=VARCHAR}, #{id,jdbcType=INTEGER}, #{pid,jdbcType=INTEGER}, ",
        "#{cid,jdbcType=INTEGER})"
    })
    int insert(DeptModel record);

    @Select({
        "select",
        "deptno, dname, db_source, id, pid, cid",
        "from dept",
        "where deptno = #{deptno,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="deptno", property="deptno", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="dname", property="dname", jdbcType=JdbcType.VARCHAR),
        @Result(column="db_source", property="dbSource", jdbcType=JdbcType.VARCHAR),
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="cid", property="cid", jdbcType=JdbcType.INTEGER)
    })
    DeptModel selectByPrimaryKey(Long deptno);

    @Select({
        "select",
        "deptno, dname, db_source, id, pid, cid",
        "from dept"
    })
    @Results({
        @Result(column="deptno", property="deptno", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="dname", property="dname", jdbcType=JdbcType.VARCHAR),
        @Result(column="db_source", property="dbSource", jdbcType=JdbcType.VARCHAR),
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="cid", property="cid", jdbcType=JdbcType.INTEGER)
    })
    List<DeptModel> selectAll();

    @Update({
        "update dept",
        "set dname = #{dname,jdbcType=VARCHAR},",
          "db_source = #{dbSource,jdbcType=VARCHAR},",
          "id = #{id,jdbcType=INTEGER},",
          "pid = #{pid,jdbcType=INTEGER},",
          "cid = #{cid,jdbcType=INTEGER}",
        "where deptno = #{deptno,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(DeptModel record);
}