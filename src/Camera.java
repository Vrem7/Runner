public class Camera {
    private int x;
    private int y;
    private Hero hero;
    private double k = 0.1;
    private double m = 1.0;
    private double f = 0.2;
    private double vx = 0.0;

    public Camera(int x, int y, Hero hero) {
        this.x = x;
        this.y = y;
        this.hero = hero;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    public void update(long time) {
        double ax = ((k * (hero.getImageView().getX() - x)) - (f * vx)) / m;
        vx += (int) ax * ((double) time / 1000000);
        x += (int) (vx * (time / 1000000));
        x = (int) (hero.getImageView().getX() - 100);
    }
}
