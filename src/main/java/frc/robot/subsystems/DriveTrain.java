// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotButtons;
import frc.robot.commands.JoystickDriveCommand;

public class DriveTrain extends SubsystemBase {

  private CANSparkMax LM = new CANSparkMax(Constants.SPARK_DRIVE_LM, MotorType.kBrushless);
  private CANSparkMax LS = new CANSparkMax(Constants.SPARK_DRIVE_LS, MotorType.kBrushless);
  private CANSparkMax RM = new CANSparkMax(Constants.SPARK_DRIVE_RM, MotorType.kBrushless);
  private CANSparkMax RS = new CANSparkMax(Constants.SPARK_DRIVE_RS, MotorType.kBrushless);

  public Gains gains;

  public DriveTrain() {
    LM.follow(LS);
    RM.follow(RS);

    setDefaultCommand(new JoystickDriveCommand(RobotButtons.driveJostick, this));
  }

  public DriveTrain(Gains gains) {
    LM.follow(LS);
    RM.follow(RS);

    this.gains = gains;
  }

  @Override
  public void periodic() {
  }

  public void tank(double lPower, double rPower){
    LM.set(lPower);
    RM.set(rPower);
  }

  public void setOutput(double power){
    LM.set(power);  
    LM.set(power);
  }
  
  public void stopOutput(){
    LM.set(0);  
    LM.set(0);
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
