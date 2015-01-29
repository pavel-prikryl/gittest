package cz.upce.owad.gittest.pki;

import java.security.cert.Certificate;

public class CertUtils {

	public static String printCert(Certificate cert) {
		return cert != null ? cert.toString() : "null";
	}

	private static final String SEP = "------------------------------------------------------------------------";
	private static final String N = "\n";
	private static final String T = "\t";

	public static String printCerts(Certificate[] certs) {
		return printCerts(certs, null);
	}

	public static String printCerts(Certificate[] certs, String info) {
		StringBuilder ret = new StringBuilder();

		for (int i = 0; i < certs.length; i++) {
			ret.append(N).append(SEP).append(N);
			if (info != null) {
				ret.append(T).append(info).append(N);
			}
			ret.append(T)
					.append("certificate [" + (i + 1) + "/" + certs.length
							+ "]").append(N);
			ret.append(SEP).append(N);
			ret.append(printCert(certs[i]));
		}

		return ret.toString();
	}

}
