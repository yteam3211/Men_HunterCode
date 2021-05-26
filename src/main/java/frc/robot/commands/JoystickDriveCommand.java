
package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotButtons;
import frc.robot.subsystems.DriveTrain;

public class JoystickDriveCommand extends CommandBase {

  double leftOutput, rightOutput;

  DriveTrain driveTrain;
  Joystick joystick;

  public JoystickDriveCommand(DriveTrain driveTrain, Joystick joystick) {
    this.joystick = joystick;
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double xStick = joystick.getRawAxis(Constants.X_AXIS_DRIVE);
    double zStick = joystick.getRawAxis(Constants.Z_AXIS_DRIVE);
    
    leftOutput = xStick - zStick;
    rightOutput = xStick + zStick;

    if(Math.abs(leftOutput) > 1){
      leftOutput /= leftOutput;
      rightOutput /= leftOutput;
    }
    else if(Math.abs(rightOutput) > 1){
      leftOutput /= rightOutput;
      rightOutput /= rightOutput;
    }

    System.out.println("Left: " + leftOutput + "right:" + rightOutput);
    /*if(Math.abs(leftOutput) > 0.07 && Math.abs(rightOutput) > 0.07)*/ driveTrain.tank(leftOutput, rightOutput);
  }

  @Override
  public void end(boolean interrupted) {
    driveTrain.tank(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
