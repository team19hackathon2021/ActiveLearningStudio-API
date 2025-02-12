package {{ PROJECT_JAVA_PACKAGE }}.config;

import org.computate.vertx.config.ComputateVertxConfigKeys;

/**
 * Keyword: classSimpleNameConfigKeys
 */
public class ConfigKeys extends ComputateVertxConfigKeys {

	/**
	 * 
	 **/
	public static final String SOLR_WORKER_COMMIT_WITHIN_MILLIS = "SOLR_WORKER_COMMIT_WITHIN_MILLIS";

	/**
	 * 
	 **/
	public static final String VERTX_WORKER_SEND_TIMEOUT_MILLIS = "VERTX_WORKER_SEND_TIMEOUT_MILLIS";

	/**
	 * 
	 **/
	public static final String MOONSHOTS_DRIVER_CLASS = "MOONSHOTS_DRIVER_CLASS";

	/**
	 * 
	 **/
	public static final String MOONSHOTS_PORT = "MOONSHOTS_PORT";

	/**
	 * 
	 **/
	public static final String MOONSHOTS_HOST = "MOONSHOTS_HOST";

	/**
	 * 
	 **/
	public static final String MOONSHOTS_DATABASE = "MOONSHOTS_DATABASE";

	/**
	 * 
	 **/
	public static final String MOONSHOTS_USERNAME = "MOONSHOTS_USERNAME";

	/**
	 * 
	 **/
	public static final String MOONSHOTS_PASSWORD = "MOONSHOTS_PASSWORD";

	/**
	 * 
	 **/
	public static final String MOONSHOTS_MAX_IDLE_TIME = "MOONSHOTS_MAX_IDLE_TIME";

	/**
	 * 
	 **/
	public static final String MOONSHOTS_CONNECTION_TIMEOUT = "MOONSHOTS_CONNECTION_TIMEOUT";

	/**
	 * enUS: The maximum number of connections to pool - default is 15. 
	 **/
	public static final String MOONSHOTS_MAX_POOL_SIZE = "MOONSHOTS_MAX_POOL_SIZE";

	/**
	 * enUS: The minimum number of connections to pool. 
	 **/
	public static final String MOONSHOTS_MIN_POOL_SIZE = "MOONSHOTS_MIN_POOL_SIZE";

	/**
	 * Number of seconds after which an idle connection will be closed - default is 0 (never expire). 
	 **/
	public static final String MOONSHOTS_MAX_STATEMENTS = "MOONSHOTS_MAX_STATEMENTS";

	/**
	 * The maximum number of prepared statements to cache - default is 0. 
	 **/
	public static final String MOONSHOTS_MAX_STATEMENTS_PER_CONNECTION = "MOONSHOTS_MAX_STATEMENTS_PER_CONNECTION";

	/**
	 * The timezone of the Moonshots database when retrieving local date time values. 
	 **/
	public static final String MOONSHOTS_ZONE = "MOONSHOTS_ZONE";

	/**
	 * 
	 **/
	public static final String MOONSHOTS_FETCH_SIZE = "MOONSHOTS_FETCH_SIZE";
}
