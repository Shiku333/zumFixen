 

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

/**
 * Um aus Kacheln ein Spielfeld zu erstellen wird eine Liste mit zahlen erstellt, bei uns 20x20 kacheln (400 Zahlen)
 * Zahlen sind in einer Textdatei enthalten,ersten beiden zahlen beschreiben keine Kachel, sondern Größe des Spielfelds
 *  
 */
public class TileSet {
  public static final int TILEWIDTH = 16, TILEHEIGHT = 16;
  private BufferedImage[] tiles;
  private int sizeX;
  private int sizeY;

  @SuppressWarnings("rawtypes")
  public HashSet hs;

/**
 * Das Tile Set aus der SPielfeld Datei wird in ein Array eingelesen und jedes gewünschte Tile wird an die 
 * vorgegebene Position des Spielfelds gerendert
 */
  public TileSet(String path, int sizeX, int sizeY, int border, @SuppressWarnings("rawtypes") HashSet hs) {
      // das Tileset wird in ein BufferedImage eingelseen, BufferedImage besteht aus eine Raster von Bilddateien und
      // einem Farb-Modell, welches beliebig manipuliert werden kann
    this.hs = hs;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    tiles = new BufferedImage[sizeX*sizeY];
    BufferedImage tileSet;
    try {
      tileSet = ImageIO.read(TileSet.class.getResource(path));
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }
    int i = 0;
    for(int y = 0; y < sizeY; y++) {
      for(int x = 0; x < sizeX; x++) { //die Methode getSubimage kopiert rechteckige Stücke aus dem Bufferedimage 
          // aus jeder y/x Zeile des Tilesets wird jeded kachel kopiert und 
         tiles[i++] = tileSet.getSubimage(x * (TILEWIDTH + border), y * (TILEHEIGHT + border), TILEWIDTH, TILEHEIGHT);
      }
    }
  }
  public void renderTile(Graphics g, int tileNum, int x, int y){
      //hier wird das BufferdImage sichtbar gemacht und auf den Bildschirm gezeichnet
    g.drawImage(tiles[tileNum], x, y, TILEWIDTH, TILEHEIGHT, null);
  }
}