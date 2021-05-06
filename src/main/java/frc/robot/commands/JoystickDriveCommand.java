
package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class JoystickDriveCommand extends CommandBase {

  double xStick, zStick;
  double leftOutput, rightOutput;

  Joystick joystick;
  DriveTrain driveTrain;

  public JoystickDriveCommand(Joystick joystick, DriveTrain driveTrain) {
    this.joystick = joystick;
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    xStick = joystick.getRawAxis(Constants.X_AXIS_DRIVE);
    zStick = joystick.getRawAxis(Constants.Z_AXIS_DRIVE);

    leftOutput = xStick + zStick;
    rightOutput = xStick - zStick;

    driveTrain.tank(leftOutput, rightOutput);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
