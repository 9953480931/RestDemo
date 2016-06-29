/**
 * 
 */
package org.cassandraSession;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;



/**
 * @author jaspreet.singh1
 *
 */
public class SessionCreate {
	
private static Session cassandraSession = null;
	
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Unable to clone CassandraSession");
	}
	

	
	public static final Session getCassandraSession(String nodeInformation, String keyspace){
		if(null == cassandraSession){
			synchronized (SessionCreate.class) {
				if (cassandraSession == null) {
					cassandraSession = buildSession(nodeInformation, keyspace);
				}
			}
		}
		return cassandraSession;
	}

	private static Session buildSession(String nodeInformation, String keyspace){
		Cluster.Builder builder = Cluster.builder();
        builder = builder.addContactPoint(nodeInformation);
        Cluster cluster = builder.build();
        Session session = cluster.connect(keyspace);
        return session;
	}
	
	public static void main(String[] args) {
		Session session = buildSession("127.0.0.1", "Finity");
		System.out.println(session.getLoggedKeyspace());
	}
}
