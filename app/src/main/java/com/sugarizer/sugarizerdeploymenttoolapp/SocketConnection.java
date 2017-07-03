package com.sugarizer.sugarizerdeploymenttoolapp;

import org.java_websocket.WebSocket;

import java.net.UnknownHostException;
import java.util.Observable;

public class SocketConnection extends Observable {
    private final int PORT = 62666;
    protected ServerWebSocket server;
    public String contentInfo;
    private static SocketConnection socketConnection = null;

    /**
     * Instantiates a new server
     */
    protected SocketConnection() {
        try {
            server = new ServerWebSocket(PORT) {
                public void onMessage(WebSocket conn, String message) {
                    contentInfo = message;
                    setChanged();
                    notifyObservers();
                }
            };
            server.start();
        } catch (UnknownHostException e) {

            e.printStackTrace();
        }
    }

    static public SocketConnection getInstance() {
        if (socketConnection == null) {
            socketConnection = new SocketConnection();
        }
        return socketConnection;
    }

    /**
     * Send data. Send the message
     *
     * @param message
     *            the information
     */
    public void sendData(String message) throws Exception {
        server.sendToAll(message);
    }
}