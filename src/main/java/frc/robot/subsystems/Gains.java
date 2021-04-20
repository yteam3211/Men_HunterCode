package frc.robot.subsystems;

public class Gains {
    public double kp;
    public double ki;
    public double kd;

    Gains(int kp, int ki, int kd){
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
    }
}
