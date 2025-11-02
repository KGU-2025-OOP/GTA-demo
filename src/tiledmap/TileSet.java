package tiledmap;

import util.Vector2i;

import java.awt.image.BufferedImage;

public class TileSet {
    public class SpriteAccessor {
        private int index;
        private Vector2i point;

        public SpriteAccessor() {
            index = 0;
            point.x = point.y = 0;
        }
        public void inc() {
            ++index;
            point.y = index / spriteSize.x;
            point.x = index % spriteSize.x;
            if (index >= spriteSize.x + spriteSize.y) {
                index = 0;
                point.x = point.y = 0;
            }
        }

    }
    private String name;
    private Vector2i spriteSize;
    private BufferedImage[] tileImages;
    private Tile.AreaType[] tileTypes;

    public TileSet(BufferedImage image, final String name, Vector2i tileGridSize) {
        this.name = name;
        final int x = image.getWidth() / tileGridSize.x;
        final int y = image.getHeight() / tileGridSize.y;

        spriteSize = new Vector2i(x, y);
        tileImages = new BufferedImage[x * y];
        tileTypes = new Tile.AreaType[x * y];

        SpriteAccessor accessor = new SpriteAccessor();
        for (int i = 0; i < x * y; ++i, accessor.inc()) {
            tileTypes[i] = Tile.AreaType.VEHICLE;
            tileImages[i] = image.getSubimage(accessor.point.x * x, accessor.point.y * y, x, y);
        }
    }

    public int getTiledImageLength() {
        return tileImages.length;
    }

    public void setTileTypes(Tile.AreaType[] typeArray) {
        tileTypes = typeArray;
    }

    public BufferedImage getTileImage(int index) {
        return tileImages[index % tileImages.length];
    }

    public Tile.AreaType getTileType(int index) {
        return tileTypes[index % tileTypes.length];
    }

    public String getName() {
        return name;
    }
}
