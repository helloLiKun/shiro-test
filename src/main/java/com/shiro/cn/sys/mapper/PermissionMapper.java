package com.shiro.cn.sys.mapper;

import com.shiro.cn.sys.entity.Permission;
import com.shiro.cn.sys.entity.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    int countByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    int deleteByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    int insert(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    int insertSelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    List<Permission> selectByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    Permission selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated Sun Jan 27 16:34:56 GMT+08:00 2019
     */
    int updateByPrimaryKey(Permission record);
}