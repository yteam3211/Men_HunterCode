// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private CANSparkMax LM = new CANSparkMax(Constants.SPARK_DRIVE_LM, MotorType.kBrushless);
  private CANSparkMax LS = new CANSparkMax(Constants.SPARK_DRIVE_LS, MotorType.kBrushless);
  private CANSparkMax RM = new CANSparkMax(Constants.SPARK_DRIVE_RM, MotorType.kBrushless);
  private CANSparkMax RS = new CANSparkMax(Constants.SPARK_DRIVE_RS, MotorType.kBrushless);

  public DriveTrain() {

    LM.follow(LS);
    RM.follow(RS);



  }

  @Override
  public void periodic() {
  }


}
