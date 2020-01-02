package com.el.jichu.designpattern.flyweight.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 10:39
 * @Version:V1.0
 * @Description:ConnectionPool:数据库连接池代码 通过连接池的管理，实现了数据库连接的共享，不需要每一次都重新创建连接，
 * 节省了数据 库重新创建的开销，提升了系统的性能！
 */
public class ConnectionPool {

    private Vector<Connection> pool;

    //公有属性
    private String url = "jdbc:mysql://localhost:3306/test";

    private String username = "root";

    private String password = "root";
    private String driverClassName = "com.mysql.jdbc.Driver";

    private int poolSize = 100;

    private static ConnectionPool instance = null;

    Connection connection = null;

    //构造方法，做一些初始化工作
    private ConnectionPool() {
        pool = new Vector<Connection>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driverClassName);
                connection = DriverManager.getConnection(url, username, password);
                pool.add(connection);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //返回连接到数据库连接池
    public synchronized void release() {
        pool.add(connection);
    }

    //返回连接到一个数据库连接池
    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection connection = pool.get(0);
            pool.remove(connection);
            return connection;
        } else {
            return null;
        }
    }


}
