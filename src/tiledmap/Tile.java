package tiledmap;

import util.Vector2i;

import java.awt.*;

class Tile {

    public enum AreaType {
        PEDESTRIAN,
        VEHICLE,
        BLOCKED
    }

    public AreaType type;
    private TileSet tileSet;
    public Vector2i position;
    private int index;

    public Tile(TileSet tileSet, Vector2i position, AreaType type) {
        this.tileSet = tileSet;
        this.position = position;
        index = 0;
        this.type = type;
    }

    public void next() {
        ++index;
        type = tileSet.getTileType(index);
    }

    public void draw(Graphics g, int tileSize, Point viewPosition) {
        int x = position.x - viewPosition.x;
        int y = position.y - viewPosition.y;
        g.drawImage(tileSet.getTileImage(index), x * tileSize, y * tileSize, null);
        g.setColor(Color.GRAY);
        g.drawRect(x * tileSize, y * tileSize, tileSize, tileSize);
    }


}
