package connection;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ConnectionPool {
    FileInputStream fis;
    private static GenericObjectPool gPool = null;
    final Properties property = new Properties();


    @SuppressWarnings("unused")
    public DataSource setUpPool() throws Exception {
        try{
            InputStream is = null;
            is = this.getClass().getResourceAsStream("/config.properties");
            property.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class.forName(property.getProperty("db.driver"));

        // Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
        gPool = new GenericObjectPool();
        gPool.setMaxActive(5);

        // Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
        ConnectionFactory cf = new DriverManagerConnectionFactory(property.getProperty("db.host"), property.getProperty("db.login"), property.getProperty("db.password"));

        // Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
        PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
        return new PoolingDataSource(gPool);
    }

    public GenericObjectPool getConnectionPool() {
        return gPool;
    }

}

