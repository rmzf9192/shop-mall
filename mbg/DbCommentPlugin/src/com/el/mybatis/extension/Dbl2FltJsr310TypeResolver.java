package com.el.mybatis.extension;

import java.sql.Types;

/**
 * @author panlw
 * @since 17/1/4
 */
public class Dbl2FltJsr310TypeResolver extends Jsr310TypeResolver {

    public Dbl2FltJsr310TypeResolver() {
        super();
        typeMap.put(Types.DOUBLE, typeMap.get(Types.REAL));
        typeMap.put(Types.OTHER, typeMap.get(Types.NCHAR));
    }

}
