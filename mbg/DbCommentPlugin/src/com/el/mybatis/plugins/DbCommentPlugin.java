package com.el.mybatis.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.sql.Types;
import java.util.List;

/**
 * Created on 16/3/12.
 *
 * @author panlw
 * @see <a href="http://www.mybatis.org/generator/reference/pluggingIn.html">Implementing Plugins</a>
 */
public class DbCommentPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelFieldGenerated(
        Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
        IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        generateFieldJavaDoc(field, introspectedColumn, introspectedTable);
        generateFieldAnnotation(field, introspectedColumn, topLevelClass);
        return true;
    }

    private void generateFieldJavaDoc(Field field, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable) {
        field.addJavaDocLine("/**"); //$NON-NLS-1$

        StringBuilder sb = new StringBuilder();
        sb.append(" *  "); //$NON-NLS-1$
        sb.append(introspectedColumn.getRemarks());
        sb.append(" - ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());

        field.addJavaDocLine(" */"); //$NON-NLS-1$

    }

    private void generateFieldAnnotation(Field field, IntrospectedColumn introspectedColumn, TopLevelClass topLevelClass) {
        int javaType = introspectedColumn.getJdbcType();
        String columnName = introspectedColumn.getActualColumnName().toUpperCase();
        if (javaType == Types.TIMESTAMP || javaType == Types.DATE) { //annotation datetime
            topLevelClass.addImportedType(new FullyQualifiedJavaType("com.el.core.util.TimeUtil"));
            if (columnName.indexOf("DATE") != -1 && columnName.indexOf("TIME") != -1) {
                field.addAnnotation("@TimeUtil.YMDHMS");
            } else if (columnName.indexOf("DATE") != -1) {
                field.addAnnotation("@TimeUtil.YMD");
            } else if(columnName.indexOf("TIME") != -1){
                field.addAnnotation("@TimeUtil.YMDHM");
            }else{
                field.addAnnotation("@TimeUtil.YMDHMS"); //other default
            }
        }
    }
}
