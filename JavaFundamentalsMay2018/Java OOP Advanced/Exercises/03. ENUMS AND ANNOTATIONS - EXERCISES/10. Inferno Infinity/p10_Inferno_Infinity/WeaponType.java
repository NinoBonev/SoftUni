package p10_Inferno_Infinity;

/**
 * Created by Nino Bonev - 24.7.2018 г., 16:37
 */
public enum WeaponType {
    AXE(5, 10, 4), SWORD(4, 6, 3), KNIFE(3, 4, 2),;

    private int minDamage;
    private int maxDamage;
    private int sockets;

    WeaponType(int minDamage, int maxDamage, int sockets) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.sockets = sockets;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getSockets() {
        return sockets;
    }
}
