package cz.upce.owad.gittest.pki;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CertDownloaderTest {

	@Test
	public void testDownloadCert() {
		String url = "www.upce.cz";
		java.security.cert.Certificate cert = new CertDownloader(url)
				.downloadCert();

		assertNotNull(cert);
	}

}
