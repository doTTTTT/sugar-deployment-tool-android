package com.sugarizer.sugarizerdeploymenttoolapp;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collection;

public class ServerWebSocket extends WebSocketServer {
    private static int counter = 0;

    public ServerWebSocket(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        counter++;
        System.out.println("///////////Opened connection number" + counter);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("closed");
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.out.println("Error:");
        ex.printStackTrace();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        conn.send(message);
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer blob) {
        conn.send(blob);
    }

    /**
     * Sends <var>text</var> to all currently connected WebSocket clients.
     *
     * @param text
     *            The String to send across the network.
     * @throws InterruptedException
     *             When socket related I/O errors occur.
     */
    public void sendToAll(String text) {
        Collection<WebSocket> con = connections();
        synchronized (con) {
            for (WebSocket c : con) {
                c.send(text);
            }
        }
    }
}