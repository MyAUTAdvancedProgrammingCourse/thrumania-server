package com.poorgroupproject.thrumaniaserver

import java.io.{BufferedReader, InputStreamReader}
import java.net.{ServerSocket, Socket}

import scala.actors.threadpool.{ExecutorService, Executors}

/**
  * Created by ahmad on 6/17/16.
  */
class ServerListener(port: Int, poolSize: Int) extends Runnable {
  val serverSocket = new ServerSocket(port)
  val pool: ExecutorService = Executors.newFixedThreadPool(poolSize)

  def run() {
    try {
      var i = 0
      while (true) {
        // This will block until a connection comes in.
        val socket = serverSocket.accept()
        val in = new BufferedReader(new InputStreamReader(socket.getInputStream)).readLine
        /*var f = new FileSplit(in) //FileSplit is another class that i would like each
                                    // client's sent string to be passed as an instance of
          f.move*/
        pool.execute(new Handler(socket))

      }
    } finally {
      pool.shutdown()


    }
  }

}

class Handler(socket: Socket) extends Runnable {
  def message = (Thread.currentThread.getName() + "\n").getBytes

  def run() {
    socket.getOutputStream.write(message)
    socket.getOutputStream.close()

  }
}
