package commons;

import java.io.File;
import java.time.Duration;

public class GlobalContants {
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final String FILE_SEPARATOR = File.separator;
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String LIVE_USER_URL ="http://live.techpanda.org/";
	public static final String LIVE_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";
	public static final String ADMIN_USERNAME ="user01";
	public static final String ADMIN_PASSWORD ="guru99com";
	public static final String EXTENT_PATH = getFolderSeparator("htmlExtent");
	private static String getFolderSeparator(String folderName) {
		return PROJECT_PATH + FILE_SEPARATOR + folderName + FILE_SEPARATOR;
	}
}
