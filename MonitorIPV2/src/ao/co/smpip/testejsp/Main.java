package ao.co.smpip.testejsp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {

		Properties properties = System.getProperties();
		String os = (String) properties.get("os.name");

		if (os.contains("Windows")) {
			final String COMMAND = "wmic baseboard get serialnumber";
			final String SUB_STRING = "SerialNumber ";
			final String LOCATOR = "\n";

			Process process = null;
			InputStream iStream = null;

			try {
				process = Runtime.getRuntime().exec(COMMAND);
				iStream = process.getInputStream();

				byte[] buf = new byte[1024];
				int len = 0;
				StringBuffer sb = new StringBuffer();
				while ((len = iStream.read(buf)) >= 0) {
					sb.append(new String(buf));
				}

				String ret = sb.toString();

				if (ret.contains(SUB_STRING)) {
					String volume = ret.substring(ret.indexOf(LOCATOR) + LOCATOR.length(), ret.length()).trim();
					System.out.println(volume);
				} else {
					System.out.println("Volume not found.");
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (process != null) {
						process.destroy();
					}
					if (iStream != null) {
						iStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
