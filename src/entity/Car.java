package entity;

public class Car {
    // 이동 방향
    private double dirX;
    private double dirY;

    // 속도
    private double speed;
    private double speedMax;

    // 가속도
    private double acc;

    public static final double Size=10;

    // 자동차의 위치
    private double x;
    private double y;


    public void move() {
        // 속도 증가(가속 포함)
        speed += acc;

        // 위치 갱신
        x += dirX * speed;
        y += dirY * speed;
    }
    public Car(double x, double y, double dirX, double dirY, double speed, double acc) {
        this.x = x;
        this.y = y;
        setDir(dirX, dirY);
        this.speed = speed;
        this.acc = acc;
    }

    // 단위 벡터로 방향 정규화
    public void setDir(double dirX, double dirY) {
        double len = Math.sqrt(dirX * dirX + dirY * dirY);
        this.dirX = dirX / len;
        this.dirY = dirY / len;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getSpeed() { return speed; }
    public double getDirX() { return dirX; }
    public double getDirY() { return dirY; }

}


