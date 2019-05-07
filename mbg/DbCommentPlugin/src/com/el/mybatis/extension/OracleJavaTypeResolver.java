package com.el.mybatis.extension;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.math.BigDecimal;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created on 16/4/22.
 *
 * @author panlw
 */
public class OracleJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public OracleJavaTypeResolver() {
        super();
        typeMap.put(Types.OTHER, typeMap.get(Types.NCHAR));
    }

    /**
     * Java type when db type is number/decimal.
     * <p>
     * Column Length:
     * - 1~4: Short
     * - 5~9: Integer
     * - 10~18: Long
     * - others: BigDecimal
     *
     * @param introspectedColumn
     * @return
     */
    @Override
    public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {

//        System.out.println("[MBG] --------------------------------------------------");
//        System.out.println("[MBG] Column=" + introspectedColumn.getActualColumnName());
//        System.out.println("[MBG] JavaType=" + introspectedColumn.getJdbcType());
//        System.out.println("[MBG] Length=" + introspectedColumn.getLength());
//        System.out.println("[MBG] Scale=" + introspectedColumn.getScale());
//        System.out.println("[MBG] Props=" + introspectedColumn.getProperties());
//        DATE
        int javaType = introspectedColumn.getJdbcType();
        String columnName = introspectedColumn.getActualColumnName();
        if (javaType == Types.DECIMAL || javaType == Types.NUMERIC) {
            if (introspectedColumn.getLength() == 0) {
                return new FullyQualifiedJavaType(BigDecimal.class.getName());
            }
        } else if (javaType == Types.DATE) {
            if (columnName.indexOf("DATE") != -1 && columnName.indexOf("TIME") == -1) {
                return new FullyQualifiedJavaType(LocalDate.class.getName());
            } else {
                return new FullyQualifiedJavaType(LocalDateTime.class.getName());
            }
        } else if (javaType == Types.TIMESTAMP) {
            if (columnName.indexOf("DATE") != -1) {
                return new FullyQualifiedJavaType(LocalDate.class.getName());
            } else {
                return new FullyQualifiedJavaType(LocalDateTime.class.getName());
            }
        } else if (javaType == Types.TIME) {
            return new FullyQualifiedJavaType(LocalTime.class.getName());
        }
        return super.calculateJavaType(introspectedColumn);
    }

}
