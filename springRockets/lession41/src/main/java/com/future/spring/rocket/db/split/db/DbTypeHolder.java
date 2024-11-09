package com.future.spring.rocket.db.split.db;

//通过线程变量来控制主从库
public class DbTypeHolder {

    private static final ThreadLocal<DbType> dbTypeThreadLocal = new ThreadLocal<>();

    public static void setMaster() {
        dbTypeThreadLocal.set(DbType.MASTER);
    }

    public static void setSlave() {
        dbTypeThreadLocal.set(DbType.SLAVE);
    }

    public static DbType getDbType() {
        return dbTypeThreadLocal.get();
    }

    public static void clearDbType() {
        dbTypeThreadLocal.remove();
    }
}
