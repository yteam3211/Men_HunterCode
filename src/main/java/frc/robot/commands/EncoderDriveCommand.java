package frc.robot.commands;

import com.revrobotics.CANEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gains;

public class EncoderDriveCommand extends CommandBase {
  private DriveTrain driveTrain;
  private double position;
  private double output;
  private double power;

  double error = 0;
  double lastError = 0;
  double sumError = 0;
  double pidOutput = 0;


  public EncoderDriveCommand(DriveTrain driveTrain, double position, double power) {
    this.driveTrain = driveTrain;
    this.position = position;
    this.power = power;
    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    error = position - driveTrain.getPosition();
    sumError += error;

    output = power * (error * driveTrain.gains.kp + sumError * driveTrain.gains.ki + (error - lastError) * driveTrain.gains.kd);



    lastError = error;
    driveTrain.setOutput(output);
  }

  @Override
  public void end(boolean interrupted) {
    driveTrain.stopOutput();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
