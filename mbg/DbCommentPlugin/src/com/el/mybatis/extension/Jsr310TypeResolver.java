package com.el.mybatis.extension;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author panlw
 * @since 17/1/3
 */
public class Jsr310TypeResolver extends JavaTypeResolverDefaultImpl {

    public Jsr310TypeResolver() {
        super();
        typeMap.put(Types.OTHER, typeMap.get(Types.NCHAR));
    }

    /**
     *  Date/time to types of JSR310
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

        int javaType = introspectedColumn.getJdbcType();
        if (javaType == Types.DATE) {
            return new FullyQualifiedJavaType(LocalDate.class.getName());
        }
        else if (javaType == Types.TIMESTAMP) {
            return new FullyQualifiedJavaType(LocalDateTime.class.getName());
        }
        else if (javaType == Types.TIME) {
            return new FullyQualifiedJavaType(LocalTime.class.getName());
        }
        return super.calculateJavaType(introspectedColumn);
    }

}
