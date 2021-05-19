package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotButtons;
import frc.robot.commands.JoystickDriveCommand;

public class DriveTrain extends SubsystemBase {

  private CANSparkMax LM;
  private CANSparkMax LS;
  private CANSparkMax RM;
  private CANSparkMax RS;

  public Gains gains;

  public DriveTrain() {
    LM = new CANSparkMax(Constants.SPARK_DRIVE_LM, MotorType.kBrushless);
    LS = new CANSparkMax(Constants.SPARK_DRIVE_LS, MotorType.kBrushless);
    RM = new CANSparkMax(Constants.SPARK_DRIVE_RM, MotorType.kBrushless);
    RS = new CANSparkMax(Constants.SPARK_DRIVE_RS, MotorType.kBrushless);
    LS.follow(LM);
    RS.follow(RM);

    setDefaultCommand(new JoystickDriveCommand(this, RobotButtons.driveJostick));
  }

  @Override
  public void periodic() {
  }

  public void tank(double lPower, double rPower){
    LM.set(lPower);
    RM.set(rPower);
  }

  public double getLeftPosition(){
    return LM.getEncoder().getPosition() * Constants.DRIVE_ENCODER_2_METER;
  }

  public double getRightPosition(){
    return RM.getEncoder().getPosition() * Constants.DRIVE_ENCODER_2_METER;
  }

  public double getPosition(){
    return (RM.getEncoder().getPosition() * Constants.DRIVE_ENCODER_2_METER + 
        LM.getEncoder().getPosition() * Constants.DRIVE_ENCODER_2_METER) / 2;
  }

  public void resetEncoders(){
    LM.getEncoder().setPosition(0);
    RM.getEncoder().setPosition(0);
  } 
}
