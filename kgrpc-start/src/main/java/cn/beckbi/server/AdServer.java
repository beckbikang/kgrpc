package cn.beckbi.server;



import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @program: kgrpc
 * @description:
 * @author: bikang
 * @create: 2022-08-28 08:02
 */
public class AdServer {

    private static final Logger logger = Logger.getLogger(AdServer.class.getName());

    private Server server;

    private void start() throws IOException {

        String rootDir = Objects.requireNonNull(AdServer.class.getClassLoader().getResource("")).getPath();


        File keyFile = Paths.get( rootDir+"/server.pem").toFile();
        File certFile = Paths.get( rootDir+"/server.crt")
                .toFile();
        int port = 11111;
        server = ServerBuilder.forPort(port)
                .addService(new AdRpcImpl())
                .useTransportSecurity(certFile, keyFile)
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("*** shutting down gRPC server since JVM is shutting down");
            AdServer.this.stop();
            logger.info("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        final AdServer server = new AdServer();
        server.start();
        server.blockUntilShutdown();
    }
}
