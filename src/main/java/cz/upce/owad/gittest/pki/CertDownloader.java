package cz.upce.owad.gittest.pki;

import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;

public class CertDownloader {
	private final transient Logger LOG = Logger.getLogger(getClass());

	private final String serverUrl;

	public CertDownloader(String serverUrl) {
		super();
		this.serverUrl = serverUrl;
	}

	public X509Certificate downloadCert() {
		try {
			URL url = new URL("https://" + serverUrl);
			LOG.info("url=" + url);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.connect();
			Certificate certs[] = con.getServerCertificates();

			LOG.info("certs.length=" + certs.length);
			if (certs.length == 0) {
				return null;
			}
			// LOG.debug(CertUtils.printCerts(certs, url.toString()));

			Certificate cert = certs.length > 0 ? certs[0] : null;
			boolean isX509 = cert instanceof X509Certificate;
			if (!isX509) {
				return null;
			}

			X509Certificate x509 = (X509Certificate) cert;
			LOG.debug(CertUtils.printCert(x509));
			return x509;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
