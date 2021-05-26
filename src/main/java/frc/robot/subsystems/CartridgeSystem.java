package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CartridgeSystem extends SubsystemBase {

  private VictorSP downMotor = new VictorSP(Constants.PWM_CR_DOWN);
  private VictorSP leftMotor = new VictorSP(Constants.PWM_CR_LEFT);
  private VictorSP rightMotor = new VictorSP(Constants.PWM_CR_RIGHT);

  public CartridgeSystem() {

  }

  @Override
  public void periodic() {
  }

  public void setOutputIn(){
    downMotor.set(0.5);
    leftMotor.set(0.5);
    rightMotor.set(-0.5);
  }

  public void setOutputOut(){
    downMotor.set(-0.5);
    leftMotor.set(-0.5);
    rightMotor.set(0.5);
  }

  public void stopOutput(){
    downMotor.set(0);
    leftMotor.set(0);
    rightMotor.set(0);
  }
}
