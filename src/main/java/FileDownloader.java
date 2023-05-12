import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class FileDownloader {

    public static void downloadFile(String fileUrl, String savePath) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        HttpClient httpClient = HttpClients.custom()
                .setSSLContext(SSLContextBuilder.create().loadTrustMaterial(new TrustAllStrategy()).build())
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();

        HttpGet httpGet = new HttpGet(fileUrl);
        HttpResponse response = httpClient.execute(httpGet);

        try (InputStream in = response.getEntity().getContent();
             OutputStream out = new FileOutputStream(savePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
