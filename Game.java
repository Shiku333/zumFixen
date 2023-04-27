public class Game implements Runnable {

    public static final int FPS = 60;
    public static final long maxLoopTime = 1000 / FPS;
  
    public static void main(String[] arg) {
      Game game = new Game();
      new Thread(game).start();
    
    
    }



    public boolean running = true;
    @Override
    public void run() {
      long timestamp;
      long oldTimestamp;
      while(running) {
        oldTimestamp = System.currentTimeMillis();
        update();
        timestamp = System.currentTimeMillis();
        if(timestamp-oldTimestamp > maxLoopTime) {
          System.out.println("Wir sind zu spät!");
          continue;
        }
        render();
        timestamp = System.currentTimeMillis();
        System.out.println(maxLoopTime + " : " + (timestamp-oldTimestamp));
        if(timestamp-oldTimestamp <= maxLoopTime) {
          try {
            Thread.sleep(maxLoopTime - (timestamp-oldTimestamp) );
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
    static void update() {
        try {
          Thread.sleep(15);
        } catch (InterruptedException e) {
          e.printStackTrace();
        };
      }
      
    void render() { }


  }
  